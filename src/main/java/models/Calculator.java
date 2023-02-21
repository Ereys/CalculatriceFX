package models;

import java.util.ArrayList;

/**
 * This class represent the calculator with a list of operation
 */
public class Calculator {

    private ArrayList<Calcul> historyCalcul;

    public Calculator(){
        this.historyCalcul = new ArrayList<Calcul>();
    }

    public void addCalculToHistoryList(double a, double b, String operator){
        Calcul c = new Calcul(a, b , operator);
        switch (operator){
            case "+": {
                c.add();
                break;
            }
            case "-": {
                c.sub();
                break;
            }
            case "*":{
                c.mul();
                break;
            }
            case "/": {
                c.div();
                break;
            }
        }
        this.historyCalcul.add(c);
        System.out.println(c);
    }

    public void displayCalculHistory(){
        System.out.println("___________________________");
        for (Calcul item: this.historyCalcul) {
            System.out.println(item.toString());
        }
        System.out.println("___________________________");
    }
}
