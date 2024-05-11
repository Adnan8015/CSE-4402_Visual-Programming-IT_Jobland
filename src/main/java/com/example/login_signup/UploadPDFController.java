
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

public class UploadPDFController implements Initializable {
    public String company_name = JobPostingsController.company_name;
    @FXML
    public Button button_back;

    @FXML
    public Button button_uploadPDF;

    public File pdfFile;
    @FXML
    public ScrollPane scrollpane_jobinfo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println(JobPostingsController.job_title);
//        ta_AllInformationJob.setText("Company Name: " + JobPostingsController.company_name + "\n\n" + "Job Title: " + JobPostingsController.job_title + "\n\n" + "Job Description: " + JobPostingsController.job_description + "\n\n" + "Location: " + JobPostingsController.location + "\n\n" + "Qualifications: " + JobPostingsController.qualification + "\n\n" + "Salary Range: " + JobPostingsController.salary_range + "\n\n" + "Posting Date " + JobPostingsController.posting_date + "\n\n" );
        Text text = new Text("Company Name: " + JobPostingsController.company_name + "\n\n" + "Job Title: " + JobPostingsController.job_title + "\n\n" + "Job Description: " + JobPostingsController.job_description + "\n\n" + "Location: " + JobPostingsController.location + "\n\n" + "Qualifications: " + JobPostingsController.qualification + "\n\n" + "Salary Range: " + JobPostingsController.salary_range + "\n\n" + "Posting Date " + JobPostingsController.posting_date + "\n\n" );
        scrollpane_jobinfo.setContent(text);
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent, "JobPostings.fxml", null, null, null);
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
                Connection connection = null;
                PreparedStatement psInsert = null;
                PreparedStatement psCheckUserExists = null;
                ResultSet resultset = null;

                if (selectedFile != null) {
                    try {
                        String databaseName = "shiperdb";
                        String databaseUser = "root";
                        String databasePassword = "12345";
                        String url = "jdbc:mysql://localhost/" + databaseName;

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            DriverManager.getConnection(url, databaseUser, databasePassword);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        byte[] pdfData = Files.readAllBytes(selectedFile.toPath());
                        Blob pdfBlob = new javax.sql.rowset.serial.SerialBlob(pdfData);

                        // use JDBC to insert the PDF file data into the database
//                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shiperdb", "root", "12345");
//                        PreparedStatement pstmt = conn.prepareStatement("UPDATE jobseeker SET filename = ? , data = ? , applied_company = ? WHERE job_seeker_id = ?");
//                        pstmt.setString(1, selectedFile.getName());
//                        pstmt.setBlob(2, pdfBlob);
//                        psInsert.setString(3, JobSeekerCompaniesController.company_name);
//                        psInsert.setString(4, String.valueOf(userId));
//                        pstmt.executeUpdate();
//                        conn.close();
//                        System.out.println("PDF file uploaded successfully.");

//                        PreparedStatement psInsert ;
//                        PreparedStatement psCheckUserExists ;
//                        ResultSet resultset ;
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shiperdb", "root", "12345");
                        // PreparedStatement psInsert = conn.prepareStatement("INSERT INTO jobseeker (filename, data) VALUES (?, ?) WHERE job_seeker_email=?");
                        psInsert = conn.prepareStatement("SELECT job_seeker_id FROM jobseeker WHERE job_seeker_email = ?");
                        psInsert.setString(1, JobSeekerFirstPageController.USERNAME);
                        System.out.println(JobSeekerFirstPageController.USERNAME);
                        resultset = psInsert.executeQuery();
                        if (resultset.next()) {
                            // Get the user ID from the result set
                            int userId = resultset.getInt("job_seeker_id");

                            // Do something with the user ID
                            System.out.println("User ID: " + userId);

//                            psInsert = conn.prepareStatement("UPDATE jobseeker SET filename = ? , data = ? , applied_company = ?,job_post_id = ? WHERE job_seeker_id = ?");
//                            psInsert.setString(1, selectedFile.getName());
//                            psInsert.setBlob(2, pdfBlob);
//                            psInsert.setString(3, JobSeekerCompaniesController.company_name);
//                            psInsert.setInt(4,JobPostingsController.jobPostID);
//                            psInsert.setString(5, String.valueOf(userId));
//                            psInsert = conn.prepareStatement("INSERT INTO jobseeker (filename, data, applied_company,job_post_id,job_seeker_id) VALUES (?, ?, ?,?,?)");
//                            psInsert.setString(1, selectedFile.getName());
//                            psInsert.setBlob(2, pdfBlob);
//                            psInsert.setString(3, JobSeekerCompaniesController.company_name);
//                            psInsert.setInt(4,JobSeeker_JobPostingsParticularCompany.jobPostID);
//                            psInsert.setInt(5, userId);
//
//                            psInsert.executeQuery();

                            psInsert = conn.prepareStatement("INSERT INTO jobseeker (filename, data, applied_company,job_post_id,job_seeker_id,job_seeker_email) VALUES (?,?, ?, ?,?,?)");
                            psInsert.setString(1, selectedFile.getName());
                            psInsert.setBlob(2, pdfBlob);
                            psInsert.setString(3, JobSeekerCompaniesController.company_name);
                            psInsert.setInt(4,JobSeeker_JobPostingsParticularCompany.jobPostID);
                            psInsert.setInt(5, userId);
                            psInsert.setString(6,JobSeekerFirstPageController.USERNAME);
                            psInsert.executeUpdate();

                            //conn.close();
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
