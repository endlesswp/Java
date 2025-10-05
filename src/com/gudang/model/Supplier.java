package com.gudang.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Supplier {
    private final StringProperty kodeSupplier;
    private final StringProperty namaSupplier;
    private final StringProperty alamat;
    private final StringProperty nomorTelepon;

    public Supplier(String kodeSupplier, String namaSupplier, String alamat, String nomorTelepon) {
        this.kodeSupplier = new SimpleStringProperty(kodeSupplier);
        this.namaSupplier = new SimpleStringProperty(namaSupplier);
        this.alamat = new SimpleStringProperty(alamat);
        this.nomorTelepon = new SimpleStringProperty(nomorTelepon);
    }

    // Getter dan Setter untuk kodeSupplier
    public String getKodeSupplier() {
        return kodeSupplier.get();
    }

    public void setKodeSupplier(String kodeSupplier) {
        this.kodeSupplier.set(kodeSupplier);
    }

    public StringProperty kodeSupplierProperty() {
        return kodeSupplier;
    }

    // Getter dan Setter untuk namaSupplier
    public String getNamaSupplier() {
        return namaSupplier.get();
    }

    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier.set(namaSupplier);
    }

    public StringProperty namaSupplierProperty() {
        return namaSupplier;
    }

    // Getter dan Setter untuk alamat
    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public StringProperty alamatProperty() {
        return alamat;
    }

    // Getter dan Setter untuk nomorTelepon
    public String getNomorTelepon() {
        return nomorTelepon.get();
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon.set(nomorTelepon);
    }

    public StringProperty nomorTeleponProperty() {
        return nomorTelepon;
    }
}