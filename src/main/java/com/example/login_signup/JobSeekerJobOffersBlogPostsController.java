package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class JobSeekerJobOffersBlogPostsController implements Initializable {
    public static int P = 0;
    @FXML
    public Button button_blogpost;
    @FXML
    public Button button_joboffers;
    @FXML
    public Label label_companyName;
    @FXML
    public Button button_back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label_companyName.setText(JobSeekerCompaniesController.company_name);
        button_blogpost.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "JobseekerBlogpost.fxml", null, null, null);
            }
        });
        button_joboffers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "JobSeeker_JobPostingsParticularCompany.fxml",null, null, null);
            }
        });
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "JobSeeker_Companies.fxml", null, null, null);
            }
        });
    }
}
