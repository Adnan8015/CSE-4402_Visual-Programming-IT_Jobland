package com.example.login_signup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class JobSeeker_JobPostingsParticularCompany implements Initializable {
    public static String company_name ;
    public static String job_title ;
    public static String job_description ;
    public static String location ;
    public static String qualification ;
    public static String salary_range ;
    public static String posting_date ;

    public static Integer jobPostID;
    @FXML
    public TableView<JobSearchModel> tv_jobtable;
    @FXML
    public TableColumn<JobSearchModel, String> col_companyName;
    @FXML
    public TableColumn<JobSearchModel, String> col_jobtitle;
    @FXML
    public TableColumn<JobSearchModel, String> col_jobdesc;
    @FXML
    public TableColumn<JobSearchModel, String> col_location;
    @FXML
    public TableColumn<JobSearchModel, String> col_qualification;
    @FXML

    public TableColumn<JobSearchModel, String> col_salaryrange;
    @FXML
    public TableColumn<JobSearchModel, String> col_postingdate;
    @FXML
    public TableColumn<JobSearchModel, Integer> col_jobPostID;
//    @FXML
//    public TableColumn col_jobPostID;
    @FXML
    public TextField tf_searchbar;
    @FXML
    public Button button_back;
    public TableColumn col_AddCV;


    ObservableList<JobSearchModel> jobSearchModelObservableList = FXCollections.observableArrayList();
    ObservableList<JobSearchModel> jobSearchModelObservableList2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent root = null;

                try{
                    root = FXMLLoader.load(DBUtils.class.getResource("JobSeeker_JobOffers&BlogPosts.fxml"));
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


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet queryOutput ;

//        String jobViewQuery = "SELECT company_name, job_title, job_description, location, qualification, salary_range, post_date  FROM jobpost";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            preparedStatement = connection.prepareStatement("SELECT company_name, job_title, job_description, location, qualification, salary_range, post_date, job_post_id  FROM jobpost WHERE company_name = ?");
            preparedStatement.setString(1, JobSeekerCompaniesController.company_name);
            queryOutput = preparedStatement.executeQuery();
            while (queryOutput.next()) {
//                jobSearchModelObservableList.add(new JobSearchModel(queryOutput.getInt("")))
                String queryCompanyName = queryOutput.getString("company_name");
                String queryJobTitle = queryOutput.getString("job_title");
                String queryJobDesc = queryOutput.getString("job_description");
                String queryLocation = queryOutput.getString("location");
                String queryQualifications = queryOutput.getString("qualification");
                String querySalary = queryOutput.getString("salary_range");
                String queryDate = queryOutput.getString("post_date");
                String queryJobPostID = String.valueOf(queryOutput.getInt("job_post_id"));
                // Populating the observable list
                jobSearchModelObservableList.add(new JobSearchModel(null, null, queryCompanyName, queryJobTitle, queryJobDesc, queryLocation, queryQualifications, querySalary, queryDate, null, queryJobPostID));
            }

            col_companyName.setCellValueFactory(new PropertyValueFactory<>("company_name"));
            col_jobtitle.setCellValueFactory(new PropertyValueFactory<>("job_title"));
            col_jobdesc.setCellValueFactory(new PropertyValueFactory<>("job_description"));
            col_location.setCellValueFactory(new PropertyValueFactory<>("location"));
            col_qualification.setCellValueFactory(new PropertyValueFactory<>("qualifications"));
            col_salaryrange.setCellValueFactory(new PropertyValueFactory<>("salary_range"));
            col_postingdate.setCellValueFactory(new PropertyValueFactory<>("posting_date"));
            col_jobPostID.setCellValueFactory(new PropertyValueFactory<>("jobPostID"));
            tv_jobtable.setItems(jobSearchModelObservableList);



            FilteredList<JobSearchModel> filteredData = new FilteredList<>(jobSearchModelObservableList, b -> true);

            tf_searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(jobSearchModel -> {
                    if (newValue.isBlank() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (jobSearchModel.getCompany_name().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (jobSearchModel.getJob_title().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (jobSearchModel.getLocation().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (jobSearchModel.getQualifications().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (jobSearchModel.getSalary_range().toString().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (jobSearchModel.getPosting_date().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });




            SortedList<JobSearchModel> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(tv_jobtable.comparatorProperty());

            tv_jobtable.setItems(sortedData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onRowSelected(MouseEvent mouseEvent){
        Integer index = tv_jobtable.getSelectionModel().getSelectedIndex();
        if(index<= -1){
            return;
        }

        company_name = col_companyName.getCellData(index).toString();
        job_title = col_jobtitle.getCellData(index).toString();
        job_description = col_jobdesc.getCellData(index).toString();
        location = col_location.getCellData(index).toString();
        qualification = col_qualification.getCellData(index).toString();
        salary_range = col_salaryrange.getCellData(index).toString();
        posting_date = col_postingdate.getCellData(index).toString();
        jobPostID = Integer.valueOf(col_jobPostID.getCellData(index).toString());
        DBUtils.changeScene_mouse(mouseEvent,"JobSeeker_UploadPDFParticularCompany.fxml", null, null, null);

        System.out.println("Job Postings Particular company theke bolchi\n");
        System.out.println(company_name);
        System.out.println(job_title);
        System.out.println(job_description);
        System.out.println(location);
        System.out.println(qualification);
        System.out.println(salary_range);
        System.out.println(posting_date);
        System.out.println(jobPostID);
    }

}
