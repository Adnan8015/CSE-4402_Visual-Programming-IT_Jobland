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
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    public Button button_logout;
    @FXML
    public Label label_welcome;
    @FXML
    public Button button_blogpost;
    @FXML
    public Label label_fav_channel;

    @FXML
    public Button button_searchjob;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "hello-view.fxml", "Hello!", null, null);
            }
        });
        button_blogpost.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent, "blogpost.fxml", "Hello!", null, null);
            }
        });


        //    public void setUserInformation(String username, String favChannel) {
//    }
      // public void setUserInformation (String username, String favChannel){
           // label_welcome.setText("Welcome " + username + "");
////        label_fav_channel.setText("Your fav channel is " + favChannel + "!");
       // }

        button_searchjob.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent root = null;

                try {
                    root = FXMLLoader.load(DBUtils.class.getResource("EmployeeJobPostings.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                stage.setScene(new Scene(root));
                stage.show();
            }
        });
    }
}
