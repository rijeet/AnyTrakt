module com.example.anytrakt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.anytrakt to javafx.fxml;
    exports com.example.anytrakt;
}