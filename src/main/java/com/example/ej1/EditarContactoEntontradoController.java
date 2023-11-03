package com.example.ej1;

import com.example.ej1.Controller.GestorDeContactos;
import com.example.ej1.Entity.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import static com.example.ej1.HelloApplication.showAlert;

public class EditarContactoEntontradoController {

    @FXML
    private Text textEmail;

    @FXML
    private TextField nombreInput;

    @FXML
    private TextField apellidoInput;

    @FXML
    private TextField telefonoInput;

    private Contacto contacto;

    public void initialize(Contacto contacto) {
        this.contacto = contacto;
        this.textEmail.setText(contacto.getEmail());
    }

    public void onEditar(ActionEvent actionEvent) {
        try {
            Contacto contactoEditado = new Contacto(nombreInput.getText(), apellidoInput.getText(), Integer.parseInt(telefonoInput.getText()), contacto.getEmail());
            GestorDeContactos.editContacto(contacto, contactoEditado);
            showAlert("Contacto editado", "Contacto editado", "El contacto ha sido editado correctamente");
        } catch (Exception e) {
            showAlert("Error", "Error", "No se ha podido editar el contacto");
        }

    }

    public void onCancelar(ActionEvent actionEvent) {
        try {
            SceneController sceneController = new SceneController();
            sceneController.switchToInicio(actionEvent);
        } catch (Exception e) {
            showAlert("Error", "Error", "No se ha podido editar el contacto");
        }
    }
}
