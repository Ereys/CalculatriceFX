package controllers;

import calcul.Calcul;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.HistoryCalculette;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HistoryWindowController implements Initializable {

    @FXML
    Label historyLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        historyLabel.textProperty().bind(
                Bindings.createStringBinding(
                        () -> HistoryCalculette.getHistoryInstance()
                                .getHistoryCalcul().stream().map(Calcul::toString)
                                .collect(Collectors.joining("\n")), HistoryCalculette.getHistoryInstance().getHistoryCalcul()));
    }
}
