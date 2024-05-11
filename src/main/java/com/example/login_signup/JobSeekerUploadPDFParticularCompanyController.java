
package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.sql.rowset.serial.SerialException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.*;
import java.util.ResourceBundle;

public class JobSeekerUploadPDFParticularCompanyController implements Initializable {

    //String p = JobSeekerFirstPageController.USERNAME;

    public String company_name = JobSeeker_JobPostingsParticularCompany.company_name;
    @FXML
    public Button button_back;

    @FXML
    public Button button_uploadPDF;

    public File pdfFile;
    @FXML
    public ScrollPane scrollpane_jobinfo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println(JobSeeker_JobPostingsParticularCompany.job_title);
//        ta_AllInformationJob.setText("Company Name: " + JobSeeker_JobPostingsParticularCompany.company_name + "\n\n" + "Job Title: " + JobSeeker_JobPostingsParticularCompany.job_title + "\n\n" + "Job Description: " + JobSeeker_JobPostingsParticularCompany.job_description + "\n\n" + "Location: " + JobSeeker_JobPostingsParticularCompany.location + "\n\n" + "Qualifications: " + JobSeeker_JobPostingsParticularCompany.qualification + "\n\n" + "Salary Range: " + JobSeeker_JobPostingsParticularCompany.salary_range + "\n\n" + "Posting Date " + JobSeeker_JobPostingsParticularCompany.posting_date + "\n\n" );
        Text text = new Text("Company Name: " + JobSeeker_JobPostingsParticularCompany.company_name + "\n\n" + "Job Title: " + JobSeeker_JobPostingsParticularCompany.job_title + "\n\n" + "Job Description: " + JobSeeker_JobPostingsParticularCompany.job_description + "\n\n" + "Location: " + JobSeeker_JobPostingsParticularCompany.location + "\n\n" + "Qualifications: " + JobSeeker_JobPostingsParticularCompany.qualification + "\n\n" + "Salary Range: " + JobSeeker_JobPostingsParticularCompany.salary_range + "\n\n" + "Posting Date " + JobSeeker_JobPostingsParticularCompany.posting_date + "\n\n" );
        scrollpane_jobinfo.setContent(text);
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent, "JobSeeker_JobPostingsParticularCompany.fxml", null, null, null);
            }
        });

        button_uploadPDF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                FileChooser fileChooser = new FileChooser();
//                fileChooser.setTitle("Select PDF File");
//                pdfFile = fileChooser.showOpenDialog(stage);
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select PDF File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));

                // show the file chooser dialog
                File selectedFile = fileChooser.showOpenDialog(button_uploadPDF.getScene().getWindow());

                // Upload the selected PDF file to the database
                

                if (selectedFile != null) {
                    try {
                        String databaseName = "shiperdb";
                        String databaseUser = "root";
                        String databasePassword = "12345";
                        String url = "jdbc:mysql://localhost/" + databaseName;

                        try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            DriverManager.getConnection(url, databaseUser, databasePassword);
                        }
                        catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        byte[] pdfData = Files.readAllBytes(selectedFile.toPath());
                        Blob pdfBlob = new javax.sql.rowset.serial.SerialBlob(pdfData);

                        // use JDBC to insert the PDF file data into the database
//                        Connection connection ;
                        PreparedStatement psInsert ;
//                        PreparedStatement psCheckUserExists ;
                        ResultSet resultset ;
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shiperdb", "root", "12345");
                       // PreparedStatement psInsert = conn.prepareStatement("INSERT INTO jobseeker (filename, data) VALUES (?, ?) WHERE job_seeker_email=?");
                        psInsert =  conn.prepareStatement("SELECT job_seeker_id FROM jobseeker WHERE job_seeker_email = ?");
                        psInsert.setString(1, JobSeekerFirstPageController.USERNAME);
                        System.out.println(JobSeekerFirstPageController.USERNAME);
                        resultset = psInsert.executeQuery();
                        if (resultset.next()) {
                            // Get the user ID from the result set
                            int userId = resultset.getInt("job_seeker_id");

                            // Do something with the user ID
                            System.out.println("User ID: " + userId);

                           // psInsert = conn.prepareStatement("UPDATE jobseeker SET filename = ? , data = ? , applied_company = ? , job_post_id = ? WHERE job_seeker_id = ?");
//                            psInsert = conn.prepareStatement("INSERT INTO jobseeker (filename, data, applied_company,job_post_id,job_seeker_id) VALUES (?, ?, ?,?,?)");
//                            psInsert.setString(1, selectedFile.getName());
//                            psInsert.setBlob(2, pdfBlob);
//                            psInsert.setString(3, JobSeekerCompaniesController.company_name);
//                            psInsert.setInt(4,JobSeeker_JobPostingsParticularCompany.jobPostID);
//                            psInsert.setInt(5, userId);
//
//                             psInsert.executeQuery();

                            psInsert = conn.prepareStatement("INSERT INTO jobseeker (filename, data, applied_company,job_post_id,job_seeker_id,job_seeker_email) VALUES (?,?, ?, ?,?,?)");
                            psInsert.setString(1, selectedFile.getName());
                            psInsert.setBlob(2, pdfBlob);
                            psInsert.setString(3, JobSeekerCompaniesController.company_name);
                            psInsert.setInt(4,JobSeeker_JobPostingsParticularCompany.jobPostID);
                            psInsert.setInt(5, userId);
                            psInsert.setString(6,JobSeekerFirstPageController.USERNAME);
                            psInsert.executeUpdate();

                            conn.close();
                            System.out.println("PDF file uploaded successfully.");
                    }

                } catch (SerialException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        }
    });

    }
}

