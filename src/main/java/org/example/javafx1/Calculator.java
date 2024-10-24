package org.example.javafx1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Калькулятор");

        TextField num1Field = new TextField();
        TextField num2Field = new TextField();
        TextField resultField = new TextField();
        resultField.setEditable(false);

        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");

        addButton.setOnAction(e -> calculate(num1Field, num2Field, resultField, "+"));
        subtractButton.setOnAction(e -> calculate(num1Field, num2Field, resultField, "-"));
        multiplyButton.setOnAction(e -> calculate(num1Field, num2Field, resultField, "*"));
        divideButton.setOnAction(e -> calculate(num1Field, num2Field, resultField, "/"));

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Label("Число 1:"), 0, 0);
        grid.add(num1Field, 1, 0);
        grid.add(new Label("Число 2:"), 0, 1);
        grid.add(num2Field, 1, 1);
        grid.add(new Label("Результат:"), 0, 2);
        grid.add(resultField, 1, 2);
        grid.add(addButton, 0, 3);
        grid.add(subtractButton, 1, 3);
        grid.add(multiplyButton, 0, 4);
        grid.add(divideButton, 1, 4);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate(TextField num1Field, TextField num2Field, TextField resultField, String operation) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result;

            switch (operation) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        showAlert("Ошибка", "Деление на ноль!");
                        return;
                    }
                    result = num1 / num2;
                }
                default -> throw new IllegalArgumentException("Неверная операция");
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            showAlert("Ошибка", "Неверный формат числа!");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
