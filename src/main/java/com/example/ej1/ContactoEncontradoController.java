package com.example.ej1;

import com.example.ej1.Controller.GestorDeContactos;
import com.example.ej1.Entity.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

import static com.example.ej1.HelloApplication.showAlert;

public class ContactoEncontradoController {

    @FXML
    private Text textEmail;
    @FXML
    private Text textNombre;

    @FXML
    private Text textApellido;
    @FXML
    private Text textTelefono;

    private Contacto contacto;

    public void initialize(Contacto contacto) {
        this.contacto = contacto;
        this.textEmail.setText(contacto.getEmail());
        this.textNombre.setText(contacto.getNombre());
        this.textApellido.setText(contacto.getApellido());
        this.textTelefono.setText(String.valueOf(contacto.getTelefono()));
    }

    public void onVolver(ActionEvent actionEvent) throws IOException, IOException {
        SceneController sceneController = new SceneController();
        sceneController.switchToInicio(actionEvent);
    }

    public void onEliminar(ActionEvent actionEvent) {
        try{
            GestorDeContactos.removeContacto(contacto);
            showAlert("Contacto eliminado", "Contacto eliminado", "El contacto ha sido eliminado");
            SceneController sceneController = new SceneController();
            sceneController.switchToInicio(actionEvent);
        } catch (Exception e){
            showAlert("Error", "Error", "No se ha podido eliminar el contacto");
        }
    }

    public void onEditar(ActionEvent actionEvent) {
        try{
            SceneController sceneController = new SceneController();
            sceneController.switchToEditarContactoEncontrado(actionEvent, contacto);
        } catch (Exception e){
            showAlert("Error", "Error", "No se ha podido editar el contacto");
        }
    }
}
