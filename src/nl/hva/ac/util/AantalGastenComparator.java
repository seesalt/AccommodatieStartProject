package nl.hva.ac.util;

import nl.hva.ac.model.Accommodatie;

import java.util.Comparator;

/**
 * Created by ralph on 12/04/2017.
 */
public class AantalGastenComparator implements Comparator<Accommodatie> {
    public int compare(Accommodatie a1, Accommodatie a2){
        return a1.getAantalGasten() - a2.getAantalGasten();
    }

}
