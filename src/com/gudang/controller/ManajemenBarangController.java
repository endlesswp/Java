package com.gudang.controller;

import com.gudang.model.Barang;
import com.gudang.view.ManajemenBarangView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class ManajemenBarangController {
    private ManajemenBarangView view;
    private ObservableList<Barang> barangList;
    private Barang selectedBarang;
    private boolean isEditMode = false;

    public ManajemenBarangController(ManajemenBarangView view) {
        this.view = view;
        this.barangList = FXCollections.observableArrayList();
        view.getTableView().setItems(barangList);
        initializeController();
    }

    private void initializeController() {
        view.getBtnTambah().setOnAction(e -> handleTambahOrUpdate());
        view.getBtnEdit().setOnAction(e -> handleEdit());
        view.getBtnHapus().setOnAction(e -> handleHapus());
        
        // Double click untuk edit
        view.getTableView().setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                handleEdit();
            }
        });
    }

    private void handleTambahOrUpdate() {
        String nama = view.getNamaBarangField().getText().trim();
        String jumlahStr = view.getJumlahField().getText().trim();

        // Validasi input
        if (nama.isEmpty() || jumlahStr.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Semua field harus diisi!");
            return;
        }

        int jumlah;
        try {
            jumlah = Integer.parseInt(jumlahStr);
            if (jumlah < 0) {
                showAlert(Alert.AlertType.ERROR, "Error", "Jumlah harus bilangan positif!");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Jumlah harus berupa angka!");
            return;
        }

        if (isEditMode && selectedBarang != null) {
            // Mode edit - update data
            selectedBarang.setNama(nama);
            selectedBarang.setJumlah(jumlah);
            view.getTableView().refresh();
            isEditMode = false;
            selectedBarang = null;
            view.getBtnTambah().setText("Tambah");
        } else {
            // Mode tambah - tambah data baru
            Barang barang = new Barang(nama, jumlah);
            barangList.add(barang);
        }

        view.clearForm();
        view.getNamaBarangField().requestFocus();
    }

    private void handleEdit() {
        selectedBarang = view.getTableView().getSelectionModel().getSelectedItem();
        
        if (selectedBarang == null) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih barang yang ingin diedit!");
            return;
        }

        // Isi form dengan data yang dipilih
        view.getNamaBarangField().setText(selectedBarang.getNama());
        view.getJumlahField().setText(String.valueOf(selectedBarang.getJumlah()));
        
        isEditMode = true;
        view.getBtnTambah().setText("Update");
        view.getNamaBarangField().requestFocus();
    }

    private void handleHapus() {
        Barang selected = view.getTableView().getSelectionModel().getSelectedItem();
        
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih barang yang ingin dihapus!");
            return;
        }

        // Konfirmasi hapus
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Konfirmasi Hapus");
        confirmAlert.setHeaderText("Hapus Barang");
        confirmAlert.setContentText("Apakah Anda yakin ingin menghapus barang: " + selected.getNama() + "?");
        
        confirmAlert.showAndWait().ifPresent(response -> {
            if (response.getText().equals("OK")) {
                barangList.remove(selected);
                view.clearForm();
                
                // Reset edit mode jika barang yang dihapus sedang diedit
                if (isEditMode && selectedBarang == selected) {
                    isEditMode = false;
                    selectedBarang = null;
                    view.getBtnTambah().setText("Tambah");
                }
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
