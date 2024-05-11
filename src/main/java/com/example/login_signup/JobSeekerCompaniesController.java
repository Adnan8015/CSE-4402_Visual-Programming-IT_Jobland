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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JobSeekerCompaniesController implements Initializable {
    public static String company_name;
    @FXML
    public TableView<CompanyListModel> tv_companyList;
    @FXML
    public TableColumn<CompanyListModel, String> col_companyName;
    @FXML
    public Button button_back;
    @FXML
    public TextField tf_searchbar;
    ObservableList<CompanyListModel> companyListModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent root = null;

                try {
                    root = FXMLLoader.load(DBUtils.class.getResource("JobSeekerWelcomePage.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                stage.setScene(new Scene(root));
                stage.show();
            }
        });

        DBConnection connectnow = new DBConnection();
        Connection connectDB = connectnow.getDBConnection();

        String companyViewQuery = "SELECT company_name FROM company";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(companyViewQuery);
            while (queryOutput.next()) {
//                jobSearchModelObservableList.add(new JobSearchModel(queryOutput.getInt("")))
                String queryCompanyName = queryOutput.getString("company_name");
                System.out.println(queryCompanyName);
                // Populating the observable list
                companyListModelObservableList.add(new CompanyListModel(queryCompanyName));
            }

            col_companyName.setCellValueFactory(new PropertyValueFactory<>("company_name"));

            tv_companyList.setItems(companyListModelObservableList);

            ///new part
            FilteredList<CompanyListModel> filteredData = new FilteredList<>(companyListModelObservableList, b -> true);

            tf_searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(jobSearchModel -> {
                    if (newValue.isBlank() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (jobSearchModel.getCompany_name().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });




            SortedList<CompanyListModel> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(tv_companyList.comparatorProperty());

            tv_companyList.setItems(sortedData);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onRowSelected(MouseEvent mouseEvent){
        Integer index = tv_companyList.getSelectionModel().getSelectedIndex();
        if(index<= -1){
            return;
        }

        company_name = col_companyName.getCellData(index).toString();

        DBUtils.changeScene_mouse(mouseEvent,"JobSeeker_JobOffers&BlogPosts.fxml", null, null, null);

        System.out.println(company_name);
    }
}
