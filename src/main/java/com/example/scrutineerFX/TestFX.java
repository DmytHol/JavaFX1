package com.example.scrutineerFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the main container for the DancerView
        DancerView testView = new DancerView();

        // Set up the scene
        Scene scene = new Scene(testView, 400, 300);

        // Set up the stage
        primaryStage.setTitle("Test App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
