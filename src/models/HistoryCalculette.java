package models;

import calcul.Calcul;

import java.util.ArrayList;

/**
 * This class represent the history of the calculator // Singleton
 */
public class HistoryCalculette {

    private ArrayList<Calcul> historyCalcul = new ArrayList<Calcul>();

    private static HistoryCalculette history = null;

    private HistoryCalculette(){}
    public static HistoryCalculette getHistoryInstance(){
        if(history == null){
            history = new HistoryCalculette();
        }
        return history;
    }
    public Calcul getLastCalcul(){
        if(historyCalcul.size() > 0) {
            return this.historyCalcul.get(historyCalcul.size() - 1);
        }
        throw new IllegalArgumentException("Erreur, pas de calcul en mémoire");
    }

    public void addCalcul(Calcul c){
        this.historyCalcul.add(c);
    }

    public ArrayList<Calcul> getHistoryCalcul() {
        return historyCalcul;
    }

    public void clearHistory(){
        this.historyCalcul.clear();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("___________________________").append("\n");
        for (Calcul item: this.historyCalcul) {
            s.append(item.toString()).append("\n");
        }
        System.out.println("___________________________\n");
        return s.toString();
    }
}
