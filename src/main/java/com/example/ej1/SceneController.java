package com.example.ej1;

import com.example.ej1.Entity.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent parent;


    private void switchScreen(ActionEvent actionEvent, String fxml) throws IOException {
        parent = FXMLLoader.load(getClass().getResource(fxml));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    private void switchScreen(ActionEvent actionEvent, Parent root) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToContactoEncontrado(ActionEvent actionEvent, Contacto contacto) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("contacto-entontrado-view.fxml"));
        Parent root = loader.load();

        ContactoEncontradoController controller = loader.getController();
        controller.initialize(contacto);

        switchScreen(actionEvent, root);
    }

    public void switchToEditarContactoEncontrado(ActionEvent actionEvent, Contacto contacto) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editar-contacto-encontrado-view.fxml"));
        Parent root = loader.load();

        EditarContactoEntontradoController controller = loader.getController();
        controller.initialize(contacto);

        switchScreen(actionEvent, root);
    }


    public void switchToAgregar(ActionEvent actionEvent) throws IOException {
        switchScreen(actionEvent, "agregar-contacto-view.fxml");
    }

    public void switchToInicio(ActionEvent actionEvent) throws IOException {
        switchScreen(actionEvent, "contacto-view.fxml");
    }


    public void switchToBuscar(ActionEvent actionEvent) throws IOException {
        switchScreen(actionEvent, "buscar-contacto-view.fxml");
    }

    public void switchToListar(ActionEvent actionEvent) throws IOException {
        switchScreen(actionEvent, "listar-contactos-view.fxml");
    }
}
