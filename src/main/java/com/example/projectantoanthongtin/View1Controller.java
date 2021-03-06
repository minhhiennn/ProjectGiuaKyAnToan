package com.example.projectantoanthongtin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.util.List;

public class View1Controller {

    @FXML
    private AnchorPane primaryStagePane;

    @FXML
    public void onActionBt1(ActionEvent actionEvent) {
        System.out.println(primaryStagePane.getId());
        Stage stage = (Stage) primaryStagePane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        List<File> selectedMultiOrOneFile = fileChooser.showOpenMultipleDialog(stage);
        if (selectedMultiOrOneFile != null) {
            selectedMultiOrOneFile.forEach((file) -> {
                System.out.println(file.getPath());
            });
        }
    }

    public void choosefilesencrypt(ActionEvent actionEvent) {
        System.out.println(primaryStagePane.getId());
        Stage stage = (Stage) primaryStagePane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        List<File> selectedMultiOrOneFile = fileChooser.showOpenMultipleDialog(stage);
        if (selectedMultiOrOneFile != null) {
            selectedMultiOrOneFile.forEach((file) -> {
                // n??y l?? duy???t qua t???ng file
                // v???n ????? logic gi???i quy???t ??? ????y
                System.out.println(file.getPath());
            });
        }
    }

    public void choosefilesdecrypt(ActionEvent actionEvent) {
        System.out.println(primaryStagePane.getId());
        Stage stage = (Stage) primaryStagePane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        List<File> selectedMultiOrOneFile = fileChooser.showOpenMultipleDialog(stage);
        if (selectedMultiOrOneFile != null) {
            selectedMultiOrOneFile.forEach((file) -> {
                // n??y l?? duy???t qua t???ng file
                // v???n ????? logic gi???i quy???t ??? ????y
                System.out.println(file.getPath());
            });
        }
    }

    public void choosefolderencrypt(ActionEvent actionEvent) {

        System.out.println(primaryStagePane.getId());
        Stage stage = (Stage) primaryStagePane.getScene().getWindow();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDir = directoryChooser.showDialog(stage);

        // n???u ch???n v??o Dir
        if (selectedDir != null) {
            // ph???n n??y in ra ???????c ???????ng d???n folder m??nh ch???n
            System.out.println(selectedDir.getAbsolutePath());
            // in ra th??? list file trong folder
            File[] file = selectedDir.listFiles();
            for (File f : file) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
