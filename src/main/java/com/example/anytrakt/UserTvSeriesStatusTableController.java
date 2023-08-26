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

public class UserTvSeriesStatusTableController implements Initializable {



    @FXML
    private TableColumn<Watch_List_OnStatus,String> Genre_col;

    @FXML
    private TableView<Watch_List_OnStatus> Tv_Series_Table;

    @FXML
    private TableColumn<Watch_List_OnStatus,String> OnStatus_col;

    @FXML
    private TableColumn<Watch_List_OnStatus,String> Release_Year_col;

    @FXML
    private TableColumn<Watch_List_OnStatus,String> IMDb_Rating_col;

    @FXML
    private Button Search_btn;

    @FXML
    private ComboBox<String> Search_type_comboBox;
    ObservableList<String> columntpye = FXCollections.observableArrayList("Genre","Title");

    @FXML
    private TextField Search_value;

    @FXML
    private TableColumn<Watch_List_OnStatus,String> Title_col;


    static ObservableList<Watch_List_OnStatus> UserOnStatusTv_Serieslist= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Search_type_comboBox.setItems(columntpye);
        Tv_Series_Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DB_Connection dbAction = new DB_Connection();
        try{
            UserTvSeriesStatusTableController.UserOnStatusTv_Serieslist=  dbAction.getAllTv_SeriesOnStatus();


        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(UserTvSeriesStatusTableController.class.getName()).log(Level.SEVERE, null, e);
        }

        Title_col.setCellValueFactory(new PropertyValueFactory<Watch_List_OnStatus,String>("Title"));
//Author
        Release_Year_col.setCellValueFactory(new PropertyValueFactory<Watch_List_OnStatus,String>("Release_Year"));
        Genre_col.setCellValueFactory(new PropertyValueFactory<Watch_List_OnStatus,String>("Genre"));
        IMDb_Rating_col.setCellValueFactory(new PropertyValueFactory<Watch_List_OnStatus,String>("IMDb_Rating"));
        OnStatus_col.setCellValueFactory(new PropertyValueFactory<Watch_List_OnStatus,String>("OnStatus"));

        Tv_Series_Table.setItems(UserTvSeriesStatusTableController.UserOnStatusTv_Serieslist);
    }


    @FXML
    void Delete_button_Action_User_Tv_Series_Status(ActionEvent event) throws SQLException{
        ObservableList<Watch_List_OnStatus> selectedTv_Series=FXCollections.observableArrayList();
        selectedTv_Series=Tv_Series_Table.getSelectionModel().getSelectedItems();
        DB_Connection dbAction=new DB_Connection();
        dbAction.deleteOnStatusUserTv_Series(selectedTv_Series);
        UserTvSeriesStatusTableController.UserOnStatusTv_Serieslist.removeAll(selectedTv_Series);
    }

    @FXML
    void GroupByCompleted(ActionEvent event) throws SQLException{

        ObservableList<Watch_List_OnStatus> selectedTv_Series=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedTv_Series =  dbAction.getAllTv_SeriesGroupByCompleted();

        Tv_Series_Table.setItems(selectedTv_Series);


    }

    @FXML
    void GroupByPlan_To_Watch(ActionEvent event) throws SQLException{

        ObservableList<Watch_List_OnStatus> selectedTv_Series=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedTv_Series =  dbAction.getAllTv_SeriesGroupByPlan_To_Watch();

        Tv_Series_Table.setItems(selectedTv_Series);

    }

    @FXML
    void GroupByWatch(ActionEvent event) throws SQLException{

        ObservableList<Watch_List_OnStatus> selectedTv_Series=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedTv_Series =  dbAction.getAllTv_SeriesGroupByWatching();

        Tv_Series_Table.setItems(selectedTv_Series);

    }

    @FXML
    void Search_button_Action_User_Tv_Series_Status(ActionEvent event) throws SQLException{
        String Type=Search_type_comboBox.getValue();
        String value=Search_value.getText();
        ObservableList<Watch_List_OnStatus> selectedTv_Series=FXCollections.observableArrayList();
        DB_Connection dbAction=new DB_Connection();
        selectedTv_Series  = dbAction.searchOnStatusTv_Series(Type, value);


        Tv_Series_Table.setItems(selectedTv_Series);
    }
}
