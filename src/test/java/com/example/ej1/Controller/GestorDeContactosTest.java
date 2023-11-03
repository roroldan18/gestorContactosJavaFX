package com.example.ej1.Controller;

import com.example.ej1.Entity.Contacto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GestorDeContactosTest {
    private File fileTxt;
    private File fileXML;

    @BeforeEach
    void setUp() {
        fileTxt = new File("contactos.txt");
        fileXML = new File("contactos.xml");
        Contacto contacto1 = new Contacto("Nombre1", "Apellido1", 123456, "email1@example.com");
        Contacto contacto2 = new Contacto("Nombre2", "Apellido2", 789012, "email2@example.com");
        GestorDeContactos.addContacto(contacto1);
        GestorDeContactos.addContacto(contacto2);
    }

    @Test
    void addContacto() {
        Contacto nuevoContacto = new Contacto("NuevoNombre", "NuevoApellido", 987654, "nuevo@example.com");
        GestorDeContactos.addContacto(nuevoContacto);
        assertTrue(GestorDeContactos.getContactos().contains(nuevoContacto));
    }

    @Test
    void editContacto() {
        Contacto contactoViejo = new Contacto("Nombre1", "Apellido1", 123456, "email1@example.com");
        Contacto contactoEditado = new Contacto("Nombre1", "Apellido1", 1111111, "newemail@example.com");
        GestorDeContactos.editContacto(contactoViejo, contactoEditado);
        assertTrue(GestorDeContactos.getContactos().contains(contactoEditado));
        assertFalse(GestorDeContactos.getContactos().contains(contactoViejo));
    }

    @Test
    void removeContacto() {
        Contacto contacto = new Contacto("Nombre1", "Apellido1", 123456, "email1@example.com");
        GestorDeContactos.removeContacto(contacto);
        assertFalse(GestorDeContactos.getContactos().contains(contacto));
    }

    @Test
    void getContactos() {
    }

    @Test
    void buscarContacto() {
        Contacto encontrado = (Contacto) GestorDeContactos.buscarContacto("email1@example.com");
        assertNotNull(encontrado);
        assertEquals("Nombre1", encontrado.getNombre());
    }

    @Test
    void exportarTxt() {
        // Ejecutar el método de exportación
        GestorDeContactos.exportarTxt();

        // Verificar si el archivo TXT existe
        assertTrue(fileTxt.exists());

        // Puedes agregar más aserciones aquí para verificar el contenido del archivo, si es necesario.
    }

    @Test
    void exportarXML() {
        // Ejecutar el método de exportación
        GestorDeContactos.exportarXML();

        // Verificar si el archivo XML existe
        assertTrue(fileXML.exists());

        // Puedes agregar más aserciones aquí para verificar el contenido del archivo XML, si es necesario.
    }

    @Test
    void checkEmail() {
        assertTrue(GestorDeContactos.checkEmail("email1@example.com"));
        assertFalse(GestorDeContactos.checkEmail("invalid_email"));
    }
}