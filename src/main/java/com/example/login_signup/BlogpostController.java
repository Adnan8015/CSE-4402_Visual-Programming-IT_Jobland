package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BlogpostController implements Initializable {
    public static String p = HelloController.USERNAME;
    @FXML
    public Button button_back;
    @FXML
    public Button button_submit;
    @FXML
    public TextField tf_title;
    @FXML
    public TextArea ta_content;



    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                System.out.println("name : " +p );
                if(!tf_title.getText().trim().isEmpty() && !ta_content.getText().trim().isEmpty())
                {
                    DBUtils.writeYourBlogPost(actionEvent, HelloController.USERNAME, tf_title.getText(), ta_content.getText() );
                }
                else
                {
                    System.out.println("Please fill in all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sign up");
                    alert.show();
                }
            }
        });
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "loggedin.fxml", "Logged In....", null, null);
            }
        });
    }

}

