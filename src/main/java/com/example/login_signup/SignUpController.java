//package com.example.login_signup;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class SignUpController implements Initializable {
//    public static String signUpUsername;
//    @FXML
//    public TextField tf_username;
//    @FXML
//    public TextField tf_password;
//    @FXML
//    public Button button_login;
//    @FXML
//    public Button button_sign_up;
//    @FXML
//    public RadioButton rb_wittcode;
//    @FXML
//    public RadioButton rb_someone_else;
//    @FXML
//    public PasswordField pf_password;
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//
//        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//                if(!tf_username.getText().trim().isEmpty() && !pf_password.getText().trim().isEmpty())
//                {
////                    System.out.println("aage" + signUpUsername);
//                    signUpUsername = tf_username.getText();
////                    System.out.println("pore" + signUpUsername);
//                    DBUtils.signUpUser(actionEvent, signUpUsername, pf_password.getText());
//                }
//                else
//                {
//                    System.out.println("Please fill in all information");
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setContentText("Please fill in all information to sign up");
//                    alert.show();
//                }
//            }
//        });
//
//        button_login.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                DBUtils.changeScene(actionEvent,"hello-view.fxml", "Sign Up", null, null);
//            }
//        });
//    }
//}


//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.login_signup;

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

public class SignUpController implements Initializable {
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


    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if (!SignUpController.this.tf_username.getText().trim().isEmpty() && !SignUpController.this.pf_password.getText().trim().isEmpty()) {
                    SignUpController.signUpUsername = SignUpController.this.tf_username.getText();
                    DBUtils.signUpUser(actionEvent, SignUpController.signUpUsername, SignUpController.this.pf_password.getText(), SignUpController.this.tf_company_name.getText(), SignUpController.this.pf_company_code.getText());
                } else {
                    System.out.println("Please fill in all information");
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sign up");
                    alert.show();
                }

            }
        });
        this.button_login.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent, "hello-view.fxml", "Sign Up", (String)null, (String)null);
            }
        });
    }
}
