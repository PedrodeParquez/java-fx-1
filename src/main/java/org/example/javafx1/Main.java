package org.example.javafx1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Задачи");

        Button WordFlipperButton = new Button("Перекидыватель слов");
        WordFlipperButton.setOnAction(e -> new WordFlipper().start(new Stage()));

        Button WidgetHiderButton = new Button("Cкрыватель виджетов");
        WidgetHiderButton.setOnAction(e -> new WidgetHider().start(new Stage()));

        Button OrderAtRestaurantButton = new Button("Заказ в ресторане");
        OrderAtRestaurantButton.setOnAction(e -> new OrderAtRestaurant().start(new Stage()));

        Button CalculatorButton = new Button("Калькулятор");
        CalculatorButton.setOnAction(e -> new Calculator().start(new Stage()));

        Button TextFlagButton = new Button("Текстовый флаг");
        TextFlagButton.setOnAction(e -> new TextFlag().start(new Stage()));

        VBox vbox = new VBox(10, WordFlipperButton, WidgetHiderButton, OrderAtRestaurantButton, CalculatorButton, TextFlagButton);
        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}