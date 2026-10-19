package com.elena.ejercicio11edad;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField txtFecha;

    @FXML
    private Label lblResultado;

    @FXML
    private void calcular() {
        try {
            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern("dd/MM/uuuu");

            LocalDate nacimiento = LocalDate.parse(
                    txtFecha.getText().trim(), formato);

            LocalDate hoy = LocalDate.now();

            if (nacimiento.isAfter(hoy)) {
                lblResultado.setText(
                        "La fecha no puede ser futura.");
                return;
            }

            Period edad = Period.between(nacimiento, hoy);

            lblResultado.setText(
                    "Tiene " + edad.getYears()
                    + " años con " + edad.getMonths()
                    + " meses.");

        } catch (DateTimeParseException e) {
            lblResultado.setText(
                    "Escribe la fecha como dd/MM/aaaa.");
        }
    }

    @FXML
    private void limpiar() {
        txtFecha.clear();
        lblResultado.setText("");
    }
}
