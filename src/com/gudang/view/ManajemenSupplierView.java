package com.gudang.view;

import com.gudang.model.Supplier;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManajemenSupplierView {
    private Stage stage;
    private TextField kodeSupplierField;
    private TextField namaSupplierField;
    private TextField alamatField;
    private TextField nomorTeleponField;
    private Button btnTambah;
    private TableView<Supplier> tableView;
    private Button btnEdit;
    private Button btnHapus;

    public ManajemenSupplierView() {
        this.stage = new Stage();
        initializeView();
    }

    private void initializeView() {
        // Title
        Label titleLabel = new Label("Manajemen Supplier");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Form Input
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(10));
        formGrid.setStyle("-fx-background-color: #f0f0f0;");

        Label kodeLabel = new Label("Kode Supplier:");
        kodeSupplierField = new TextField();
        kodeSupplierField.setPromptText("Kode (wajib & unik)");
        kodeSupplierField.setPrefWidth(200);

        Label namaLabel = new Label("Nama Supplier:");
        namaSupplierField = new TextField();
        namaSupplierField.setPromptText("Nama (wajib)");
        namaSupplierField.setPrefWidth(200);

        Label alamatLabel = new Label("Alamat:");
        alamatField = new TextField();
        alamatField.setPromptText("Alamat (opsional)");
        alamatField.setPrefWidth(200);

        Label teleponLabel = new Label("Nomor Telepon:");
        nomorTeleponField = new TextField();
        nomorTeleponField.setPromptText("Telepon (wajib)");
        nomorTeleponField.setPrefWidth(200);

        btnTambah = new Button("Tambah");
        btnTambah.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        btnTambah.setPrefWidth(100);

        formGrid.add(kodeLabel, 0, 0);
        formGrid.add(kodeSupplierField, 1, 0);
        formGrid.add(namaLabel, 0, 1);
        formGrid.add(namaSupplierField, 1, 1);
        formGrid.add(alamatLabel, 0, 2);
        formGrid.add(alamatField, 1, 2);
        formGrid.add(teleponLabel, 0, 3);
        formGrid.add(nomorTeleponField, 1, 3);
        formGrid.add(btnTambah, 1, 4);

        // Table
        tableView = new TableView<>();
        
        TableColumn<Supplier, String> kodeCol = new TableColumn<>("Kode Supplier");
        kodeCol.setCellValueFactory(new PropertyValueFactory<>("kodeSupplier"));
        kodeCol.setPrefWidth(120);

        TableColumn<Supplier, String> namaCol = new TableColumn<>("Nama Supplier");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("namaSupplier"));
        namaCol.setPrefWidth(180);

        TableColumn<Supplier, String> alamatCol = new TableColumn<>("Alamat");
        alamatCol.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        alamatCol.setPrefWidth(200);

        TableColumn<Supplier, String> teleponCol = new TableColumn<>("Nomor Telepon");
        teleponCol.setCellValueFactory(new PropertyValueFactory<>("nomorTelepon"));
        teleponCol.setPrefWidth(150);

        tableView.getColumns().addAll(kodeCol, namaCol, alamatCol, teleponCol);
        tableView.setPrefHeight(250);

        // Action Buttons
        btnEdit = new Button("Edit");
        btnEdit.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        btnEdit.setPrefWidth(100);

        btnHapus = new Button("Hapus");
        btnHapus.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
        btnHapus.setPrefWidth(100);

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(btnEdit, btnHapus);
        buttonBox.setStyle("-fx-padding: 10;");

        // Layout
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(titleLabel, formGrid, tableView, buttonBox);

        Scene scene = new Scene(vbox, 700, 600);
        stage.setScene(scene);
        stage.setTitle("Manajemen Supplier");
    }

    public TextField getKodeSupplierField() {
        return kodeSupplierField;
    }

    public TextField getNamaSupplierField() {
        return namaSupplierField;
    }

    public TextField getAlamatField() {
        return alamatField;
    }

    public TextField getNomorTeleponField() {
        return nomorTeleponField;
    }

    public Button getBtnTambah() {
        return btnTambah;
    }

    public TableView<Supplier> getTableView() {
        return tableView;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public Button getBtnHapus() {
        return btnHapus;
    }

    public void show() {
        stage.show();
    }

    public void clearForm() {
        kodeSupplierField.clear();
        namaSupplierField.clear();
        alamatField.clear();
        nomorTeleponField.clear();
    }
}
