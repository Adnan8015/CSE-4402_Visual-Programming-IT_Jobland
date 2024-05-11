package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class EmployerSignUpController implements Initializable {

        public static String signUpUsername;
        @FXML
        public TextField tf_username;
        @FXML
        public TextField tf_password;
        @FXML
        public Button button_login;
        @FXML
        public Button button_sign_up;
        @FXML
        public PasswordField pf_password;
        @FXML
        public TextField tf_company_name;
        @FXML
        public PasswordField pf_company_code;

        @FXML
        public TextField tf_designation;



        public void initialize(URL url, ResourceBundle resourceBundle) {
            this.button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent actionEvent) {
                    if (!EmployerSignUpController.this.tf_username.getText().trim().isEmpty() && !EmployerSignUpController.this.pf_password.getText().trim().isEmpty()) {
                        EmployerSignUpController.signUpUsername = EmployerSignUpController.this.tf_username.getText();
                        DBUtils.signUpEmployer(actionEvent, EmployerSignUpController.signUpUsername, EmployerSignUpController.this.pf_password.getText(), EmployerSignUpController.this.tf_company_name.getText(), EmployerSignUpController.this.pf_company_code.getText(),EmployerSignUpController.this.tf_designation.getText());
                    } else {
                        System.out.println("Please fill in all information");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Please fill in all information to sign up");
                        alert.show();
                    }

                }
            });
            this.button_login.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent actionEvent) {
                    DBUtils.changeScene(actionEvent, "EmployerFirstPage.fxml", "Sign Up", (String)null, (String)null);
                }
            });
        }
    }

