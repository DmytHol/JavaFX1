package com.scrutineerFX;

import Scrutineer.DB.DancerDAO;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import Scrutineer.Participants.Dancer;
import javafx.util.converter.DateStringConverter;
import javafx.scene.control.DatePicker;


import java.util.Date;


public class DancerView extends BorderPane {
    private TableView<Dancer> tblDancer;
    private TextField txtId;
    private TextField fNameTextField;
    private TextField lNameTextField;
    //private TextField ageTextField;

    private TextField danceLevelTextField;
    private Button btnAddNew;
    private Button btnDelete;
    private Button btnUpdate;

    private DatePicker dateOfBirthPicker;

    public DancerView() {

        // Initialize TableView and ScrollPane
        tblDancer = new TableView<>();
        ScrollPane pane = new ScrollPane(tblDancer);
        pane.setMaxHeight(280);

        // Initialize Buttons
        btnAddNew = new Button("Add New");
        btnDelete = new Button("Delete");
        btnUpdate = new Button("Update");

        // Create HBox for Buttons
        HBox hBoxMiddle = new HBox(btnAddNew, btnDelete, btnUpdate);
        hBoxMiddle.setAlignment(Pos.TOP_CENTER);
        hBoxMiddle.getStyleClass().add("hbox");

        // Crete GridPane for labels and text fields
        GridPane gridPaneBottom = new GridPane();
        gridPaneBottom.getStyleClass().add("pane");
        gridPaneBottom.add(new Label("Id:"), 0, 0);
        gridPaneBottom.add(new Label("First Name:"), 2, 0);
        gridPaneBottom.add(new Label("Last Name:"), 2, 1);
        gridPaneBottom.add(new Label("DOB:"), 4, 0);
        gridPaneBottom.add(new Label("Dance Level:"), 4, 1);
        // Add DatePicker for Date of Birth
        dateOfBirthPicker = new DatePicker();
        dateOfBirthPicker.setPrefWidth(120);
        dateOfBirthPicker.setMaxWidth(120);
        gridPaneBottom.add(dateOfBirthPicker, 5, 0);

        // Initialize TextFields
        txtId = new TextField();
        txtId.setEditable(false);
        txtId.setVisible(false);
        fNameTextField = new TextField();
        fNameTextField.setPrefWidth(120);
        fNameTextField.setMaxWidth(120);
        lNameTextField = new TextField();
        lNameTextField.setPrefWidth(120);
        lNameTextField.setMaxWidth(120);
//        ageTextField = new TextField();
//        ageTextField.setPrefWidth(120);
//        ageTextField.setMaxWidth(120);
        danceLevelTextField = new TextField();
        danceLevelTextField.setPrefWidth(120);
        danceLevelTextField.setMaxWidth(120);

        // Add labels and text fields to GridPane
        gridPaneBottom.add(txtId, 1, 0);
        gridPaneBottom.add(fNameTextField, 3, 0);
        gridPaneBottom.add(lNameTextField, 3, 1);
        //gridPaneBottom.add(ageTextField, 5, 0);
        gridPaneBottom.add(danceLevelTextField, 5, 1);
        gridPaneBottom.setMaxHeight(200);

        // Set layout components
        setTop(pane);
        setCenter(hBoxMiddle);
        setBottom(gridPaneBottom);
    }

    // Getters for buttons, text fields, and TableView
    public Button getBtnAddNew() {
        return btnAddNew;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public Button getBtnUpdate() {
        return btnUpdate;
    }

    public TableView<Dancer> getTblDancer() {
        return tblDancer;
    }

    public TextField getTxtId() {
        return txtId;
    }

    public TextField getfName() {
        return fNameTextField;
    }

    public TextField getlName() {
        return lNameTextField;
    }

//    public TextField getAgeTextField() {
//        return ageTextField;
//    }
    public DatePicker getDateOfBirthPicker() {
        return dateOfBirthPicker;
    }

    public TextField getDanceLevelTextField() {
        return danceLevelTextField;
    }

    // Format TableView with editable columns
    public void formatTable() {
        tblDancer.setEditable(true);

        // Create columns for TableView
        TableColumn<Dancer, Integer> idCol = new TableColumn<>("Id");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("dancerId"));

        TableColumn<Dancer, String> fNameCol = new TableColumn<>("First Name");
        fNameCol.setMinWidth(100);
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("fName"));
        fNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        // handle edits to First Name column
        fNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Dancer, String>>() {
            @Override
            public void handle(CellEditEvent<Dancer, String> t) {
                ((Dancer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFName(t.getNewValue());
                Dancer d = getTblDancer().getSelectionModel().getSelectedItem();
                DancerDAO model = new DancerDAO();
                model.update(d);
            }
        });

        // Create columns for Last Name
        TableColumn<Dancer, String> lNameCol = new TableColumn<>("Last Name");
        lNameCol.setMinWidth(100);
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lName"));
        lNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        // handle edits to Last Name column
        lNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Dancer, String>>() {
            @Override
            public void handle(CellEditEvent<Dancer, String> t) {
                ((Dancer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLName(t.getNewValue());
                Dancer d = getTblDancer().getSelectionModel().getSelectedItem();
                DancerDAO model = new DancerDAO();
                model.update(d);
            }
        });

        // Create columns for Date of Birth
        TableColumn<Dancer, Date> dateOfBirthCol = new TableColumn<>("Date of Birth");
        dateOfBirthCol.setMinWidth(100);
        dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        dateOfBirthCol.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));

        // handle edits to Date of Birth column
        dateOfBirthCol.setOnEditCommit(new EventHandler<CellEditEvent<Dancer, Date>>() {
            @Override
            public void handle(CellEditEvent<Dancer, Date> t) {
                ((Dancer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDateOfBirth(t.getNewValue());
                Dancer d = getTblDancer().getSelectionModel().getSelectedItem();
                DancerDAO model = new DancerDAO();
                model.update(d);
            }
        });

        // Create columns for Dance Level
        TableColumn<Dancer, String> danceLevelCol = new TableColumn<>("Dance Level");
        danceLevelCol.setMinWidth(100);
        danceLevelCol.setCellValueFactory(new PropertyValueFactory<>("danceLevel"));
        danceLevelCol.setCellFactory(TextFieldTableCell.forTableColumn());

        // handle edits to Dance Level column
        danceLevelCol.setOnEditCommit(new EventHandler<CellEditEvent<Dancer, String>>() {
            @Override
            public void handle(CellEditEvent<Dancer, String> t) {
                ((Dancer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDanceLevel(t.getNewValue());
                Dancer d = getTblDancer().getSelectionModel().getSelectedItem();
                DancerDAO model = new DancerDAO();
                model.update(d);
            }
        });

        tblDancer.getColumns().addAll(idCol, fNameCol, lNameCol, dateOfBirthCol, danceLevelCol);
    }


}
