
package com.example.login_signup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;


public class PdfDatabaseHandler {

    public static void retrievePdfFromDatabase(Integer job_seeker_id, Integer job_post_id, String jobSeekerName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // get a connection to the database
            String databaseName = "shiperdb";
            String databaseUser = "root";
            String databasePassword = "12345";
            String url = "jdbc:mysql://localhost/" + databaseName;
            conn = DriverManager.getConnection(url, databaseUser, databasePassword);
//''
            // retrieve the PDF file data from the database
            pstmt = conn.prepareStatement("SELECT data FROM jobseeker WHERE job_seeker_id = ? AND job_post_id = ? AND job_seeker_email = ?");
//
            pstmt.setInt(1, job_seeker_id);
            pstmt.setInt(2, job_post_id);
            pstmt.setString(3, jobSeekerName);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // get the PDF file data from the result set
                Blob pdfBlob = rs.getBlob("data");
//                String filename = rs.getString("filename");
                byte[] pdfData = pdfBlob.getBytes(1, (int) pdfBlob.length());
                System.out.println(pdfData);
//                System.out.println(filename);
                // write the PDF file data to a file in the "G:\a folder" directory
                File outputDirectory = new File("E:\\all pdfs from db");
                outputDirectory.mkdirs();
                File outputFile = new File(outputDirectory, jobSeekerName +".pdf");
                FileOutputStream fos = new FileOutputStream(outputFile);
                fos.write(pdfData);
//                fos.close();

                System.out.println("PDF file retrieved successfully.");
            } else {
                System.out.println("PDF file not found.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            // release database resources
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}

