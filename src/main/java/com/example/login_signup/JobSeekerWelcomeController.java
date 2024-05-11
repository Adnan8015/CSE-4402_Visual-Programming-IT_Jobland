package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class JobSeekerWelcomeController implements Initializable {

    @FXML
    public Button button_company_list;

    @FXML
    public Button button_search_pref;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_company_list.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

    }
}
