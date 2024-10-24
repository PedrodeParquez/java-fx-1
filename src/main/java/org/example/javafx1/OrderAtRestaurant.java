package org.example.javafx1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class OrderAtRestaurant extends Application {

    private final List<MenuItem> menuItems = List.of(
            new MenuItem("Салат", 200),
            new MenuItem("Суп", 150),
            new MenuItem("Паста", 300),
            new MenuItem("Стейк", 500),
            new MenuItem("Десерт", 250)
    );

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Заказ в ресторане");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        List<CheckBox> checkBoxes = new ArrayList<>();
        List<TextField> quantityFields = new ArrayList<>();

        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);

            CheckBox checkBox = new CheckBox(item.getName());
            TextField quantityField = new TextField("1");
            quantityField.setPrefWidth(50);

            checkBoxes.add(checkBox);
            quantityFields.add(quantityField);

            gridPane.add(checkBox, 0, i);
            gridPane.add(new Label("Количество:"), 1, i);
            gridPane.add(quantityField, 2, i);
        }

        Button orderButton = new Button("Оформить заказ");
        orderButton.setOnAction(e -> handleOrder(checkBoxes, quantityFields));

        VBox vbox = new VBox(10, gridPane, orderButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleOrder(List<CheckBox> checkBoxes, List<TextField> quantityFields) {
        double totalAmount = 0;
        StringBuilder receipt = new StringBuilder("Чек:\n");

        for (int i = 0; i < checkBoxes.size(); i++) {
            CheckBox checkBox = checkBoxes.get(i);
            TextField quantityField = quantityFields.get(i);

            if (checkBox.isSelected()) {
                int quantity;
                try {
                    quantity = Integer.parseInt(quantityField.getText());
                    if (quantity <= 0) {
                        continue; // Пропустить позиции с нулевым или отрицательным количеством
                    }
                } catch (NumberFormatException e) {
                    showError("Извините", "Введите, пожалуйста, корректное количество для " + checkBox.getText());
                    return;
                }

                MenuItem item = menuItems.get(i);
                double itemTotal = item.getPrice() * quantity;
                totalAmount += itemTotal;

                receipt.append(String.format("%s: %d x %.2f = %.2f\n", item.getName(), quantity, item.getPrice(), itemTotal));
            }
        }

        if (totalAmount == 0) {
            showError("Ошибка", "Выберите хотя бы одно блюдо с количеством больше нуля.");
            return;
        }

        receipt.append(String.format("\nОбщая стоимость: %.2f", totalAmount));

        showReceipt(receipt.toString());
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showReceipt(String receipt) {
        Stage receiptStage = new Stage();
        receiptStage.initModality(Modality.APPLICATION_MODAL);
        receiptStage.setTitle("Чек");

        TextArea textArea = new TextArea(receipt);
        textArea.setEditable(false);

        Scene scene = new Scene(new VBox(textArea), 300, 200);
        receiptStage.setScene(scene);
        receiptStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    static class MenuItem {
        private final String name;
        private final double price;

        public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
