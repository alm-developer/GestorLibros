package org.example.view;

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
        this.getStylesheets().add(getClass().getResource("/estilos/estilos.css").toExternalForm());

        HBox divisor = new HBox();
        setCenter(divisor);
        HBox.setHgrow(divisor, Priority.ALWAYS);
        divisor.setStyle("-fx-background-color: blue;");

        VBox izquierda = new VBox();
        HBox.setHgrow(izquierda, Priority.ALWAYS);
        izquierda.setStyle("-fx-background-color: yellow;");

        VBox derecha = new VBox();
        HBox.setHgrow(derecha, Priority.ALWAYS);
        derecha.setStyle("-fx-background-color: red;");
        derecha.setPadding(new Insets(100));

        Label title  = new Label("Inicio Sesion");
        title.getStyleClass().add("titulos1");

        Label userText  = new Label("Usuario");

        TextField entUser = new TextField();

        Label paswText  = new Label("Contraseña");

        TextField entpasw = new TextField();

        derecha.getChildren().addAll(title,userText,entUser,paswText,entpasw);
        divisor.getChildren().addAll(izquierda,derecha);


    }

}
