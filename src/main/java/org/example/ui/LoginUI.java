package org.example.ui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class LoginUI extends BorderPane {

    public LoginUI() {
        HBox general = new HBox();
        setCenter(general);

        VBox izquierda = new VBox();
        HBox.setHgrow(izquierda, Priority.ALWAYS);
        izquierda.setStyle("-fx-background-color: blue");
        VBox derecha = new VBox();
        HBox.setHgrow(derecha, Priority.ALWAYS);
        derecha.setStyle("-fx-background-color: red;");



        general.getChildren().addAll(izquierda,derecha);

    }

}
