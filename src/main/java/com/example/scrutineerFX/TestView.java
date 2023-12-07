package com.example.scrutineerFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import Scrutineer.Participants.Dancer;
public class TestView extends VBox {

    private ObservableList<Dancer> dancerList;
    private ListView<Dancer> listView;

    public TestView() {
        // Initialize the components and set up the layout
        initComponents();
    }

    private void initComponents() {
        // Example: Initialize dancer list and populate it with dummy data (replace this with data from the database)
        dancerList = FXCollections.observableArrayList(
                new Dancer("John", "Doe", 25, "Intermediate"),
                new Dancer("Jane", "Smith", 30, "Advanced"),
                new Dancer("Bob", "Johnson", 22, "Beginner")
                // Add more dancers as needed
        );

        // Example: Create a ListView to display dancers
        listView = new ListView<>(dancerList);

        // Set up the layout
        getChildren().add(listView);

        // You can customize the appearance and add more components as needed
    }
}