module com.example.testfxwith20jdk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.scrutineerFX to javafx.fxml;
    exports com.example.scrutineerFX;
}