package com.gudang.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuUtamaView {
    private Stage stage;
    private Button btnManajemenBarang;
    private Button btnManajemenSupplier;
    private Button btnManajemenCustomer;

    public MenuUtamaView(Stage stage) {
        this.stage = stage;
        initializeView();
    }

    private void initializeView() {
        // Title
        Label titleLabel = new Label("Menu Utama");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Buttons
        btnManajemenBarang = new Button("Manajemen Barang");
        btnManajemenBarang.setPrefWidth(250);
        btnManajemenBarang.setPrefHeight(50);
        btnManajemenBarang.setStyle("-fx-font-size: 14px;");

        btnManajemenSupplier = new Button("Manajemen Supplier");
        btnManajemenSupplier.setPrefWidth(250);
        btnManajemenSupplier.setPrefHeight(50);
        btnManajemenSupplier.setStyle("-fx-font-size: 14px;");

        btnManajemenCustomer = new Button("Manajemen Customer");
        btnManajemenCustomer.setPrefWidth(250);
        btnManajemenCustomer.setPrefHeight(50);
        btnManajemenCustomer.setStyle("-fx-font-size: 14px;");

        // Layout
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(40));
        vbox.getChildren().addAll(
            titleLabel,
            btnManajemenBarang,
            btnManajemenSupplier,
            btnManajemenCustomer
        );

        Scene scene = new Scene(vbox, 450, 400);
        stage.setScene(scene);
        stage.setTitle("Menu Utama");
        stage.setResizable(false);
    }

    public Button getBtnManajemenBarang() {
        return btnManajemenBarang;
    }

    public Button getBtnManajemenSupplier() {
        return btnManajemenSupplier;
    }

    public Button getBtnManajemenCustomer() {
        return btnManajemenCustomer;
    }

    public void show() {
        stage.show();
    }
}