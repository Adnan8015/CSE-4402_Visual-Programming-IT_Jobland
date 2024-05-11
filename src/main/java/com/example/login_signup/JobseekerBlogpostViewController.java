package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class JobseekerBlogpostViewController implements Initializable {
    @FXML
    public ScrollPane scrollpane_viewblog;
    @FXML
    public Button button_back;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Text text = new Text("Employee Name: " + JobseekerBlogpostController.EMPLOYEENAME + "\n\n" + "Title: " + JobseekerBlogpostController.TITLE + "\n\n" + "Content: " + JobseekerBlogpostController.CONTENT + "\n\n");
        scrollpane_viewblog.setContent(text);
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "JobseekerBlogpost.fxml", null, null, null);
            }
        });
    }
}
