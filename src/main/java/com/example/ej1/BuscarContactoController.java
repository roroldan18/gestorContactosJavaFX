package com.example.ej1;

import com.example.ej1.Controller.GestorDeContactos;
import com.example.ej1.Entity.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.ej1.HelloApplication.showAlert;

public class BuscarContactoController {
    @FXML
    private TextField emailInput;


    public void onBuscar(ActionEvent actionEvent) throws IOException {
        Contacto contacto = (Contacto) GestorDeContactos.buscarContacto(emailInput.getText());

        if (contacto != null) {
            SceneController sceneController = new SceneController();
            sceneController.switchToContactoEncontrado(actionEvent, contacto);
        } else {
            showAlert("Error", "Error", "No se ha encontrado el contacto");
        }
    }

    public void onVolver(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.switchToInicio(actionEvent);
    }
}
