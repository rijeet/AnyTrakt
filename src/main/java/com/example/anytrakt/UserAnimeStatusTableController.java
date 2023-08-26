package com.example.anytrakt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserAnimeStatusTableController implements Initializable {



    @FXML
    private TableColumn<Watch_List_OnStatus,String> Genre_col;

    @FXML
    private TableColumn<Watch_List_OnStatus,String> IMDb_Rating_col;

    @FXML
    private TableView<Watch_List_OnStatus> Anime_Table;

    @FXML
    private TableColumn<Watch_List_OnStatus,String> OnStatus_col;

    @FXML
    private Button Search_btn;

    @FXML
    private ComboBox<String> Search_type_comboBox;
    ObservableList<String> columntpye = FXCollections.observableArrayList("Genre","Title");

    @FXML
    private TextField Search_value;

    @FXML
    private TableColumn<Watch_List_OnStatus,String> Title_col;


    static ObservableList<Watch_List_OnStatus> UserOnStatusAnimelist= FXCollections.observableArrayList();
    @FXML
    private TableColumn Release_Year_col;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Search_type_comboBox.setItems(columntpye);
        Anime_Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DB_Connection dbAction = new DB_Connection();
        try{
            UserAnimeStatusTableController.UserOnStatusAnimelist=  dbAction.getAllAnimeOnStatus();


        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(UserAnimeStatusTableController.class.getName()).log(Level.SEVERE, null, e);
        }

        Title_col.setCellValueFactory(new PropertyValueFactory<Watch_List_OnStatus,String>("Title"));
//Author
        Release_Year_col.setCellValueFactory(new PropertyValueFactory<Watch_List_OnStatus,String>("Release_Year"));
        Genre_col.setCellValueFactory(new PropertyValueFactory<Watch_List_OnStatus,String>("Genre"));
        IMDb_Rating_col.setCellValueFactory(new PropertyValueFactory<Watch_List_OnStatus,String>("IMDb_Rating"));
        OnStatus_col.setCellValueFactory(new PropertyValueFactory<Watch_List_OnStatus,String>("OnStatus"));

        Anime_Table.setItems(UserAnimeStatusTableController.UserOnStatusAnimelist);
    }


    @FXML
    void Delete_button_Action_User_Anime_Status(ActionEvent event) throws SQLException{
        ObservableList<Watch_List_OnStatus> selectedAnime=FXCollections.observableArrayList();
        selectedAnime=Anime_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.deleteOnStatusUserAnime(selectedAnime);
        UserAnimeStatusTableController.UserOnStatusAnimelist.removeAll(selectedAnime);
    }

    @FXML
    void GroupByCompleted(ActionEvent event) throws SQLException{

        ObservableList<Watch_List_OnStatus> selectedAnime=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedAnime =  dbAction.getAllAnimeGroupByCompleted();

        Anime_Table.setItems(selectedAnime);


    }

    @FXML
    void GroupByPlan_To_Watch(ActionEvent event) throws SQLException{

        ObservableList<Watch_List_OnStatus> selectedAnime=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedAnime =  dbAction.getAllAnimeGroupByPlan_To_Watch();

        Anime_Table.setItems(selectedAnime);

    }

    @FXML
    void GroupByWatch(ActionEvent event) throws SQLException{

        ObservableList<Watch_List_OnStatus> selectedAnime=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedAnime =  dbAction.getAllAnimeGroupByWatching();

        Anime_Table.setItems(selectedAnime);

    }

    @FXML
    void Search_button_Action_User_Anime_Status(ActionEvent event) throws SQLException{
        String Type=Search_type_comboBox.getValue();
        String value=Search_value.getText();
        ObservableList<Watch_List_OnStatus> selectedAnime=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedAnime  = dbAction.searchOnStatusAnime(Type, value);


        Anime_Table.setItems(selectedAnime);
    }
}

