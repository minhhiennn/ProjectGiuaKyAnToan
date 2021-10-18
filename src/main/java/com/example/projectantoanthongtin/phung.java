package com.example.projectantoanthongtin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class phung extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(phung.class.getResource("view1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setTitle("phung90x");
    }

    public static void main(String[] args) {
        launch();
    }
}