package com.example.login_signup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class EmployerApplicantsPDFController implements Initializable {
    public static Integer jobSeekerID;
    public static String jobSeekerName;
    @FXML
    public Button button_back;

    @FXML
    public TableColumn<EmployerApplicantsPDFModel, Integer> job_seeker_id;

    @FXML
    public TableView<EmployerApplicantsPDFModel> tv_applicantstable;
    @FXML
    public TableColumn<EmployerApplicantsPDFModel, String> job_seeker_name;
    @FXML
    public TableColumn<EmployerApplicantsPDFModel, String> cv_file;
    @FXML
    public TableColumn<EmployerApplicantsPDFModel, String> filename;
    @FXML
    public TableColumn<EmployerApplicantsPDFModel, String> col_sendEmail;
    @FXML
    ObservableList<EmployerApplicantsPDFModel> employerApplicantsPDFModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "EmployerJobList.fxml", null, null, null);
            }
        });
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet queryOutput;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            preparedStatement = connection.prepareStatement("SELECT job_seeker_id, job_seeker_email, filename  FROM jobseeker WHERE job_post_id = ?");
            preparedStatement.setInt(1, EmployerJobListController.jobPostID);
            queryOutput = preparedStatement.executeQuery();
            while (queryOutput.next()) {
//                jobSearchModelObservableList.add(new JobSearchModel(queryOutput.getInt("")))
                String queryjob_seeker_id = String.valueOf(queryOutput.getInt("job_seeker_id"));
                String queryjob_seeker_email = queryOutput.getString("job_seeker_email");
                String queryfilename = queryOutput.getString("filename");
                // Populating the observable list
                employerApplicantsPDFModelObservableList.add(new EmployerApplicantsPDFModel(queryjob_seeker_id, queryjob_seeker_email,null, queryfilename,null));
            }

            job_seeker_id.setCellValueFactory(new PropertyValueFactory<>("job_seeker_id"));
            job_seeker_name.setCellValueFactory(new PropertyValueFactory<>("job_seeker_name"));
            filename.setCellValueFactory(new PropertyValueFactory<>("filename"));
            filename.setCellFactory(column -> {
                return new TableCell<EmployerApplicantsPDFModel, String>() {
                    final Label pdf_download = new Label("Download PDF");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            pdf_download.setStyle("-fx-underline: true;");
                            setGraphic(pdf_download);
                            setText(null);
                        }
                    }
                };
            });
            tv_applicantstable.setItems(employerApplicantsPDFModelObservableList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


        @FXML
        public void onRowSelected(MouseEvent mouseEvent){
            Integer index = tv_applicantstable.getSelectionModel().getSelectedIndex();
            if(index<= -1){
                return;
            }

            jobSeekerID = Integer.valueOf(job_seeker_id.getCellData(index).toString());
            jobSeekerName = job_seeker_name.getCellData(index).toString();

            System.out.println(jobSeekerID);
            System.out.println(jobSeekerName);
            System.out.println(EmployerJobListController.jobPostID);
            PdfDatabaseHandler handler = new PdfDatabaseHandler();
            handler.retrievePdfFromDatabase(jobSeekerID,EmployerJobListController.jobPostID,jobSeekerName);

            System.out.println("EmployerApplicantsPDFController theke bolchi\n");
            System.out.println(jobSeekerID);
            System.out.println(jobSeekerName);

        }

}
