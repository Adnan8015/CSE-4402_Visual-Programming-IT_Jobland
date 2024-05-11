package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public static String USERNAME;
    public static String PASSWORD;

    @FXML
    public Button button_forget_password;
    @FXML
    public Button button_login;
    @FXML
    public Button button_sign_up;
    @FXML
    public TextField tf_username;
    @FXML
    public PasswordField pf_password;
    public Button button_backToFirstPage;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                USERNAME = tf_username.getText();
                PASSWORD = tf_username.getText();

                DBUtils.logInUser(actionEvent, USERNAME, pf_password.getText());
            }
        });
        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                DBUtils.changeScene(actionEvent, "signup.fxml", "Sign Up!", null, null);
            }
        });

        button_forget_password.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"fp.fxml","forget password",null,null);
            }
        });
        button_backToFirstPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "firstPage.fxml", "Welcome", null, null);
            }
        });
    }
}