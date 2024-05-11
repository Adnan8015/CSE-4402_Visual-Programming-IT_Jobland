package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class JobPostController implements Initializable {
    public static String company_name;
    public static String job_title;
    public static String job_description;
    public static String location;
    public static String qualification;
    public static String salary;
    public static String posting_date;
    @FXML
    public TextField tf_company_name;

    @FXML
    public  TextField tf_job_title;

    @FXML
    public  TextArea ta_job_description;

    @FXML
    public  TextField tf_location;

    @FXML
    public  TextField tf_qualification;

    @FXML
    public  TextField tf_salary;

    @FXML
    public  TextField tf_posting_date;

    @FXML
    public Button button_post_job;

    @FXML
    public Button button_back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_post_job.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                company_name = tf_company_name.getText();
                //System.out.println(company_name);

                job_title = tf_job_title.getText();
                job_description = ta_job_description.getText();
                location = tf_location.getText();
                qualification = tf_qualification.getText();
                salary = tf_salary.getText();
                posting_date = tf_posting_date.getText();

                //System.out.println(job_title);

               DBUtils.AddJobPost(event,company_name,job_title,job_description, location, qualification, salary,posting_date);
                System.out.println(job_title);
            }
        });

        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"EmployerWelcome.fxml",null,null,null);
            }
        });

    }
}
