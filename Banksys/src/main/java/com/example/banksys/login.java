package com.example.banksys;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class login extends Application{
    //    private static Stage stg;
    double x,y=0;
    @Override
    public void start(Stage stage) throws IOException,InvalidPass {
        SystemManager.initialize();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        final double[] xOffset = {0};
        final double[] yOffset = {0};

        root.setOnMousePressed(evt -> {
            xOffset[0] = evt.getSceneX();
            yOffset[0] = evt.getSceneY();
        });

        root.setOnMouseDragged(evt -> {
            stage.setX(evt.getScreenX() - xOffset[0]);
            stage.setY(evt.getScreenY() - yOffset[0]);
        });
        stage.setScene(scene);
        stage.show();
    }
//    public void ChangeScene(String fxml) throws IOException{
//
//        Parent pane= FXMLLoader.load(getClass().getResource(fxml));
//        stg.getScene().setRoot(pane);
//    }



}

