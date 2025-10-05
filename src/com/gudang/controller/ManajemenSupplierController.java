package com.gudang.controller;

import com.gudang.model.Supplier;
import com.gudang.view.EditSupplierView;
import com.gudang.view.ManajemenSupplierView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ManajemenSupplierController {
    private ManajemenSupplierView view;
    private ObservableList<Supplier> supplierList;

    public ManajemenSupplierController(ManajemenSupplierView view) {
        this.view = view;
        this.supplierList = FXCollections.observableArrayList();
        view.getTableView().setItems(supplierList);
        initializeController();
    }

    private void initializeController() {
        view.getBtnTambah().setOnAction(e -> handleTambah());
        view.getBtnEdit().setOnAction(e -> handleEdit());
        view.getBtnHapus().setOnAction(e -> handleHapus());
    }

    private void handleTambah() {
        String kode = view.getKodeSupplierField().getText().trim();
        String nama = view.getNamaSupplierField().getText().trim();
        String alamat = view.getAlamatField().getText().trim();
        String telepon = view.getNomorTeleponField().getText().trim();

        // Validasi field wajib
        if (kode.isEmpty() || nama.isEmpty() || telepon.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Mandatory field harus diisi!");
            return;
        }

        // Validasi kode unik
        for (Supplier supplier : supplierList) {
            if (supplier.getKodeSupplier().equalsIgnoreCase(kode)) {
                showAlert(Alert.AlertType.ERROR, "Error", "Kode supplier sudah ada!");
                return;
            }
        }

        // Tambah supplier baru
        Supplier supplier = new Supplier(kode, nama, alamat, telepon);
        supplierList.add(supplier);
        
        view.clearForm();
        view.getKodeSupplierField().requestFocus();
        
        showAlert(Alert.AlertType.INFORMATION, "Sukses", "Supplier berhasil ditambahkan!");
    }

    private void handleEdit() {
        Supplier selected = view.getTableView().getSelectionModel().getSelectedItem();
        
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih supplier yang ingin diedit!");
            return;
        }

        // Buka window edit
        EditSupplierView editView = new EditSupplierView(selected);
        new EditSupplierController(editView, view.getTableView());
        editView.show();
    }

    private void handleHapus() {
        Supplier selected = view.getTableView().getSelectionModel().getSelectedItem();
        
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih supplier yang ingin dihapus!");
            return;
        }

        // Alert konfirmasi dengan tombol Ya dan Tidak
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Konfirmasi Hapus");
        confirmAlert.setHeaderText("Hapus Supplier");
        confirmAlert.setContentText("Apakah Anda yakin ingin menghapus supplier: " + selected.getNamaSupplier() + "?");
        
        // Custom button Ya dan Tidak
        ButtonType btnYa = new ButtonType("Ya");
        ButtonType btnTidak = new ButtonType("Tidak");
        confirmAlert.getButtonTypes().setAll(btnYa, btnTidak);
        
        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == btnYa) {
                supplierList.remove(selected);
                view.clearForm();
                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Supplier berhasil dihapus!");
            }
        });
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}