package com.gudang.controller;

import com.gudang.view.LoginView;
import com.gudang.view.MenuUtamaView;
import javafx.stage.Stage;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
        initializeController();
    }

    private void initializeController() {
        view.getLoginButton().setOnAction(e -> handleLogin());
        
        // Enter key untuk login
        view.getPasswordField().setOnAction(e -> handleLogin());
    }

    private void handleLogin() {
        String username = view.getUsernameField().getText();
        String password = view.getPasswordField().getText();

        if (username.equals("admin") && password.equals("123")) {
            // Login berhasil
            view.getErrorLabel().setVisible(false);
            view.close();
            
            // Buka halaman menu utama
            Stage menuStage = new Stage();
            MenuUtamaView menuView = new MenuUtamaView(menuStage);
            new MenuUtamaController(menuView);
            menuView.show();
        } else {
            // Login gagal
            view.getErrorLabel().setText("Login gagal!");
            view.getErrorLabel().setVisible(true);
        }
    }
}
