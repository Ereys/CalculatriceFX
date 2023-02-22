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
        this.history = Calculator.getHistoryInstance();
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
            displayResult("", this.currentCalcul.toString());
        }
    }

    /**
     * Handle the following operations : x^2, 2√x and 1/x
     *
     */
    @FXML
    public void handleOnSpecialOperationClick(MouseEvent e){
        String toConcat = ((Label) e.getSource()).getText();

        if (!this.currentCalcul.getValue1().isEmpty()) {
            this.currentCalcul.setOperation(toConcat);
            this.currentCalcul.addToSecondValue("0");
            Calcul c = this.currentCalcul.build();

            // Afficher les résultats
            displayResult(Double.toString(c.getResult()), this.currentCalcul.toStringWithSpecialOperation());
            this.history.addCalcul(c);
            this.currentCalcul = CalculBuilder.builde();
            this.currentCalcul.addToFirstValue(Double.toString(this.history.getLastCalcul().getResult()));
        }
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
        try {
            HistoryWindow window = new HistoryWindow();
            window.displayWindowHistory();
        }catch(Exception exp){
            System.out.println(exp);
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
        if(!secondValue){
            this.currentCalcul.subToFirstValue();
            this.resultLabel.setText(this.currentCalcul.getValue1()); //  Result
        }else{
            this.currentCalcul.subToSecondValue();
            this.resultLabel.setText(this.currentCalcul.getValue2()); //  Result
        }
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
                this.displayResult(Double.toString(c.getResult()), this.currentCalcul.toString());
                this.history.addCalcul(c);
                this.secondValue = true;
                this.currentCalcul = CalculBuilder.builde();
                this.currentCalcul.addToFirstValue(Double.toString(this.history.getLastCalcul().getResult()));
            }else{
                this.toStringCalcul.setText(this.currentCalcul.toString());
            }
        }catch (Exception exc){
            this.displayResult(exc.getMessage(), "");
        }
    }

    /**
     * Clear the current calcul when the user click on "C"
     *
     */
    @FXML void handleOnClearClick(MouseEvent e){
        this.currentCalcul = CalculBuilder.builde();
        this.secondValue = false;
        this.displayResult("0", "");
    }

    @FXML
    public void handleOnCloseClick(MouseEvent e){
        System.exit(0);
    }
    @FXML
    public void handleOnMinimizeClick(MouseEvent e){
        ((Stage)   root.getScene().getWindow()).setIconified(true);
    }

    /**
     * Method to display result on the calculator
     *
     */
    public void displayResult(String result, String calcul){
        this.resultLabel.setText(result);
        this.toStringCalcul.setText(calcul);
    }

}
