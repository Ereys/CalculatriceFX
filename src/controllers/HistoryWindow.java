package controllers;

import calcul.Calcul;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.HistoryCalculette;
import java.util.stream.Collectors;


public class HistoryWindow {

    private static HistoryWindow window = null;

    private HistoryWindow(){
    };

    public static HistoryWindow getInstanceHistoryWindow(){
        if(window == null) window = new HistoryWindow();
        return window;
    }

    public void displayWindowHistory() throws Exception{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HistoryWindow.fxml"));
            Scene historyWindow = new Scene(loader.load());
            Stage newWindow = new Stage();
            newWindow.setScene(historyWindow);
            newWindow.initModality(Modality.WINDOW_MODAL);
            newWindow.show();
    }
}
