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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        //remove window decoration
        stage.initStyle(StageStyle.UNDECORATED);
        //
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view.fxml"));
        Parent root = fxmlLoader.load();
        BorderPane borderPane = new BorderPane();
        ToolBar toolBar = new ToolBarHeader(borderPane);
        Pane pane = new Header(toolBar,stage);
        borderPane.setTop(pane);
        borderPane.setCenter(root);
        Scene scene = new Scene(borderPane, 600, 540);
        stage.setScene(scene);
        System.out.println("loz");
        stage.show();
        root.requestFocus();

    }

    public static void main(String[] args) {
        launch();
    }

    class Header extends Pane {

        private Stage primaryStage;
        private ToolBar toolBar;
        private double xOffset = 0;
        private double yOffset = 0;

        public Header(ToolBar toolBar,Stage primaryStage) {

            this.primaryStage = primaryStage;
            // để theo kiểu thiết kế pro của Hiển pro
            this.toolBar = toolBar;

            // xét width height cho thằng Pane
            this.prefHeight(40.0);
            this.prefWidth(600.0);
            //xét thêm background color
            this.setStyle("-fx-background-color:black");

            // tạo ImageView
            URL url = HelloApplication.class.getResource("Image/logoanonymous.jpg");
            System.out.println(url.toString());
            ImageView imamgeView = new ImageView(new Image(url.toString()));
            imamgeView.setFitHeight(15.0);
            imamgeView.setFitWidth(15.0);
            imamgeView.setLayoutX(10.0);
            imamgeView.setLayoutY(14.0);
            imamgeView.setPickOnBounds(true);
            imamgeView.setPreserveRatio(true);

            // tạo Text
            Text text = new Text("CrackerApp");
            text.setFill(Color.WHITE);
            text.setLayoutX(260.0);
            text.setLayoutY(25.0);
            text.setStrokeType(StrokeType.OUTSIDE);
            text.setStrokeWidth(0.0);

            //thêm tất cả vào Pane
            this.getChildren().add(imamgeView);
            this.getChildren().add(toolBar);
            this.getChildren().add(text);

            //action
            this.actionForHeaderWhenUseMouse();

        }

        //xét mouse action cho header khi người dùng dùng chuột ấn vào
        public void actionForHeaderWhenUseMouse() {

            this.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        xOffset = primaryStage.getX() - mouseEvent.getScreenX();
                        yOffset = primaryStage.getY() - mouseEvent.getScreenY();
                    }
                }
            });

            this.setOnMouseDragged(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        primaryStage.setX(mouseEvent.getScreenX() + xOffset);
                        primaryStage.setY(mouseEvent.getScreenY() + yOffset);
                    }
                }
            });
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
}