package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminWelcomeController implements Initializable {

    @FXML
    public Button button_add_company;

    @FXML
    public Button button_logout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_add_company.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "AdminAddCompany.fxml",null,null,null);
            }
        });

        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"firstPage.fxml",null,null,null);
            }
        });
    }
}
