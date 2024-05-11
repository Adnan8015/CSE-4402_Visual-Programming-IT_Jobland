//package com.example.login_signup;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.sql.*;
//
//public class DBUtils {
//    public static String p = HelloController.USERNAME;
//    public static String signup_username = SignUpController.signUpUsername;
//    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username, String fav_channel)
//    {
//        Parent root = null;
//        Parent root1 = null;
//
//        if(username != null && fav_channel != null)
//        {
//            try {
//                FXMLLoader loader  = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
//                root = loader.load();
//                LoggedInController loggedInController = loader.getController();
//                loggedInController.setUserInformation(username, fav_channel);
//
////                FXMLLoader loader1  = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
////                root1 = loader1.load();
////                BlogpostController blogpostController = loader1.getController();
////                blogpostController.setUserInformation(username);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        else
//        {
//            try{
//                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
//            }
//            catch(IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setTitle(title);
//        stage.setScene(new Scene(root));
//        stage.show();
//
//    }
//    public static void checkUserIsAvailable(ActionEvent event, String username)
//    {
//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultset = null;
//
//        try{
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
//            psCheckUserExists.setString(1, username);
//            resultset = psCheckUserExists.executeQuery();
//
//            if(!resultset.isBeforeFirst())
//            {
//                System.out.println("User Does not exit!");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("Sign up first!");
//                alert.show();
//
//            }
//            else {
////
////                psInsert = connection.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
//////
////                psInsert.setString (1, username);
////
////                psInsert.setString (2, password);
////
//////                psInsert.setString (3);
////
////                psInsert.executeUpdate();
////
////                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
////                alert.setContentText("Your account has been created successfully! You are now part of our community.");
////                alert.show();
//
////                changeScene(event, "loggedin.fxml", "sofol login", username, fav_channel);
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally{
//            if(resultset !=  null)
//            {
//                try{
//                    resultset.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//            if(psCheckUserExists != null)
//            {
//                try
//                {
//                    psCheckUserExists.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(psInsert != null)
//            {
//                try
//                {
//                    psInsert.close();
//                }
//                catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(connection != null)
//            {
//                try{
//                    connection.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//    public static void updatePassword(ActionEvent event, String username, String password)
//    {
//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultset = null;
//
//        try{
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
//
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
//
//            psCheckUserExists.setString(1, username);
//
//            resultset = psCheckUserExists.executeQuery();
////            UPDATE users SET password = ? WHERE username = ?
//            psInsert = connection.prepareStatement("UPDATE users SET password = ? WHERE email = ?");
////
//            psInsert.setString(1, password);
//            psInsert.setString (2, username);
//
//
//            psInsert.executeUpdate();
//
//            changeScene(event, "hello-view.fxml", "Login & Register", username, null);
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally{
//            if(resultset !=  null)
//            {
//                try{
//                    resultset.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//            if(psCheckUserExists != null)
//            {
//                try
//                {
//                    psCheckUserExists.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(psInsert != null)
//            {
//                try
//                {
//                    psInsert.close();
//                }
//                catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(connection != null)
//            {
//                try{
//                    connection.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//    public static void signUpUser(ActionEvent event, String username, String password)
//    {
////        System.out.println(username);
//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultset = null;
//
//        try{
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
//            psCheckUserExists.setString(1, username);
//            resultset = psCheckUserExists.executeQuery();
//
//            if(resultset.isBeforeFirst())
//            {
//                System.out.println("User Already exists!");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("You cannot use this username");
//                alert.show();
//            }
//            else {
////
//                psInsert = connection.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
////
//                psInsert.setString (1, username);
//
//                psInsert.setString (2, password);
//
////                psInsert.setString (3);
//
//                psInsert.executeUpdate();
//
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setContentText("Your account has been created successfully! You are now part of our community.");
//                alert.show();
//
////                changeScene(event, "loggedin.fxml", "sofol login", username, fav_channel);
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally{
//            if(resultset !=  null)
//            {
//                try{
//                    resultset.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//            if(psCheckUserExists != null)
//            {
//                try
//                {
//                    psCheckUserExists.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(psInsert != null)
//            {
//                try
//                {
//                    psInsert.close();
//                }
//                catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(connection != null)
//            {
//                try{
//                    connection.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    public static void logInUser(ActionEvent event, String username, String password)
//    {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try{
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
//            preparedStatement = connection.prepareStatement("SELECT password FROM users where email = ?");
//            preparedStatement.setString(1, username);
//            resultSet = preparedStatement.executeQuery();
//
//            if(!resultSet.isBeforeFirst())
//            {
//                System.out.println("User not found in the database!");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("Provided credentials are incorrect");
//                alert.show();
//            }
//            else {
//                while(resultSet.next())
//                {
//                    String retrievedPassword = resultSet.getString("password");
//                    String retrievedChannel = null;
////                    resultSet.getInt();
//                    if(retrievedPassword.equals(password))
//                    {
//                        changeScene(event, "loggedin.fxml", "Welcome!", username, retrievedChannel);
//                    }
//                    else {
//                        System.out.println("Passwords didn't match");
//                        Alert alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setContentText("Provided credentials are incorrect");
//                        alert.getDialogPane().setPrefSize(600,400);
//                        alert.showAndWait();
//                    }
//                }
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally{
//            if(resultSet!=null)
//            {
//                try{
//                    resultSet.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//            if(preparedStatement != null)
//            {
//                try{
//                    preparedStatement.close();;
//                }
//                catch(SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//            if(connection != null)
//            {
//                try
//                {
//                    connection.close();
//                }
//                catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    public static void writeYourBlogPost(ActionEvent event, String username, String _title, String _content)
//    {
//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultset = null;
//
//        try{
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
////            System.out.println("SELECT query er aage" + username);
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
////            System.out.println("NO");
//            psCheckUserExists.setString(1, username);
////            System.out.println("NO");
//            resultset = psCheckUserExists.executeQuery();
////            System.out.println("NO");
//
////            System.out.println(_title);
////            System.out.println(_content);
//            psInsert = connection.prepareStatement("INSERT INTO users (title, content, email, password) VALUES (?, ?, ?, ?)");
////
//            psInsert.setString (1, _title);
//            psInsert.setString (2, _content);
//            psInsert.setString (3, username);
//            psInsert.setString (4, HelloController.PASSWORD);
//
////            System.out.println("NO");
//
//
////            System.out.println("NO");
//
//
////            System.out.println("NO");
//
//            psInsert.executeUpdate();
////            System.out.println("NO");
//
//            changeScene(event, "loggedin.fxml", "sofol login", username, null);
////            System.out.println("NO");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally{
//            if(resultset !=  null)
//            {
//                try{
//                    resultset.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//            if(psCheckUserExists != null)
//            {
//                try
//                {
//                    psCheckUserExists.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(psInsert != null)
//            {
//                try
//                {
//                    psInsert.close();
//                }
//                catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(connection != null)
//            {
//                try{
//                    connection.close();


package com.example.login_signup;

import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Random;

public class DBUtils {
    public static String p = HelloController.USERNAME;
    public static String signup_username = SignUpController.signUpUsername;

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username, String fav_channel) {
        Parent root = null;

        if (username != null && fav_channel != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                LoggedInController loggedInController = loader.getController();
                //loggedInController.setUserInformation(username, fav_channel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();

    }
    public static void changeScene_mouse(MouseEvent MEvent, String fxmlFile, String title, String username, String fav_channel)
    {


//            public void handleClick(MouseEvent MEvent) {
        try {
            Parent root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) MEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
//            }

    }
    public static void checkUserIsAvailable(ActionEvent event, String username) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
            psCheckUserExists.setString(1, username);
            resultset = psCheckUserExists.executeQuery();

            if (!resultset.isBeforeFirst()) {
                System.out.println("User Does not exit!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Sign up first!");
                alert.show();

            } else {
//
//                psInsert = connection.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
////
//                psInsert.setString (1, username);
//
//                psInsert.setString (2, password);
//
////                psInsert.setString (3);
//
//                psInsert.executeUpdate();
//
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setContentText("Your account has been created successfully! You are now part of our community.");
//                alert.show();

//                changeScene(event, "loggedin.fxml", "sofol login", username, fav_channel);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void updatePassword(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");

            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");

            psCheckUserExists.setString(1, username);
            resultset = psCheckUserExists.executeQuery();
            psInsert = connection.prepareStatement("UPDATE users SET password = ? WHERE email = ?");

            Encrypt.encryptString(password);
            psInsert.setString(1, Encrypt.hashedPass);
            psInsert.setString(2, username);


            psInsert.executeUpdate();

            changeScene(event, "hello-view.fxml", "Login & Register", username, null);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
//    public static void signUpUser(ActionEvent event, String username, String password)
//    {
//
//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultset = null;
//
//        try{
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
//            psCheckUserExists.setString(1, username);
//            resultset = psCheckUserExists.executeQuery();
//
//            if(resultset.isBeforeFirst())
//            {
//                System.out.println("User Already exists!");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("You cannot use this username");
//                alert.show();
//            }
//            else {
//
//                psInsert = connection.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
//
//                psInsert.setString (1, username);
//
//                Encrypt.encryptString(password);
////                System.out.println(HashedPass);
//                System.out.println(Encrypt.hashedPass);
//                psInsert.setString (2, Encrypt.hashedPass);
//
////                psInsert.setString (3);
//
//                psInsert.executeUpdate();
//
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setContentText("Your account has been created successfully! You are now part of our community.");
//                alert.show();
//
////                changeScene(event, "loggedin.fxml", "sofol login", username, fav_channel);
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        } finally{
//            if(resultset !=  null)
//            {
//                try{
//                    resultset.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//            if(psCheckUserExists != null)
//            {
//                try
//                {
//                    psCheckUserExists.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(psInsert != null)
//            {
//                try
//                {
//                    psInsert.close();
//                }
//                catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(connection != null)
//            {
//                try{
//                    connection.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public static void signUpUser(ActionEvent event, String username, String password, String cmpName, String cmpCode) {
//        System.out.println(username);
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
            psCheckUserExists.setString(1, username);
            resultset = psCheckUserExists.executeQuery();

            if (resultset.isBeforeFirst()) {
                System.out.println("User Already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username");
                alert.show();
            } else {

                // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
                psCheckUserExists = connection.prepareStatement("SELECT company_name FROM company WHERE company_code  = ?");
                psCheckUserExists.setString(1, cmpCode);
                resultset = psCheckUserExists.executeQuery();

                if (resultset.next()) {
                    psInsert = connection.prepareStatement("INSERT INTO users (email, password, company_code, company_name) VALUES (?, ?, ?,?)");


                    psInsert.setString(1, username);
                    Encrypt encryptor = new Encrypt();

                    Encrypt.encryptString(password);
                    System.out.println(Encrypt.hashedPass);
                    psInsert.setString(2, Encrypt.hashedPass);


                    psInsert.setString(3, cmpCode);
                    psInsert.setString(4, cmpName);


                    psInsert.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Your account has been created successfully! You are now part of our community.");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Wrong Information Provided");
                    alert.show();
                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void logInAdmin(ActionEvent event, String username, String password)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            preparedStatement = connection.prepareStatement("SELECT admin_password FROM admin where email = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("admin_password");
//                    String retrievedChannel = null;
//                    password = Encrypt.encryptString(password);
  //                 Encrypt.encryptString(password);
//                   resultSet.getInt();
                   // if (password.equals(Encrypt.hashedPass))
                if (retrievedPassword.equals(password)){
                        changeScene(event, "AdminWelcome.fxml", "Welcome!", username, null);
                    } else {
                        System.out.println("Passwords didn't match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided credentials are incorrect");
                        alert.getDialogPane().setPrefSize(600, 400);
                        alert.showAndWait();
                    }
                }

            }
//            catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
    } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    ;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            preparedStatement = connection.prepareStatement("SELECT password FROM users where email = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    String retrievedChannel = null;
                    password = Encrypt.encryptString(password);
//                    Encrypt.encryptString(password);
//                    resultSet.getInt();
                    if (password.equals(Encrypt.hashedPass)) {
                        changeScene(event, "loggedin.fxml", "Welcome!", username, retrievedChannel);
                    } else {
                        System.out.println("Passwords didn't match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided credentials are incorrect");
                        alert.getDialogPane().setPrefSize(600, 400);
                        alert.showAndWait();
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    ;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
//    public static void writeYourBlogPost(ActionEvent event, String username, String _title, String _content)
//    {
//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultset = null;
//
//        try{
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
//
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
//
//            psCheckUserExists.setString(1, username);
//
//            resultset = psCheckUserExists.executeQuery();
//
//            psInsert = connection.prepareStatement("INSERT INTO users (title, content, email, password) VALUES (?, ?, ?, ?)");
//
//            psInsert.setString (1, _title);
//            psInsert.setString (2, _content);
//            psInsert.setString (3, username);
//            psInsert.setString (4, Encrypt.hashedPass);
//
//
//            psInsert.executeUpdate();
//
//            changeScene(event, "loggedin.fxml", "sofol login", username, null);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally{
//            if(resultset !=  null)
//            {
//                try{
//                    resultset.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//            if(psCheckUserExists != null)
//            {
//                try
//                {
//                    psCheckUserExists.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(psInsert != null)
//            {
//                try
//                {
//                    psInsert.close();
//                }
//                catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(connection != null)
//            {
//                try{
//                    connection.close();
//                }
//                catch (SQLException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }

    public static void writeYourBlogPost(ActionEvent event, String username, String _title, String _content) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");

            psCheckUserExists = connection.prepareStatement("SELECT id,company_name FROM users WHERE email = ?");


            // Set the username parameter value
            psCheckUserExists.setString(1, username);
            //psCheckUserExists.setString(2, username);

            // Execute the query and get the result set
            resultset = psCheckUserExists.executeQuery();

            //psCheckUserExists = connection.prepareStatement("SELECT company_name FROM users WHERE email = ?");

            // Check if a matching user was found
            if (resultset.next()) {
                // Get the user ID from the result set
                int userId = resultset.getInt("id");
                String companyName = resultset.getString("company_name");

                // Do something with the user ID
                System.out.println("User ID: " + userId);

                psInsert = connection.prepareStatement("INSERT INTO blogPost (title, content, employee_id, company_name,employee_name) VALUES (?, ?, ?, ?,?)");

                psInsert.setString(1, _title);
                psInsert.setString(2, _content);
                psInsert.setString(3, String.valueOf(userId));
                psInsert.setString(4, companyName);
                psInsert.setString(5, username);

                psInsert.executeUpdate();
                changeScene(event, "loggedin.fxml", "sofol login", username, null);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void signUpEmployer(ActionEvent event, String username, String password, String cmpName, String cmpCode, String designation) {
//        System.out.println(username);
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM employer WHERE email  = ?");
            psCheckUserExists.setString(1, username);
            resultset = psCheckUserExists.executeQuery();

            if (resultset.isBeforeFirst()) {
                System.out.println("User Already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username");
                alert.show();
            } else {

                // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
                psCheckUserExists = connection.prepareStatement("SELECT company_name FROM company WHERE company_code  = ?");
                psCheckUserExists.setString(1, cmpCode);
                resultset = psCheckUserExists.executeQuery();

                if (resultset.next()) {
                    psInsert = connection.prepareStatement("INSERT INTO employer (email, employer_password, company_code, company_name, designation) VALUES (?, ?, ?,?,?)");


                    psInsert.setString(1, username);
                    Encrypt encryptor = new Encrypt();

                    Encrypt.encryptString(password);
                    System.out.println(Encrypt.hashedPass);
                    psInsert.setString(2, Encrypt.hashedPass);


                    psInsert.setString(3, cmpCode);
                    psInsert.setString(4, cmpName);
                    psInsert.setString(5, designation);


                    psInsert.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Your account has been created successfully! You are now part of our community.");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Wrong Information Provided");
                    alert.show();
                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInEmployer(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            preparedStatement = connection.prepareStatement("SELECT employer_password FROM employer where email = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("employer_password");
                    String retrievedChannel = null;
                    password = Encrypt.encryptString(password);
//                    Encrypt.encryptString(password);
//                    resultSet.getInt();
                    if (password.equals(Encrypt.hashedPass)) {
                        changeScene(event, "EmployerWelcome.fxml", "Welcome!", username, retrievedChannel);
                    } else {
                        System.out.println("Passwords didn't match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided credentials are incorrect");
                        alert.getDialogPane().setPrefSize(600, 400);
                        alert.showAndWait();
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    ;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void AddJobPost(ActionEvent event, String company_name, String job_title, String job_desc, String location, String qualification, String Salary, String post_date) {

        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");

            psCheckUserExists = connection.prepareStatement("SELECT employer_id FROM employer WHERE company_name = ?");

            // Set the username parameter value
            psCheckUserExists.setString(1, JobPostController.company_name);

            // Execute the query and get the result set
            resultset = psCheckUserExists.executeQuery();

            // Check if a matching user was found
            if (resultset.next()) {
                // Get the user ID from the result set
                int userId = resultset.getInt("employer_id");

                // Do something with the user ID
//                System.out.println("User ID: " + userId);
//                if (resultset.next()) {
                    psInsert = connection.prepareStatement("INSERT INTO jobpost (employer_id, job_title, job_description, location, qualification, salary_range, post_date, company_name,employer_name) VALUES (?, ?, ?,?,?,?,?,?,?)");

                    //while(resultset.next()) {

                        psInsert.setInt(1, userId);
//                    Encrypt encryptor = new Encrypt();
//
//                    Encrypt.encryptString(password);
//                    System.out.println(Encrypt.hashedPass);
                        psInsert.setString(2, job_title);


                        psInsert.setString(3, job_desc);
                        psInsert.setString(4, location);
                        psInsert.setString(5, qualification);
                        psInsert.setString(6, Salary);
                        psInsert.setString(7, post_date);
                        psInsert.setString(8, company_name);
                        psInsert.setString(9, EmployerFirstPageController.USERNAME);

                System.out.println("a");
                        psInsert.executeUpdate();
                      System.out.println("User ID: " + userId);


                    //}

               // }

            }
            //catch (SQLException ex) {
            //throw new RuntimeException(ex);
       // }
    }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
                if (resultset != null) {
                    try {
                        resultset.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (psCheckUserExists != null) {
                    try {
                        psCheckUserExists.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (psInsert != null) {
                    try {
                        psInsert.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
//    catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        public static void signUpJobSeeker(ActionEvent event, String username, String password)
    {

        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM jobseeker WHERE job_seeker_email  = ?");
            psCheckUserExists.setString(1, username);
            resultset = psCheckUserExists.executeQuery();

            if(resultset.isBeforeFirst())
            {
                System.out.println("User Already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username");
                alert.show();
            }
            else {

                int min = 1; // minimum value
                int max = 1000; // maximum value

                // create an instance of the Random class
                Random random = new Random();

                // generate a random integer between min and max (inclusive)
               Integer random_Number = random.nextInt(max - min + 1) + min;

                psInsert = connection.prepareStatement("INSERT INTO jobseeker (job_seeker_id,job_seeker_email, job_seeker_password) VALUES (?,?, ?)");

                psInsert.setInt (1, random_Number);

                psInsert.setString (2, username);

                Encrypt.encryptString(password);
//                System.out.println(HashedPass);
                System.out.println(Encrypt.hashedPass);
                psInsert.setString (3, Encrypt.hashedPass);



//                psInsert.setString (3);

                psInsert.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Your account has been created successfully! You are now part of our community.");
                alert.show();

//                changeScene(event, "loggedin.fxml", "sofol login", username, fav_channel);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally{
            if(resultset !=  null)
            {
                try{
                    resultset.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(psCheckUserExists != null)
            {
                try
                {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(psInsert != null)
            {
                try
                {
                    psInsert.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null)
            {
                try{
                    connection.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
      }

    public static void logInJobSeeker(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            preparedStatement = connection.prepareStatement("SELECT job_seeker_password FROM jobseeker where job_seeker_email = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("job_seeker_password");
                    String retrievedChannel = null;
                    password = Encrypt.encryptString(password);
//                    Encrypt.encryptString(password);
//                    resultSet.getInt();
                    if (password.equals(Encrypt.hashedPass)) {
                        changeScene(event, "JobSeekerWelcomePage.fxml", "Welcome!", username, retrievedChannel);
                    } else {
                        System.out.println("Passwords didn't match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided credentials are incorrect");
                        alert.getDialogPane().setPrefSize(600, 400);
                        alert.showAndWait();
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    ;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
     }

    public static void addCompany(ActionEvent event, String company_name, String company_code) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
//            preparedStatement = connection.prepareStatement("INSERT INTO company (company_name,company_code) VALUES (?, ?)");
//
//            System.out.println(company_name);
//            System.out.println(company_code);
//
//            preparedStatement.setString(1, company_name);
//            preparedStatement.setString(2, company_code);
//            resultSet= preparedStatement.executeQuery();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            preparedStatement = connection.prepareStatement("INSERT INTO company (company_name, company_code) VALUES (?, ?)");

//            System.out.println(company_name);
//            System.out.println(company_code);

            preparedStatement.setString(1, company_name);
            preparedStatement.setString(2, company_code);

            int rowsAffected = preparedStatement.executeUpdate();
           // System.out.println(rowsAffected + " row(s) affected");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}


//    FilteredList<EmployerApplicantsPDFModel> filteredData = new FilteredList<>(employerApplicantsPDFModelObservableList, b -> true);

//            tf_searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
//                filteredData.setPredicate(jobSearchModel -> {
//                    if (newValue.isBlank() || newValue.isBlank() || newValue == null) {
//                        return true;
//                    }
//
//                    String searchKeyword = newValue.toLowerCase();
//
//                    if (jobSearchModel.getCompany_name().toLowerCase().indexOf(searchKeyword) > -1) {
//                        return true;
//                    } else if (jobSearchModel.getJob_title().toLowerCase().indexOf(searchKeyword) > -1) {
//                        return true;
//                    } else if (jobSearchModel.getLocation().toLowerCase().indexOf(searchKeyword) > -1) {
//                        return true;
//                    } else if (jobSearchModel.getQualifications().toLowerCase().indexOf(searchKeyword) > -1) {
//                        return true;
//                    } else if (jobSearchModel.getSalary_range().toString().indexOf(searchKeyword) > -1) {
//                        return true;
//                    } else if (jobSearchModel.getPosting_date().toLowerCase().indexOf(searchKeyword) > -1) {
//                        return true;
//                    } else {
//                        return false;
//                    }
//                });
//            });
//
//
//
//
//            SortedList<JobSearchModel> sortedData = new SortedList<>(filteredData);
//
//            sortedData.comparatorProperty().bind(tv_jobtable.comparatorProperty());
//
//            tv_jobtable.setItems(sortedData);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }





