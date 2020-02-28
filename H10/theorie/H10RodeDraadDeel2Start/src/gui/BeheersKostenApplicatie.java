package gui;

import domein.DomeinController;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BeheersKostenApplicatie {

    public BeheersKostenApplicatie(DomeinController dc) {
        String[] titels = dc.geefTitelsBeheersKosten();

        int index = 0;
        for (String titel : titels){
            System.out.println(titel);
            System.out.println("Detail: " + dc.geefDetailBeheersKost(index));
            System.out.println("Kost: " + dc.geefBeheersKostWaarde(index++));
            System.out.println();
        }
    }


}
