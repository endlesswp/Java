package com.gudang.controller;

import com.gudang.model.Supplier;
import com.gudang.view.EditSupplierView;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

public class EditSupplierController {
    private EditSupplierView view;
    private TableView<Supplier> tableView;

    public EditSupplierController(EditSupplierView view, TableView<Supplier> tableView) {
        this.view = view;
        this.tableView = tableView;
        initializeController();
    }

    private void initializeController() {
        view.getBtnUpdate().setOnAction(e -> handleUpdate());
    }

    private void handleUpdate() {
        String nama = view.getNamaSupplierField().getText().trim();
        String alamat = view.getAlamatField().getText().trim();
        String telepon = view.getNomorTeleponField().getText().trim();

        // Validasi field wajib
        if (nama.isEmpty() || telepon.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Mandatory field harus diisi!");
            return;
        }

        // Update data supplier
        Supplier supplier = view.getSupplier();
        supplier.setNamaSupplier(nama);
        supplier.setAlamat(alamat);
        supplier.setNomorTelepon(telepon);
        
        // Refresh table
        tableView.refresh();
        
        showAlert(Alert.AlertType.INFORMATION, "Sukses", "Supplier berhasil diupdate!");
        view.close();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}