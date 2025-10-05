package com.gudang.view;

import com.gudang.model.Barang;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManajemenBarangView {
    private Stage stage;
    private TextField namaBarangField;
    private TextField jumlahField;
    private Button btnTambah;
    private TableView<Barang> tableView;
    private Button btnEdit;
    private Button btnHapus;

    public ManajemenBarangView() {
        this.stage = new Stage();
        initializeView();
    }

    private void initializeView() {
        // Title
        Label titleLabel = new Label("Manajemen Barang");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Form Input
        Label namaLabel = new Label("Nama Barang:");
        namaBarangField = new TextField();
        namaBarangField.setPromptText("Masukkan nama barang");
        namaBarangField.setPrefWidth(200);

        Label jumlahLabel = new Label("Jumlah:");
        jumlahField = new TextField();
        jumlahField.setPromptText("Masukkan jumlah");
        jumlahField.setPrefWidth(200);

        btnTambah = new Button("Tambah");
        btnTambah.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        HBox formBox = new HBox(10);
        formBox.getChildren().addAll(namaLabel, namaBarangField, jumlahLabel, jumlahField, btnTambah);
        formBox.setStyle("-fx-padding: 10; -fx-background-color: #f0f0f0;");

        // Table
        tableView = new TableView<>();
        TableColumn<Barang, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        namaCol.setPrefWidth(300);

        TableColumn<Barang, Integer> jumlahCol = new TableColumn<>("Jumlah");
        jumlahCol.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        jumlahCol.setPrefWidth(200);

        tableView.getColumns().addAll(namaCol, jumlahCol);
        tableView.setPrefHeight(300);

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
        vbox.getChildren().addAll(titleLabel, formBox, tableView, buttonBox);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Manajemen Barang");
    }

    public TextField getNamaBarangField() {
        return namaBarangField;
    }

    public TextField getJumlahField() {
        return jumlahField;
    }

    public Button getBtnTambah() {
        return btnTambah;
    }

    public TableView<Barang> getTableView() {
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
        namaBarangField.clear();
        jumlahField.clear();
    }
}
