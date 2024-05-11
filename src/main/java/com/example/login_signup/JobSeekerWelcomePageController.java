package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JobSeekerWelcomePageController implements Initializable {
    @FXML
    public Button button_companies;
    @FXML
    public Button button_searchbypref;
    @FXML
    public Button button_logout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_companies.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button_companies.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        DBUtils.changeScene(event, "JobSeeker_Companies.fxml", null, null, null);
                    }
                });
            }
        });
        button_searchbypref.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent root = null;

                try{
                    root = FXMLLoader.load(DBUtils.class.getResource("JobPostings.fxml"));
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                stage.setScene(new Scene(root));
                stage.show();
            }
        });
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "firstPage.fxml", null, null, null);
            }
        });
    }
}
