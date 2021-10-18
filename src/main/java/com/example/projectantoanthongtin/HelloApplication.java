package com.example.projectantoanthongtin;

import animatefx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {

    class Header extends Pane {

        private ToolBar toolBar;

        public Header(ToolBar toolBar) {

            // để theo kiểu thiết kế pro của Hiển pro
            this.toolBar = toolBar;

            // xét width height cho thằng Pane
            this.prefHeight(40.0);
            this.prefWidth(600.0);
            //xét thêm background color
            this.setStyle("-fx-background-color:black");

            // tạo ImageView
            ImageView imamgeView = new ImageView(new Image("file:C:/Users/minhh/OneDrive/Máy tính/logohacker.jpg"));
            imamgeView.setFitHeight(15.0);
            imamgeView.setFitWidth(15.0);
            imamgeView.setLayoutX(10.0);
            imamgeView.setLayoutY(14.0);
            imamgeView.setPickOnBounds(true);
            imamgeView.setPreserveRatio(true);

            // tạo Text
            Text text = new Text("emlama123");
            text.setFill(Color.WHITE);
            text.setLayoutX(260.0);
            text.setLayoutY(25.0);
            text.setStrokeType(StrokeType.OUTSIDE);
            text.setStrokeWidth(0.0);

            //thêm tất cả vào Pane
            this.getChildren().add(imamgeView);
            this.getChildren().add(toolBar);
            this.getChildren().add(text);

        }

    }

    class ToolBarHeader extends ToolBar {

        private Node background;

        public ToolBarHeader(Node background) {

            this.background = background;

            this.setLayoutX(500.0);
            this.setPrefHeight(40.0);
            this.setPrefWidth(100.0);
            this.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            this.setStyle("-fx-background-color:black");


            // thêm 2 nút cho header
            Button closeBtn = new Button("X");
            closeBtn.setStyle("-fx-background-color: transparent;-fx-text-fill:white");
            Button Btn2 = new Button("_");
            Btn2.setStyle("-fx-background-color: transparent;-fx-text-fill:white");

            // set Action cho nút close
            closeBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Platform.exit();
                }
            });

            //set Action cho nút minimize
            Btn2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AnimationFX fx = new ZoomOutDown(background);
                    fx.setSpeed(0.5D);
                    fx.setResetOnFinished(true);
                    Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                    fx.setOnFinished(actionEvent2 -> stage.setIconified(true));
                    fx.play();
                }
            });


            this.getItems().add(closeBtn);
            this.getItems().add(Btn2);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {

        //remove window decoration
        stage.initStyle(StageStyle.TRANSPARENT);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view.fxml"));
        Parent root = fxmlLoader.load();
        BorderPane borderPane = new BorderPane();
        ToolBar toolBar = new ToolBarHeader(borderPane);
        Pane pane = new Header(toolBar);
        borderPane.setTop(pane);
        borderPane.setCenter(root);
        Scene scene = new Scene(borderPane, 600, 540);
        stage.setScene(scene);
        stage.show();
        root.requestFocus();

    }

    public static void main(String[] args) {
        launch();
    }
}