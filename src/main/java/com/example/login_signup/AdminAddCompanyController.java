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

public class AdminAddCompanyController implements Initializable {

    @FXML
    public Button button_back;

    @FXML
    public Button button_add;

    @FXML
    public TextField tf_company_name;

    @FXML
    public PasswordField pf_company_code;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println(tf_company_name.getText());
                //System.out.println(pf_company_code.getText());
                DBUtils.addCompany(event, tf_company_name.getText(),pf_company_code.getText());
            }
        });

        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"AdminWelcome.fxml",null,null,null);
            }
        });
    }
}
