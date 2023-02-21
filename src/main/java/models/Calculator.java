package models;

import java.util.ArrayList;

/**
 * This class represent the history of the calculator
 */
public class Calculator {

    private ArrayList<Calcul> historyCalcul;

    public Calculator(){
        this.historyCalcul = new ArrayList<Calcul>();
    }

    public void addCalcul(Calcul c){
        this.historyCalcul.add(c);
    }

    public ArrayList<Calcul> getHistoryCalcul() {
        return historyCalcul;
    }

    public Calcul getLastCalcul(){
        if(historyCalcul.size() > 0) {
            return this.historyCalcul.get(historyCalcul.size() - 1);
        }
        throw new IllegalArgumentException("Erreur, pas de calcul en mémoire");
    }

    public void displayCalculHistory(){
        System.out.println("___________________________");
        for (Calcul item: this.historyCalcul) {
            System.out.println(item.toString());
        }
        System.out.println("___________________________");
    }

    public void clearHistory(){
        this.historyCalcul.clear();
    }
}
