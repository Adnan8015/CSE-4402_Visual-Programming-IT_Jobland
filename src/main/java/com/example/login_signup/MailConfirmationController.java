package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.net.URL;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.util.Properties;
import java.util.UUID;
import java.sql.*;

public class MailConfirmationController implements Initializable {

    @FXML
    public Button button_back;

    @FXML
    public Button button_confirm_ver_code;

    @FXML
    public PasswordField pf_ver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_confirm_ver_code.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                int verCode = MyEmail.randomNumber;

                System.out.println("MailConfirmationController theke bolchi aage : " + verCode);

                String verificationCodeString = pf_ver.getText().trim();
                System.out.println( "Verification code jeita user likhse: " + verificationCodeString);
                if(Integer.parseInt(verificationCodeString) == verCode)
                {
                    DBUtils.changeScene(event, "resetPassword.fxml", "Reset koren", null, null);
                    System.out.println("MailConfirmationController theke bolchi aage (if er vitor) : " + verCode);

                }
                System.out.println("MailConfirmationController theke bolchi if er pore : " + verCode);

            }
        });

        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"fp.fxml",null,null,null);
            }
        });

    }
}

