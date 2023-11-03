package com.example.ej1.Controller;

import com.example.ej1.Entity.Contacto;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.example.ej1.HelloApplication.showAlert;

public class GestorDeContactos {
    private static List<Contacto> contactos = new ArrayList<>();
    private static File fileTxt = new File("contactos.txt");
    private static File fileXML = new File("contactos.xml");

    public static void addContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public static void editContacto(Contacto contactoViejo, Contacto contactoEditado) {
        contactos.remove(contactoViejo);
        contactos.add(contactoEditado);
    }

    public static void removeContacto(Contacto contacto) {
        contactos.remove(contacto);
    }

    public static List<Contacto> getContactos() {
        return contactos;
    }

    public static Object buscarContacto(String email) {
        for (Contacto contacto : contactos) {
            if (contacto.getEmail().equals(email)) {
                return contacto;
            }
        }
        return null;
    }

    public static void exportarTxt() {
        System.out.println("Exportando...");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileTxt);
            for (Contacto contacto : contactos) {
                fileWriter.write(contacto.toString());
            }
            fileWriter.close();
            showAlert("Exportado correctamente", "Se ha exportado correctamente el archivo", "success");
        } catch (Exception e) {
            showAlert("Error al exportar", "Ha ocurrido un error al exportar el archivo", "error");
        }
    }

    public static void exportarXML(){
        FileWriter fichero = null;
        PrintWriter pw = null;

        try{
            fichero = new FileWriter(fileXML);
            pw = new PrintWriter(fichero);

            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            pw.println("<contactos>");
            for (Contacto contacto : contactos) {
                pw.println("<contacto>");
                pw.println("<nombre>" + contacto.getNombre() + "</nombre>");
                pw.println("<apellidos>" + contacto.getApellido() + "</apellidos>");
                pw.println("<email>" + contacto.getEmail() + "</email>");
                pw.println("<telefono>" + contacto.getTelefono() + "</telefono>");
                pw.println("</contacto>");
            }
            pw.println("</contactos>");
        } catch (Exception e) {
            showAlert("Error al exportar", "Ha ocurrido un error al exportar el archivo", "error");
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
                showAlert("Exportado correctamente", "Se ha exportado correctamente el archivo", "success");
            } catch (Exception e2) {
                showAlert("Error al exportar", "Ha ocurrido un error al exportar el archivo", "error");
            }

        }
    }



    public static boolean checkEmail(String email){
        String regex = "^(.+)@(.+)$";
        return email.matches(regex);
    }

}
