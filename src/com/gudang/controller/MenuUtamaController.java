package com.gudang.controller;

import com.gudang.view.ManajemenBarangView;
import com.gudang.view.ManajemenSupplierView;
import com.gudang.view.MenuUtamaView;
import javafx.scene.control.Alert;

public class MenuUtamaController {
    private MenuUtamaView view;

    public MenuUtamaController(MenuUtamaView view) {
        this.view = view;
        initializeController();
    }

    private void initializeController() {
        view.getBtnManajemenBarang().setOnAction(e -> openManajemenBarang());
        view.getBtnManajemenSupplier().setOnAction(e -> openManajemenSupplier());
        view.getBtnManajemenCustomer().setOnAction(e -> showCustomerInfo());
    }

    private void openManajemenBarang() {
        ManajemenBarangView barangView = new ManajemenBarangView();
        new ManajemenBarangController(barangView);
        barangView.show();
    }

    private void openManajemenSupplier() {
        ManajemenSupplierView supplierView = new ManajemenSupplierView();
        new ManajemenSupplierController(supplierView);
        supplierView.show();
    }

    private void showCustomerInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Manajemen Customer");
        alert.setContentText("Fitur ini tidak tersedia untuk NPM Ganjil");
        alert.showAndWait();
    }
}
