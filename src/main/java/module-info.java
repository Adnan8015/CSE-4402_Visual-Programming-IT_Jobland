module com.example.login_signup {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;
    requires java.sql.rowset;


    opens com.example.login_signup to javafx.fxml;
    exports com.example.login_signup;
}