package com.example.login_signup;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.net.URL;
import java.util.ResourceBundle;


public class ResetPasswordController implements Initializable {
    public static String RESETPASSWORD;
    @FXML
    public Button button_resetPassword;
    @FXML
    public PasswordField pf_newPassword;
    @FXML
    public PasswordField pf_confirmPassword;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_resetPassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String pf_newpwd = pf_newPassword.getText().trim();
                RESETPASSWORD = pf_newPassword.getText().trim();
                String pf_confirmpwd = pf_confirmPassword.getText().trim();
                System.out.println(pf_newpwd);
                System.out.println(pf_confirmpwd);
                if (pf_newpwd.equals(pf_confirmpwd))
                {
                    System.out.println("equality checked");
                    DBUtils.updatePassword(event, FpController.SENDMAILTOTHISADDRESS, RESETPASSWORD);
                }
                else {
                    DBUtils.changeScene(event, "resetPassword.fxml", "Reset Password", null, null);
                }
            }
        });

    }
}
