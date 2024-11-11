module com.example.progsp6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;


    opens com.example.progsp6 to javafx.fxml;
    exports com.example.progsp6;
    exports com.example.progsp6.Controller;
    opens com.example.progsp6.Controller to javafx.fxml;
    exports com.example.progsp6.Model;
    opens com.example.progsp6.Model to com.fasterxml.jackson.databind, javafx.fxml;
}