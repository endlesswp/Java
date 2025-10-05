package com.gudang.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {
    private Stage stage;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label errorLabel;

    public LoginView(Stage stage) {
        this.stage = stage;
        initializeView();
    }

    private void initializeView() {
        // Title
        Label titleLabel = new Label("Login Aplikasi Gudang");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Form
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        usernameField.setPromptText("Masukkan username");

        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        passwordField.setPromptText("Masukkan password");

        loginButton = new Button("Login");
        loginButton.setPrefWidth(200);

        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setVisible(false);

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);

        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(titleLabel, gridPane, loginButton, errorLabel);

        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.setResizable(false);
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public void show() {
        stage.show();
    }

    public void close() {
        stage.close();
    }
}
