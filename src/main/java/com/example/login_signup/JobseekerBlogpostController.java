package com.example.login_signup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class JobseekerBlogpostController implements Initializable {

    //    @FXML
//    public TableColumn col_employeeName;
//    @FXML
//    public TableColumn col_title;
//    @FXML
//    public TableColumn col_content;
    public static String TITLE;
    public static String CONTENT;
    public static String EMPLOYEENAME;

    @FXML
    public Button button_back;
    @FXML
    public TableView<JobseekerBlogpostModel> tv_tableview;
    @FXML
    public TableColumn<JobseekerBlogpostModel, String> col_employeeName;
    @FXML
    public TableColumn<JobseekerBlogpostModel, String> col_title;
    @FXML
    public TableColumn<JobseekerBlogpostModel, String> col_content;
    @FXML
    public TextField tf_searchbar;
    ObservableList<JobseekerBlogpostModel> jobseekerBlogpostModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "JobSeeker_JobOffers&BlogPosts.fxml", null, null, null);
            }
        });

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet queryOutput;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            preparedStatement = connection.prepareStatement("SELECT employee_name, title, content  FROM blogpost WHERE company_name = ?");
            preparedStatement.setString(1, JobSeekerCompaniesController.company_name);
            queryOutput = preparedStatement.executeQuery();
            while (queryOutput.next()) {
//                JobseekerBlogpostModelObservableList.add(new JobseekerBlogpostModel(queryOutput.getInt("")))
                String queryEmployeeName = queryOutput.getString("employee_name");
                String queryTitle = queryOutput.getString("title");
                String queryContent = queryOutput.getString("content");
                // Populating the observable list
                jobseekerBlogpostModelObservableList.add(new JobseekerBlogpostModel(queryEmployeeName, queryTitle, queryContent));
            }
            col_employeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
            col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
            col_content.setCellValueFactory(new PropertyValueFactory<>("content"));
            tv_tableview.setItems(jobseekerBlogpostModelObservableList);

            FilteredList<JobseekerBlogpostModel> filteredData = new FilteredList<>(jobseekerBlogpostModelObservableList, b -> true);

            tf_searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(JobseekerBlogpostModel -> {
                    if (newValue.isBlank() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (JobseekerBlogpostModel.getContent().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (JobseekerBlogpostModel.getTitle().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    }
                    else {
                        return false;
                    }
                });
            });




            SortedList<JobseekerBlogpostModel> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(tv_tableview.comparatorProperty());

            tv_tableview.setItems(sortedData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    public void onRowSelected(MouseEvent mouseEvent){
        Integer index = tv_tableview.getSelectionModel().getSelectedIndex();
        if(index<= -1){
            return;
        }

        EMPLOYEENAME = col_employeeName.getCellData(index).toString();
        TITLE = col_title.getCellData(index).toString();
        CONTENT = col_content.getCellData(index).toString();
        DBUtils.changeScene_mouse(mouseEvent,"JobseekerBlogpostView.fxml", null, null, null);

        System.out.println(EMPLOYEENAME);
        System.out.println(TITLE);
        System.out.println(CONTENT);
    }
}
