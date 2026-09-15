package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.FXPermission;
public class Main extends Application {

    //el main debe de extender de aplicacion y no debe tener mas que el extends aplication nada de pasarle args por el estilo

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vista/PaginaInicioRegistro.fxml"));
            Scene escena = new Scene(root,1200,700);
            primaryStage.setScene(escena);
            primaryStage.setTitle("InicioSesion");
            primaryStage.setFullScreen(true);
            primaryStage.show();
        }catch (Exception e) {
            e.printStackTrace(); // <--- Esto te mostrará la línea exacta del fallo
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}

