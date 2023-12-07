package com.example.scrutineerFX;

import Scrutineer.DB.DancerDAO;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import Scrutineer.Participants.Dancer;
import javafx.util.converter.IntegerStringConverter;

public class DancerView extends BorderPane{
    private TableView<Dancer> tblDancer;

    private TextField txtId;
    private TextField fNameTextField;
    private TextField lNameTextField;
    private TextField ageTextField;
    private TextField danceLevelTextField;

    private Button btnAddNew;
    private Button btnDelete;
    private Button btnUpdate;


    public DancerView() {
        tblDancer = new  TableView<Dancer>();
        ScrollPane pane = new ScrollPane(tblDancer);
        pane.setMaxHeight(280);

        btnAddNew = new Button("Add New");
        btnDelete = new Button("Delete");
        btnUpdate = new Button("Update");

        HBox hBoxMiddle = new HBox(btnAddNew, btnDelete, btnUpdate);
        hBoxMiddle.setAlignment(Pos.TOP_CENTER);
        hBoxMiddle.getStyleClass().add("hbox");

        GridPane gridPaneBottom = new GridPane();
        gridPaneBottom.getStyleClass().add("pane");
        gridPaneBottom.add(new Label("Id:"), 0, 0);
        gridPaneBottom.add(new Label("First Name:"), 2, 0);
        gridPaneBottom.add(new Label("Last Name:"), 2, 1);
        gridPaneBottom.add(new Label("Age:"), 4, 0);
        gridPaneBottom.add(new Label("Dance Level:"), 4, 1);

        txtId = new TextField();
        txtId.setEditable(false);
        txtId.setVisible(false);
        fNameTextField = new TextField();
        fNameTextField.setPrefWidth(120);
        fNameTextField.setMaxWidth(120);
        lNameTextField = new TextField();
        lNameTextField.setPrefWidth(120);
        lNameTextField.setMaxWidth(120);
        ageTextField = new TextField();
        ageTextField.setPrefWidth(120);
        ageTextField.setMaxWidth(120);
        danceLevelTextField = new TextField();
        danceLevelTextField.setPrefWidth(120);
        danceLevelTextField.setMaxWidth(120);

        gridPaneBottom.add(txtId, 1, 0);
        gridPaneBottom.add(fNameTextField, 3, 0);
        gridPaneBottom.add(lNameTextField, 3, 1);
        gridPaneBottom.add(ageTextField, 5, 0);
        gridPaneBottom.add(danceLevelTextField, 5, 1);
        gridPaneBottom.setMaxHeight(200);

        setTop(pane);
        setCenter(hBoxMiddle);
        setBottom(gridPaneBottom);
    }

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

    public TextField getAgeTextField() {
        return ageTextField;
    }

    public TextField getDanceLevelTextField() {
        return danceLevelTextField;
    }

    public void FormatTable() {

        tblDancer.setEditable(true);

        TableColumn<Dancer, Integer> idCol = new TableColumn<>("Id");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("dancerId"));

        TableColumn<Dancer, String> fNameCol = new TableColumn<>("First Name");
        fNameCol.setMinWidth(100);
        fNameCol.setCellValueFactory(new PropertyValueFactory<Dancer, String>("fName"));
        fNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        fNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Dancer, String>>() {
            @Override
            public void handle(CellEditEvent<Dancer, String> t) {
                ((Dancer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFName(t.getNewValue());
                Dancer d = getTblDancer().getSelectionModel().getSelectedItem();
                DancerDAO model = new DancerDAO();
                model.update(d);
            }
        });

        TableColumn<Dancer, String> lNameCol = new TableColumn<>("Last Name");
        lNameCol.setMinWidth(100);
        lNameCol.setCellValueFactory(new PropertyValueFactory<Dancer, String>("lName"));
        lNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        lNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Dancer, String>>() {
            @Override
            public void handle(CellEditEvent<Dancer, String> t) {
                ((Dancer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLName(t.getNewValue());
                Dancer d = getTblDancer().getSelectionModel().getSelectedItem();
                DancerDAO model = new DancerDAO();
                model.update(d);
            }
        });

        TableColumn<Dancer, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setMinWidth(50);
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        //ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ageCol.setOnEditCommit(new EventHandler<CellEditEvent<Dancer, Integer>>() {
            @Override
            public void handle(CellEditEvent<Dancer, Integer> t) {
                ((Dancer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAge(t.getNewValue());
                Dancer d = getTblDancer().getSelectionModel().getSelectedItem();
                DancerDAO model = new DancerDAO();
                model.update(d);
            }
        });

        TableColumn<Dancer, String> danceLevelCol = new TableColumn<>("Dance Level");
        danceLevelCol.setMinWidth(100);
        danceLevelCol.setCellValueFactory(new PropertyValueFactory<Dancer, String>("danceLevel"));
        danceLevelCol.setCellFactory(TextFieldTableCell.forTableColumn());

        danceLevelCol.setOnEditCommit(new EventHandler<CellEditEvent<Dancer, String>>() {
            @Override
            public void handle(CellEditEvent<Dancer, String> t) {
                ((Dancer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDanceLevel(t.getNewValue());
                Dancer d = getTblDancer().getSelectionModel().getSelectedItem();
                DancerDAO model = new DancerDAO();
                model.update(d);
            }
        });

        tblDancer.getColumns().addAll(idCol, fNameCol, lNameCol, ageCol, danceLevelCol);

    }



}
