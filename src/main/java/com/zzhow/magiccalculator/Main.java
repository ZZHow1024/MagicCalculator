package com.zzhow.magiccalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * @author ZZHow
 * @date 2024/7/11
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MagicCalculator");
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/icon.png")));
        stage.getIcons().add(icon);
        stage.setResizable(false);
        Pane load = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("MagicCalculator.fxml")));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}
