module com.example.projsys100 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.projsys100 to javafx.fxml;
    exports com.example.projsys100;
}