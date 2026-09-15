package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ui.LoginUI;

public class Main extends Application {

    //el main debe de extender de aplicacion y no debe tener mas que el extends aplication nada de pasarle args por el estilo

    @Override
    public void start(Stage primaryStage) {
        try {
            Scene escena = new Scene(new LoginUI(),1200,700);
            primaryStage.setScene(escena);
            primaryStage.setTitle("LoginUI");
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

