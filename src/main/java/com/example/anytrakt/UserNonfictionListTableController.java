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

public class UserNonfictionListTableController implements Initializable {


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
    private BorderPane Nonfiction_List_Anchor;

    @FXML
    private TableView<Read_List> Nonfiction_Table;



    @FXML
    private Button Search_btn;

    @FXML
    private ComboBox<String> Search_type_comboBox;
    ObservableList<String> columntpye = FXCollections.observableArrayList("Genre","Title","Author");

    @FXML
    private TextField Search_value;



    static ObservableList<Read_List> UserNonfictionlist= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Search_type_comboBox.setItems(columntpye);
        Nonfiction_Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DB_Connection dbAction = new DB_Connection();
        try{
            UserNonfictionListTableController.UserNonfictionlist=  dbAction.getAllNonfiction();


        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(UserNonfictionListTableController.class.getName()).log(Level.SEVERE, null, e);
        }

        Title_col.setCellValueFactory(new PropertyValueFactory<Read_List,String>("Title"));
        Author_col.setCellValueFactory(new PropertyValueFactory<Read_List,String>("Author"));
        Publish_Year_col.setCellValueFactory(new PropertyValueFactory<Read_List,String>("Publish_Year"));
        Genre_col.setCellValueFactory(new PropertyValueFactory<Read_List,String>("Genre"));
        Rating_col.setCellValueFactory(new PropertyValueFactory<Read_List,String>("Rating"));

        Nonfiction_Table.setItems(UserNonfictionListTableController.UserNonfictionlist);
    }



    @FXML
    private void Completed_button_Action(ActionEvent event) throws SQLException {

        ObservableList<Read_List> selectedNonfiction=FXCollections.observableArrayList();
        selectedNonfiction=Nonfiction_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.InsertIntoUserNonfictionOnComplete(selectedNonfiction);
        UserNonfictionListTableController.UserNonfictionlist.removeAll(selectedNonfiction);

    }
    @FXML
    private void Reading_button_Action(ActionEvent event) throws SQLException {

        ObservableList<Read_List> selectedNonfiction=FXCollections.observableArrayList();
        selectedNonfiction=Nonfiction_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.InsertIntoUserNonfictionOnRead(selectedNonfiction);
        UserNonfictionListTableController.UserNonfictionlist.removeAll(selectedNonfiction);

    }

    @FXML
    private void Plan_To_Read_button_Action(ActionEvent event) throws SQLException {

        ObservableList<Read_List> selectedNonfiction=FXCollections.observableArrayList();
        selectedNonfiction=Nonfiction_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.InsertIntoUserNonfictionOnPlan_to_Read(selectedNonfiction);
        UserNonfictionListTableController.UserNonfictionlist.removeAll(selectedNonfiction);

    }

    @FXML
    private void UserSearch_Action(ActionEvent event) throws SQLException {
        String Type=Search_type_comboBox.getValue();
        String value=Search_value.getText();
        ObservableList<Read_List> selectedNonfiction=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedNonfiction  = dbAction.searchNonfiction(Type, value);


        Nonfiction_Table.setItems(selectedNonfiction);


    }
}
