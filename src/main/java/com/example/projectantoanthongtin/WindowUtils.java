package com.example.projectantoanthongtin;

import javafx.stage.Screen;
import javafx.stage.Stage;

public class WindowUtils {
    private WindowUtils() { }

    public static void placeAtPrimaryScreenBottom(Stage stage) {
        stage.setY(Screen.getPrimary().getVisualBounds().getMaxY() - stage.getHeight());
    }
}
