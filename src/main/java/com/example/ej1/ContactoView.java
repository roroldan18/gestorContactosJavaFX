package com.example.ej1;

import com.example.ej1.Controller.GestorDeContactos;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ContactoView {
    private SceneController sceneController = new SceneController();
    public void onSalir(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onAgregar(ActionEvent actionEvent) throws IOException {
        sceneController.switchToAgregar(actionEvent);
    }


    public void onBuscarContacto(ActionEvent actionEvent) throws IOException {
        sceneController.switchToBuscar(actionEvent);
    }

    public void onListarTodos(ActionEvent actionEvent) throws IOException {
        sceneController.switchToListar(actionEvent);
    }

    public void onExportar(ActionEvent actionEvent) {
        //GestorDeContactos.exportarTxt();
        GestorDeContactos.exportarXML();
    }
}
