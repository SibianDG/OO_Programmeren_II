package ui;

import domein.BadkamerWinkel;
import domein.Classificatie;
import domein.DomeinController;

import java.util.Arrays;

public class WinkelApplicatie {
    private DomeinController dc;

    public WinkelApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start(){
        new BadkamerWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);

        //System.out.println(Arrays.toString(dc.geefNamenWinkels()));
        //System.out.println(Arrays.toString(dc.geefDouchebakkenMetLengteEnMateriaal(ne)));
        //dc.serialiseerWinkels();
    }
}
