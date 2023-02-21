package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Calcul;
import models.CalculBuilder;
import models.Calculator;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatriceController implements Initializable {

    private Calculator history;

    private CalculBuilder currentCalcul;

    @FXML
    Label resultLabel;
    @FXML
    Label toStringCalcul;
    @FXML
    AnchorPane root;

    private boolean secondValue = false;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.history = new Calculator();
        this.currentCalcul = CalculBuilder.builde();
        this.resultLabel.setText("0");
    }

    /**
     * Handle the input of the numbers
     *
     */
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

    /**
     * Handle the following operation : +,-,x and /
     *
     */
    @FXML
    public void handleOnOperationClick(MouseEvent e){
        if(!this.currentCalcul.getValue1().isEmpty()) {
            this.secondValue = true;
            String toConcat = ((Label) e.getSource()).getText();
            this.currentCalcul.setOperation(toConcat);

            this.toStringCalcul.setText(this.currentCalcul.toString()); // Calcul squelette
        }
    }

    /**
     * Handle the following operations : x^2, 2√x and 1/x
     *
     */
    @FXML
    public void handleOnSpecialOperationClick(MouseEvent e){
        String toConcat = ((Label) e.getSource()).getText();

        this.resultLabel.setText("Not supported yet !");
    }

    /**
     * Handle the switch between positiv and negativ number when the user click on "+/-"
     *
     */
    public void handleOnSwitchClick(MouseEvent e){
        this.resultLabel.setText("Not supported yet !");
    }


    /**
     * Display the memory when the user click on "M"
     *
     */
    @FXML
    public void handleOnShowMemoryClick(MouseEvent e){
        this.history.displayCalculHistory();
        this.secondValue = false;
        this.currentCalcul = CalculBuilder.builde();
        try {
            this.toStringCalcul.setText(this.currentCalcul.toString()); // Calcul squelette
            this.resultLabel.setText("Memoire: " + this.history.getLastCalcul().toString());
        }catch (Exception exc){
            this.resultLabel.setText(exc.getMessage());
        }
    }

    /**
     * Handle the clear of the memory when the user click on "CM"
     *
     */
    @FXML
    public void handleOnClearMemoryClick(MouseEvent e){
        this.history.clearHistory();
    }

    /**
     * Delete the last input from the current number when the user click on "return"
     *
     */
    public void handleOnReturnClick(MouseEvent e){
     /*   if(!secondValue){
            this.currentCalcul.subToFirstValue();
            this.resultLabel.setText(this.currentCalcul.getValue1()); //  Result
        }else{
            this.currentCalcul.subToSecondValue();
            this.resultLabel.setText(this.currentCalcul.getValue2()); //  Result
        }*/
        this.resultLabel.setText("Not supported yet !");
    }


    /**
     * Do the calcul, show the calcul, and add to the memory when the user click on "="
     *
     */
    @FXML
    public void handleOnEgalClick(MouseEvent e){

        try {
            if (!this.currentCalcul.getValue1().isEmpty() && !this.currentCalcul.getValue2().isEmpty()) {
                Calcul c = this.currentCalcul.build();
                this.resultLabel.setText(Double.toString(c.getResult()));
                this.history.addCalcul(c);
            }
        }catch (Exception exc){
            this.resultLabel.setText(exc.getMessage());
        }
        this.toStringCalcul.setText(this.currentCalcul.toString()); // Calcul squelette
        this.secondValue = false;
        this.currentCalcul = CalculBuilder.builde();
    }

    /**
     * Clear the current calcul when the user click on "C"
     *
     */
    @FXML void handleOnClearClick(MouseEvent e){
        this.currentCalcul = CalculBuilder.builde();
        this.secondValue = false;
        this.resultLabel.setText("0");
        this.toStringCalcul.setText("");
    }

    @FXML
    public void handleOnCloseClick(MouseEvent e){
        System.exit(0);
    }
    @FXML
    public void handleOnMinimizeClick(MouseEvent e){
        ((Stage)   root.getScene().getWindow()).setIconified(true);
    }

}
