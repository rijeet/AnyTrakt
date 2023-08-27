package com.example.anytrakt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable {

    @FXML
    private BorderPane UserPage_Pane;
    @FXML
    private Button Anime_btn;

    @FXML
    private Button Comic_btn;

    @FXML
    private Button Drama_btn;

    @FXML
    private Button Fiction_btn;

    @FXML
    private Button Manga_btn;

    @FXML
    private Button Movie_btn;

    @FXML
    private Button Nonfiction_btn;

    @FXML
    private Button Tv_btn;


    @FXML
    private TextField User_ID;

    @FXML
    private TextField User_Name;

    @FXML
    private Button search_btn;

    @FXML
    private AnchorPane show_table_pane;

    @FXML
    void onAnime_btnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Anime_Status_Table.fxml"));
        show_table_pane.getChildren().setAll(pane);
    }

    @FXML
    void onComic_btnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Comic_Status_Table.fxml"));
        show_table_pane.getChildren().setAll(pane);
    }

    @FXML
    void onDrama_btnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Drama_Status_Table.fxml"));
        show_table_pane.getChildren().setAll(pane);
    }

    @FXML
    void onManga_btnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Manga_Status_Table.fxml"));
        show_table_pane.getChildren().setAll(pane);
    }

    @FXML
    void onMovie_btnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Movie_Status_Table.fxml"));
        show_table_pane.getChildren().setAll(pane);
    }

    @FXML
    void onNonfiction_btnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Nonfiction_Status_Table.fxml"));
        show_table_pane.getChildren().setAll(pane);
    }

    @FXML
    void onSearch_btnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("SearchPage.fxml"));
        UserPage_Pane.getChildren().setAll(pane);
    }

    @FXML
    void onTv_btnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Tv_Series_Status_Table.fxml"));
        show_table_pane.getChildren().setAll(pane);
    }

    @FXML
    void onFiction_btnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Fiction_Status_Table.fxml"));
        show_table_pane.getChildren().setAll(pane);
    }


    @FXML
    void OnBack_btn_Action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_HomePage.fxml"));
        UserPage_Pane.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User_ID.setText(DB_Connection.super_User_ID);
        User_Name.setText(LoginController.super_name);
    }

}
