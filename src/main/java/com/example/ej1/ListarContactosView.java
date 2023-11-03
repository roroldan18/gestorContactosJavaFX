package com.example.ej1;

import com.example.ej1.Controller.GestorDeContactos;
import com.example.ej1.Entity.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class ListarContactosView {

    @FXML
    private ListView<String> listView;

    public void initialize(){
        List<Contacto> listaDeContactos = GestorDeContactos.getContactos();


        for (Contacto contacto: listaDeContactos){
            listView.getItems().add(contacto.getEmail());
        }
        // Manejar el doble clic en la lista
        listView.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                try {
                    onDobleClick(event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public void onVolver(ActionEvent actionEvent) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.switchToInicio(actionEvent);
    }

    // Traer el contacto seleccionado con doble Click
    public void onDobleClick(MouseEvent event) throws IOException {
        String email = listView.getSelectionModel().getSelectedItem();
        Contacto contacto = (Contacto) GestorDeContactos.buscarContacto(email);
        if (contacto != null) {
            SceneController sceneController = new SceneController();
            ActionEvent actionEvent = new ActionEvent(event.getTarget(), null);
            sceneController.switchToContactoEncontrado(actionEvent, contacto);
        }
    }
}
