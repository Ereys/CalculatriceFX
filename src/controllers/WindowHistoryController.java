package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Calcul;
import models.Calculator;

import java.io.IOException;

public class WindowHistoryController{


    @FXML
    Label historyLabel;
    private Calculator history;

    public void updateWindowHistory(Calculator history) throws Exception{
        // Configuration de la nouvelle fenetre

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HistoryWindow.fxml"));
        Scene historyWindow = new Scene(loader.load());
        Stage newWindow = new Stage();
        newWindow.setScene(historyWindow);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.show();

        this.history = history;
        this.historyLabel.setText("test ");
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
