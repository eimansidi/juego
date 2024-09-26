module com.example.juegodados {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.juegodados to javafx.fxml;
    exports com.example.juegodados;
}