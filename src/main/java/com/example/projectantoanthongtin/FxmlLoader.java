package com.example.projectantoanthongtin;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {

    @FXML
    private Pane view;

    @FXML
    public Pane getPage(String fileName) {
        try {
            String s = fileName+".fxml";
            URL fileUrl = HelloApplication.class.getResource(s);
          
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            System.out.println("No page " + fileName + " please check FxmlLoader.");
        }
        return view;
    }
}
