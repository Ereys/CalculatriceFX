package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.Calcul;
import models.CalculBuilder;
import models.Calculator;
import utils.StringManipulation;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatriceController implements Initializable {

    private Calculator history;

    private CalculBuilder currentCalcul;

    @FXML
    Label resultLabel;
    @FXML
    Label toStringCalcul;

    private boolean secondValue = false;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.history = new Calculator();
        this.currentCalcul = CalculBuilder.builde();
        this.resultLabel.setText("0");
    }

    @FXML
    public void handleOnNumberClick(MouseEvent e){
        String toConcat = ((Label) e.getSource()).getText();
        if(!secondValue){
            this.currentCalcul.addToFirstValue(toConcat);
            this.resultLabel.setText(this.currentCalcul.getValue1()); //  Result
        }else{
            this.currentCalcul.addToSecondValue(toConcat);
            this.resultLabel.setText(this.currentCalcul.getValue2()); //  Result
        }
    }

    @FXML
    public void handleOnOperationClick(MouseEvent e){
        this.secondValue = true;
        String toConcat = ((Label) e.getSource()).getText();
        this.currentCalcul.setOperation(toConcat);

        this.toStringCalcul.setText(this.currentCalcul.toString()); // Calcul squelette
    }

    public void handleOnSwitchClick(MouseEvent e){

    }

    public void handleOnReturnClick(MouseEvent e){
        if(!secondValue){
            this.currentCalcul.subToFirstValue();
            this.resultLabel.setText(this.currentCalcul.getValue1()); //  Result
        }else{
            this.currentCalcul.subToSecondValue();
            this.resultLabel.setText(this.currentCalcul.getValue2()); //  Result
        }
    }

    @FXML
    public void handleOnEgalClick(MouseEvent e){
        Calcul c = this.currentCalcul.build();

        this.resultLabel.setText(Double.toString(c.getResult())); //  Result
        this.toStringCalcul.setText(this.currentCalcul.toString()); // Calcul squelette

        this.history.addCalcul(c);
        this.secondValue = false;
        this.currentCalcul = CalculBuilder.builde();
    }

    @FXML void handleOnClearClick(MouseEvent e){
        this.currentCalcul = CalculBuilder.builde();
        this.secondValue = false;
        this.resultLabel.setText("0");
        this.toStringCalcul.setText("");
    }

}
