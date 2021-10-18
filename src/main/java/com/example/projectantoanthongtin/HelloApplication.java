package com.example.projectantoanthongtin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 500);
        stage.getIcons().add(new Image("file:C:/Users/minhh/OneDrive/Máy tính/logohacker.jpg"));
        stage.setTitle("JavaFX App");
        stage.setScene(scene);
        stage.show();
        root.requestFocus();

    }

    public static void main(String[] args) {
        launch();
    }
}