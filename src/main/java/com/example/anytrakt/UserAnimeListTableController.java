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

public class UserAnimeListTableController implements Initializable {
    @FXML
    private TableColumn<Watch_List, String> Genre;

    @FXML
    private TableColumn<Watch_List, String> IMDb_Rating_col;



    @FXML
    private BorderPane Anime_List_Anchor;

    @FXML
    private TableView<Watch_List> Anime_Table;

    @FXML
    private TableColumn<Watch_List, String> Release_Year_col;

    @FXML
    private Button Search_btn;

    @FXML
    private ComboBox<String> Search_type_comboBox;
    ObservableList<String> columntpye = FXCollections.observableArrayList("Genre","Title");
    @FXML
    private TextField Search_value;

    @FXML
    private TableColumn<Watch_List, String> Title_col;

    static ObservableList<Watch_List> UserAnimelist= FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Search_type_comboBox.setItems(columntpye);
        Anime_Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DB_Connection dbAction = new DB_Connection();
        try{
            UserAnimeListTableController.UserAnimelist=  dbAction.getAllAnimelist();


        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(UserAnimeListTableController.class.getName()).log(Level.SEVERE, null, e);
        }

        Title_col.setCellValueFactory(new PropertyValueFactory<Watch_List,String>("Title"));
        Release_Year_col.setCellValueFactory(new PropertyValueFactory<Watch_List,String>("Release_Year"));
        Genre.setCellValueFactory(new PropertyValueFactory<Watch_List,String>("Genre"));
        IMDb_Rating_col.setCellValueFactory(new PropertyValueFactory<Watch_List,String>("IMDb_Rating"));

        Anime_Table.setItems(UserAnimeListTableController.UserAnimelist);
    }

    @FXML
    private void Completed_button_Action(ActionEvent event) throws SQLException {

        ObservableList<Watch_List> selectedAnime=FXCollections.observableArrayList();
        selectedAnime=Anime_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.InsertIntoUserAnimeOnComplete(selectedAnime);
        UserAnimeListTableController.UserAnimelist.removeAll(selectedAnime);
    }



    @FXML
    private void Watching_button_Action(ActionEvent event) throws SQLException {

        ObservableList<Watch_List> selectedAnime=FXCollections.observableArrayList();
        selectedAnime=Anime_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.InsertIntoUserAnimeOnWatch(selectedAnime);
        UserAnimeListTableController.UserAnimelist.removeAll(selectedAnime);

    }

    @FXML
    private void Plan_To_Watch_button_Action(ActionEvent event) throws SQLException {

        ObservableList<Watch_List> selectedAnime=FXCollections.observableArrayList();
        selectedAnime=Anime_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.InsertIntoUserAnimeOnPlan_to_Watch(selectedAnime);
        UserAnimeListTableController.UserAnimelist.removeAll(selectedAnime);

    }

    @FXML
    private void Search_Action(ActionEvent event) throws SQLException {
        String Type=Search_type_comboBox.getValue();
        String value=Search_value.getText();
        ObservableList<Watch_List> selectedAnime=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedAnime  = dbAction.searchAnime(Type, value);


        Anime_Table.setItems(selectedAnime);


    }
}
