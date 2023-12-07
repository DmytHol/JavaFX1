module com.example.testfxwith20jdk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens Scrutineer.DB to javafx.base;
    opens Scrutineer.Participants to javafx.base;
    opens com.example.scrutineerFX to javafx.fxml;
    exports com.example.scrutineerFX;
    exports Scrutineer.DB;

}