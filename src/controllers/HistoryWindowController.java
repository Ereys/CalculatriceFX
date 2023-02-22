package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.Calcul;
import models.Calculator;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoryWindowController implements Initializable {
    @FXML
    Label historyLabel;
    private Calculator history;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.history = Calculator.getHistoryInstance();
        historyLabel.setText(historyStringBuilder());
    }

    public String historyStringBuilder(){
        if(this.history.getHistoryCalcul().isEmpty()){
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Calcul c : this.history.getHistoryCalcul()){
            s.append(c.toString());
            s.append("\n");
        }
        return s.toString();
    }
}
