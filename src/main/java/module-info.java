module com.example.ej1 {
    requires javafx.controls;
    requires javafx.fxml;

    // Agrega esta línea para abrir el paquete al módulo java.xml.bind
    opens com.example.ej1.Entity to java.xml.bind;
    opens com.example.ej1 to javafx.fxml;
    exports com.example.ej1;
}