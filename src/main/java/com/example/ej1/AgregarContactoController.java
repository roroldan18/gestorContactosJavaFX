package com.example.ej1;

import com.example.ej1.Controller.GestorDeContactos;
import com.example.ej1.Entity.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.ej1.HelloApplication.showAlert;

public class AgregarContactoController {

    @FXML
    private TextField nombreInput;

    @FXML
    private TextField apellidoInput;

    @FXML
    private TextField telefonoInput;

    @FXML
    private TextField emailInput;



    public void onAgregar(ActionEvent actionEvent) throws IOException {
        String name = this.nombreInput.getText();
        String lastName = this.apellidoInput.getText();
        int phone = 0;
        String email = this.emailInput.getText();

        try{
            phone = Integer.parseInt(this.telefonoInput.getText());
        } catch (NumberFormatException e) {
            showAlert("Error", "Teléfono incorrecto", "El teléfono debe ser un número");
            return;
        }

        if(!GestorDeContactos.checkEmail(email)){
            showAlert("Error", "Email incorrecto", "El email debe tener un formato correcto");
            return;
        }

        Contacto contacto = new Contacto(name, lastName, phone, email);
        GestorDeContactos.addContacto(contacto);


        showAlert("Contacto agregado", "Contacto agregado", "El contacto ha sido agregado correctamente");
        this.nombreInput.setText("");
        this.apellidoInput.setText("");
        this.telefonoInput.setText("");
        this.emailInput.setText("");

        SceneController sceneController = new SceneController();
        sceneController.switchToInicio(actionEvent);

    }



    public void onCancelar(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.switchToInicio(actionEvent);
    }
}
