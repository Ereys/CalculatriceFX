package models;

import java.util.ArrayList;

/**
 * This class represent the history of the calculator // Singleton
 */
public class Calculator {

    private ArrayList<Calcul> historyCalcul = new ArrayList<Calcul>();

    private static Calculator history = null;

    private Calculator(){
    }

    public static Calculator getHistoryInstance(){
        if(history == null){
            history = new Calculator();
        }
        return history;
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
