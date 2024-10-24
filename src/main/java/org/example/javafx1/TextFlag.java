package org.example.javafx1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFlag extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Текстовый флаг");

        ToggleGroup colorGroup1 = new ToggleGroup();
        ToggleGroup colorGroup2 = new ToggleGroup();
        ToggleGroup colorGroup3 = new ToggleGroup();

        RadioButton red1 = new RadioButton("Красный");
        red1.setToggleGroup(colorGroup1);
        RadioButton green1 = new RadioButton("Зелёный");
        green1.setToggleGroup(colorGroup1);
        RadioButton blue1 = new RadioButton("Синий");
        blue1.setToggleGroup(colorGroup1);

        RadioButton red2 = new RadioButton("Красный");
        red2.setToggleGroup(colorGroup2);
        RadioButton green2 = new RadioButton("Зелёный");
        green2.setToggleGroup(colorGroup2);
        RadioButton blue2 = new RadioButton("Синий");
        blue2.setToggleGroup(colorGroup2);

        RadioButton red3 = new RadioButton("Красный");
        red3.setToggleGroup(colorGroup3);
        RadioButton green3 = new RadioButton("Зелёный");
        green3.setToggleGroup(colorGroup3);
        RadioButton blue3 = new RadioButton("Синий");
        blue3.setToggleGroup(colorGroup3);

        Button drawButton = new Button("Нарисовать");
        Label resultLabel = new Label();
        Label errorLabel = new Label();

        drawButton.setOnAction(e -> {
            RadioButton selected1 = (RadioButton) colorGroup1.getSelectedToggle();
            RadioButton selected2 = (RadioButton) colorGroup2.getSelectedToggle();
            RadioButton selected3 = (RadioButton) colorGroup3.getSelectedToggle();

            if (selected1 == null || selected2 == null || selected3 == null) {
                errorLabel.setText("Пожалуйста, выберите все цвета.");
                resultLabel.setText("");
            } else {
                String color1 = selected1.getText();
                String color2 = selected2.getText();
                String color3 = selected3.getText();
                resultLabel.setText(color1 + ", " + color2 + ", " + color3);
                errorLabel.setText("");
            }
        });

        VBox vbox = new VBox(10, new HBox(10, red1, green1, blue1), new HBox(10, red2, green2, blue2), new HBox(10, red3, green3, blue3), drawButton, errorLabel, resultLabel);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
