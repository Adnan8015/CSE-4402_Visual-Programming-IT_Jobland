package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployerWelcomeController implements Initializable {

    @FXML
    Button button_addJob;

    @FXML
    Button button_jobList;

    @FXML
    Button button_myProfile;

    @FXML
    Button button_resetPassword;

    @FXML
    public Button button_logout;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_addJob.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"jobPost.fxml",null,null,null);
            }
        });
        button_myProfile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "Employer_MyProfile.fxml", null, null, null);
            }
        });

        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"EmployerFirstPage.fxml",null,null,null);
            }
        });
        button_jobList.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "EmployerJobList.fxml", null, null, null);
            }
        });

    }
}
