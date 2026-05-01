package co.edu.poli.contexto2.vista;

import co.edu.poli.mvc.controlador.controlador_formulario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/co/edu/poli/contexto2/vista/menu.fxml"));
        Parent root = loader.load();

        controlador_formulario ctrl = loader.getController();
        ctrl.setStage(primaryStage);

        primaryStage.setTitle("Gestion de Alimentos - Nave Espacial");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}