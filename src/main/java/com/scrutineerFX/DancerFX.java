package com.scrutineerFX;

import Scrutineer.DB.DancerDAO;
import Scrutineer.Participants.Dancer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import java.time.LocalDate;
import java.util.Date;


public class DancerFX extends Application {
    private DancerDAO model;
    private DancerView view;

    @Override
    public void start(Stage primaryStage) {
        model = new DancerDAO();
        view = new DancerView();

        view.formatTable();
        view.getTblDancer().setItems(FXCollections.observableArrayList(model.findAll()));

        view.getTblDancer().setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 0) {
                if (view.getTblDancer().getSelectionModel().getSelectedItem() != null) {
                    Dancer d = view.getTblDancer().getSelectionModel().getSelectedItem();
                    view.getTxtId().setText(String.valueOf(d.getDancerId()));
                    view.getfName().setText(d.getFName());
                    view.getlName().setText(d.getLName());

                    Date dateOfBirth = d.getDateOfBirth();
                    if (dateOfBirth != null) {
                        LocalDate localDate = new java.sql.Date(dateOfBirth.getTime()).toLocalDate();
                        view.getDateOfBirthPicker().setValue(localDate);
                    }else {
                        view.getDateOfBirthPicker().setValue(null);
                    }
                    view.getDanceLevelTextField().setText(d.getDanceLevel());
                }
            }
        });

        Scene scene = new Scene(view, 650, 400, true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DancerFX Application");
        primaryStage.show();

        view.getBtnDelete().setOnAction(e -> {
            int id = Integer.parseInt(view.getTxtId().getText());
            Dancer d = model.find(id);

            String selection = d.getFName() + " " + d.getLName();
            Alert alert = new Alert(AlertType.WARNING, "Delete " + selection + " ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                model.delete(d);
                view.getTblDancer().setItems(FXCollections.observableArrayList(model.findAll()));
                view.getTxtId().setText("");
                view.getfName().setText("");
                view.getlName().setText("");
                //view.getDateOfBirthPicker().setValue(d.getDateOfBirth().toLocalDate());
                view.getDanceLevelTextField().setText("");
            }
        });

        view.getBtnAddNew().setOnAction(e -> {
            Dancer d = new Dancer();
            d.setFName(view.getfName().getText());
            d.setLName(view.getlName().getText());
            d.setDateOfBirth(java.sql.Date.valueOf(view.getDateOfBirthPicker().getValue()));
            d.setDanceLevel(view.getDanceLevelTextField().getText());
            model.add(d);
            view.getTblDancer().setItems(FXCollections.observableArrayList(model.findAll()));
            view.getTxtId().setText("");
            view.getfName().setText("");
            view.getlName().setText("");
            //view.getDateOfBirthPicker().setValue(d.getDateOfBirth().toLocalDate());
            view.getDanceLevelTextField().setText("");
        });

        view.getBtnUpdate().setOnAction(e -> {
            Dancer d = new Dancer();
            d.setDancerId(Integer.parseInt(view.getTxtId().getText()));
            d.setFName(view.getfName().getText());
            d.setLName(view.getlName().getText());
            d.setDateOfBirth(java.sql.Date.valueOf(view.getDateOfBirthPicker().getValue()));
            //d.setAge(Integer.parseInt(view.getAgeTextField().getText()));
            d.setDanceLevel(view.getDanceLevelTextField().getText());
            model.update(d);
            view.getTblDancer().setItems(FXCollections.observableArrayList(model.findAll()));
            view.getTxtId().setText("");
            view.getfName().setText("");
            view.getlName().setText("");
            //view.getAgeTextField().setText("");
            view.getDateOfBirthPicker().setValue(null);
            view.getDanceLevelTextField().setText("");
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
