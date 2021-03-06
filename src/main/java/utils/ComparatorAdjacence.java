package utils;

import java.util.Comparator;

import data.beans.secondaire.Adjacence;

public class ComparatorAdjacence implements Comparator<Adjacence> {

    @Override
    public int compare(Adjacence adj1, Adjacence adj2) {
        int retour = 0;
        if ((adj1 != null) && (adj2 != null)) {
            retour = adj1.getFromAdjacence().compareToIgnoreCase(adj2.getFromAdjacence());
        }
        return retour;
    }

}
