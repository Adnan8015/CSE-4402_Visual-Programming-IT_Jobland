package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminLoginPageController implements Initializable {

    @FXML
    public Button button_back;

    @FXML
    public Button button_login;
    @FXML
    public TextField tf_email;
    @FXML
    public PasswordField pf_password;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = tf_email.getText();
                String password = pf_password.getText();
                System.out.println(username);
                System.out.println(password);
                DBUtils.logInAdmin(event,username,password);
            }
        });

        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "firstPage.fxml", null,null,null);
            }
        });
    }
}
