package com.example.projectantoanthongtin;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class View1Controller {

    @FXML
    private BorderPane mainPane;

    @FXML
    public void onActionBt1(ActionEvent actionEvent) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
    }

    @FXML
    public void onActionBt2(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Screen2");
        mainPane.setCenter(view);
        mainPane.setMargin(view, new Insets(220, 20, 20, 50));
    }

    @FXML
    public void onActionBt3(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Screen3");
        mainPane.setCenter(view);
        mainPane.setMargin(view, new Insets(220, 20, 20, 50));
    }

    @FXML
    public void onActionBt4(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Screen4");
        mainPane.setCenter(view);
        mainPane.setMargin(view, new Insets(220, 20, 20, 50));
    }

    @FXML
    public void onActionBt5(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Screen5");
        mainPane.setCenter(view);
        mainPane.setMargin(view, new Insets(220, 20, 20, 50));
    }
}
