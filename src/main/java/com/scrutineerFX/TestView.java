package com.scrutineerFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import Scrutineer.Participants.Dancer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestView extends VBox {

    private ObservableList<Dancer> dancerList;
    private ListView<Dancer> listView;

    public TestView() throws ParseException {
        // Initialize the components and set up the layout
        initComponents();
    }

    private void initComponents() throws ParseException {
        // Example: Initialize dancer list and populate it with dummy data (replace this with data from the database)
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dancerList = FXCollections.observableArrayList(
                new Dancer("John", "Doe", dateFormat.parse("17/09/1983"), "Intermediate"),
                new Dancer("Jane", "Smith", dateFormat.parse("24/09/1984"), "Advanced")
//                new Dancer("Bob", "Johnson", 22, "Beginner")
                // Add more dancers as needed
        );

        // Example: Create a ListView to display dancers
        listView = new ListView<>(dancerList);

        // Set up the layout
        getChildren().add(listView);

        // You can customize the appearance and add more components as needed
    }
}