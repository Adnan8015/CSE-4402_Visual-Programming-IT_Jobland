package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstPageController implements Initializable {

    @FXML
    public Button jobseeker_button;
    @FXML
    public Button employee_button;
    @FXML
    public Button employer_button;
    @FXML
    public Button button_admin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employee_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "hello-view.fxml", "Employee Page", null, null);
            }
        });
        employer_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"EmployerFirstPage.fxml",null,null,null);
            }
        });

        jobseeker_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "JobSeekerFirstPage.fxml",null,null,null);
            }
        });
        button_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "AdminLoginPage.fxml",null,null,null);
            }
        });

    }
}
