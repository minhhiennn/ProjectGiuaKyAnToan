package com.example.projectantoanthongtin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setTitle("JavaFX App");
//
//        FileChooser fileChooser = new FileChooser();
//
//        Button button = new Button("Select File");
//        button.setOnAction(e -> {
//            File selectedFile = fileChooser.showOpenDialog(stage);
//        });
//
//        VBox vBox = new VBox(button);
//        Scene scene = new Scene(vBox, 960, 600);
//
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}