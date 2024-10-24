package org.example.javafx1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WidgetHider extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Прятатель виджетов");

        Label widget1 = new Label("Погода");
        Label widget2 = new Label("Транспорт");
        Label widget3 = new Label("Заметки");

        CheckBox checkBox1 = new CheckBox("Показать Виджет 1");
        checkBox1.setSelected(true);
        checkBox1.setOnAction(e -> widget1.setVisible(checkBox1.isSelected()));

        CheckBox checkBox2 = new CheckBox("Показать Виджет 2");
        checkBox2.setSelected(true);
        checkBox2.setOnAction(e -> widget2.setVisible(checkBox2.isSelected()));

        CheckBox checkBox3 = new CheckBox("Показать Виджет 3");
        checkBox3.setSelected(true);
        checkBox3.setOnAction(e -> widget3.setVisible(checkBox3.isSelected()));

        VBox vbox = new VBox(10, checkBox1, widget1, checkBox2, widget2, checkBox3, widget3);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
