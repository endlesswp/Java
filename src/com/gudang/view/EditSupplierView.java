package com.gudang.view;

import com.gudang.model.Supplier;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditSupplierView {
    private Stage stage;
    private TextField kodeSupplierField;
    private TextField namaSupplierField;
    private TextField alamatField;
    private TextField nomorTeleponField;
    private Button btnUpdate;
    private Supplier supplier;

    public EditSupplierView(Supplier supplier) {
        this.stage = new Stage();
        this.supplier = supplier;
        initializeView();
    }

    private void initializeView() {
        // Title
        Label titleLabel = new Label("Edit Supplier");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Form Input
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(10));

        Label kodeLabel = new Label("Kode Supplier:");
        kodeSupplierField = new TextField(supplier.getKodeSupplier());
        kodeSupplierField.setEditable(false);
        kodeSupplierField.setStyle("-fx-background-color: #e0e0e0;");
        kodeSupplierField.setPrefWidth(250);

        Label namaLabel = new Label("Nama Supplier:");
        namaSupplierField = new TextField(supplier.getNamaSupplier());
        namaSupplierField.setPrefWidth(250);

        Label alamatLabel = new Label("Alamat:");
        alamatField = new TextField(supplier.getAlamat());
        alamatField.setPrefWidth(250);

        Label teleponLabel = new Label("Nomor Telepon:");
        nomorTeleponField = new TextField(supplier.getNomorTelepon());
        nomorTeleponField.setPrefWidth(250);

        btnUpdate = new Button("Update");
        btnUpdate.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        btnUpdate.setPrefWidth(120);

        formGrid.add(kodeLabel, 0, 0);
        formGrid.add(kodeSupplierField, 1, 0);
        formGrid.add(namaLabel, 0, 1);
        formGrid.add(namaSupplierField, 1, 1);
        formGrid.add(alamatLabel, 0, 2);
        formGrid.add(alamatField, 1, 2);
        formGrid.add(teleponLabel, 0, 3);
        formGrid.add(nomorTeleponField, 1, 3);
        formGrid.add(btnUpdate, 1, 4);

        // Layout
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(titleLabel, formGrid);

        Scene scene = new Scene(vbox, 450, 300);
        stage.setScene(scene);
        stage.setTitle("Edit Supplier");
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

    public Button getBtnUpdate() {
        return btnUpdate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void show() {
        stage.show();
    }

    public void close() {
        stage.close();
    }
}
