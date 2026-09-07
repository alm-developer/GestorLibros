package org.example.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.*;

public class IncioSesionUI extends BorderPane {

    public IncioSesionUI(){


        HBox divisor = new HBox();
        setCenter(divisor);
        HBox.setHgrow(divisor, Priority.ALWAYS);
        divisor.setStyle("-fx-background-color: blue;");

        VBox izquierda = new VBox();


        VBox derecha = new VBox();



        divisor.getChildren().addAll(izquierda,derecha);


    }

}
