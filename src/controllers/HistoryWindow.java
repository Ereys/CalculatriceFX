package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HistoryWindow {

    public void displayWindowHistory() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HistoryWindow.fxml"));
        Scene historyWindow = new Scene(loader.load());
        Stage newWindow = new Stage();
        newWindow.setScene(historyWindow);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.show();
    }

}
