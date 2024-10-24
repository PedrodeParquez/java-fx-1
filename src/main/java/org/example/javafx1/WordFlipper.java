package org.example.javafx1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WordFlipper extends Application {

    private boolean toSecond = true;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Перекидыватель слов");

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        Button switchButton = new Button("->");

        switchButton.setOnAction(e -> {
            if (toSecond) {
                textField2.setText(textField1.getText());
                textField1.clear();
                switchButton.setText("<-");
            } else {
                textField1.setText(textField2.getText());
                textField2.clear();
                switchButton.setText("->");
            }
            toSecond = !toSecond;
        });

        HBox hbox = new HBox(10, textField1, switchButton, textField2);
        Scene scene = new Scene(hbox, 400, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
