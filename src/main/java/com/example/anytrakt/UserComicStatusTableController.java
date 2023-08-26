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

public class UserComicStatusTableController implements Initializable {


    @FXML
    private TableColumn<Read_List_OnStatus, String> Title_col;

    @FXML
    private TableColumn<Read_List_OnStatus, String> Author_col;

    @FXML
    private TableColumn<Read_List_OnStatus, String> Genre_col;

    @FXML
    private TableColumn<Read_List_OnStatus, String> Publish_Year_col;

    @FXML
    private TableColumn<Read_List_OnStatus, String> Rating_col;

    @FXML
    private TableColumn<Read_List_OnStatus, String> OnStatus_col;


    @FXML
    private Button Completed_btn;

    @FXML
    private BorderPane Comic_List_Anchor;

    @FXML
    private TableView<Read_List_OnStatus> Comic_Table;



    @FXML
    private Button Search_btn;

    @FXML
    private ComboBox<String> Search_type_comboBox;
    ObservableList<String> columntpye = FXCollections.observableArrayList("Genre","Title","Author");

    @FXML
    private TextField Search_value;



    static ObservableList<Read_List_OnStatus> UserOnStatusComiclist= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Search_type_comboBox.setItems(columntpye);
        Comic_Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DB_Connection dbAction = new DB_Connection();
        try{
            UserComicStatusTableController.UserOnStatusComiclist=  dbAction.getAllComicOnStatus();


        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(UserComicStatusTableController.class.getName()).log(Level.SEVERE, null, e);
        }

        Title_col.setCellValueFactory(new PropertyValueFactory<Read_List_OnStatus,String>("Title"));
        Author_col.setCellValueFactory(new PropertyValueFactory<Read_List_OnStatus,String>("Author"));
        Publish_Year_col.setCellValueFactory(new PropertyValueFactory<Read_List_OnStatus,String>("Publish_Year"));
        Genre_col.setCellValueFactory(new PropertyValueFactory<Read_List_OnStatus,String>("Genre"));
        Rating_col.setCellValueFactory(new PropertyValueFactory<Read_List_OnStatus,String>("Rating"));
        OnStatus_col.setCellValueFactory(new PropertyValueFactory<Read_List_OnStatus,String>("OnStatus"));

        Comic_Table.setItems(UserComicStatusTableController.UserOnStatusComiclist);
    }

    @FXML
    private void Delete_button_Actio(ActionEvent event) throws SQLException {

        ObservableList<Read_List_OnStatus> selectedComic=FXCollections.observableArrayList();
        selectedComic=Comic_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.deleteOnStatusComic(selectedComic);
        UserComicStatusTableController.UserOnStatusComiclist.removeAll(selectedComic);
    }


    @FXML
    private void UserSearch_Action(ActionEvent event) throws SQLException {
        String Type=Search_type_comboBox.getValue();
        String value=Search_value.getText();
        ObservableList<Read_List_OnStatus> selectedComic=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedComic  = dbAction.searchOnStatusComic(Type, value);


        Comic_Table.setItems(selectedComic);


    }


    @FXML
    private void GroupByCompleted(ActionEvent event) throws SQLException {
        ObservableList<Read_List_OnStatus> selectedComic=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedComic =  dbAction.getAllComicGroupByCompleted();

        Comic_Table.setItems(selectedComic);
    }

    @FXML
    private void GroupByReading(ActionEvent event) throws SQLException {
        ObservableList<Read_List_OnStatus> selectedComic=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedComic =  dbAction.getAllComicGroupByReading();

        Comic_Table.setItems(selectedComic);
    }

    @FXML
    private void GroupByPlan_To_Read(ActionEvent event) throws SQLException {
        ObservableList<Read_List_OnStatus> selectedComic=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedComic =  dbAction.getAllComicGroupByPlan_To_Read();

        Comic_Table.setItems(selectedComic);
    }
}
