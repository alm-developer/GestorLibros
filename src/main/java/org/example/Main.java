package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.View.IncioSesionUI;

public class Main extends Application {

    //el main debe de extender de aplicacion y no debe tener mas que el extends aplication nada de pasarle args por el estilo

    @Override
    public void start(Stage primaryStage) throws Exception {
    IncioSesionUI pantalla = new IncioSesionUI();
    Scene escena = new Scene(pantalla,1200,720);
    primaryStage.setScene(escena);
    primaryStage.setTitle("InicioSesion");
    primaryStage.show();
    primaryStage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

