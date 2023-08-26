package com.example.anytrakt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserFictionListTableController implements Initializable {


    @FXML
    private TableColumn<Read_List, String> Title_col;

    @FXML
    private TableColumn<Read_List, String> Author_col;

    @FXML
    private TableColumn<Read_List, String> Genre_col;

    @FXML
    private TableColumn<Read_List, String> Publish_Year_col;

    @FXML
    private TableColumn<Read_List, String> Rating_col;




    @FXML
    private Button Completed_btn;

    @FXML
    private BorderPane Fiction_List_Anchor;

    @FXML
    private TableView<Read_List> Fiction_Table;



    @FXML
    private Button Search_btn;

    @FXML
    private ComboBox<String> Search_type_comboBox;
    ObservableList<String> columntpye = FXCollections.observableArrayList("Genre","Title","Author");

    @FXML
    private TextField Search_value;



    static ObservableList<Read_List> UserFictionlist= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Search_type_comboBox.setItems(columntpye);
        Fiction_Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DB_Connection dbAction = new DB_Connection();
        try{
            UserFictionListTableController.UserFictionlist=  dbAction.getAllFiction();


        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(UserFictionListTableController.class.getName()).log(Level.SEVERE, null, e);
        }

        Title_col.setCellValueFactory(new PropertyValueFactory<Read_List,String>("Title"));
        Author_col.setCellValueFactory(new PropertyValueFactory<Read_List,String>("Author"));
        Publish_Year_col.setCellValueFactory(new PropertyValueFactory<Read_List,String>("Publish_Year"));
        Genre_col.setCellValueFactory(new PropertyValueFactory<Read_List,String>("Genre"));
        Rating_col.setCellValueFactory(new PropertyValueFactory<Read_List,String>("Rating"));

        Fiction_Table.setItems(UserFictionListTableController.UserFictionlist);
    }



    @FXML
    private void Completed_button_Action(ActionEvent event) throws SQLException {

        ObservableList<Read_List> selectedFiction=FXCollections.observableArrayList();
        selectedFiction=Fiction_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.InsertIntoUserFictionOnComplete(selectedFiction);
        UserFictionListTableController.UserFictionlist.removeAll(selectedFiction);

    }
    @FXML
    private void Reading_button_Action(ActionEvent event) throws SQLException {

        ObservableList<Read_List> selectedFiction=FXCollections.observableArrayList();
        selectedFiction=Fiction_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.InsertIntoUserFictionOnRead(selectedFiction);
        UserFictionListTableController.UserFictionlist.removeAll(selectedFiction);

    }

    @FXML
    private void Plan_To_Read_button_Action(ActionEvent event) throws SQLException {

        ObservableList<Read_List> selectedFiction=FXCollections.observableArrayList();
        selectedFiction=Fiction_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.InsertIntoUserFictionOnPlan_to_Read(selectedFiction);
        UserFictionListTableController.UserFictionlist.removeAll(selectedFiction);

    }

    @FXML
    private void UserSearch_Action(ActionEvent event) throws SQLException {
        String Type=Search_type_comboBox.getValue();
        String value=Search_value.getText();
        ObservableList<Read_List> selectedFiction=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedFiction  = dbAction.searchFiction(Type, value);


        Fiction_Table.setItems(selectedFiction);


    }
}
