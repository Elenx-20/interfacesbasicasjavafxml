module com.elena.ejercicio11edad {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.elena.ejercicio11edad to javafx.fxml;
    exports com.elena.ejercicio11edad;
}
