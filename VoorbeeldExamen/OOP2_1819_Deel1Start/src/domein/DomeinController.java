package domein;

import java.util.Arrays;
import java.util.List;

public class DomeinController {
    private WinkelRepository winkelRepository;

    public DomeinController() {
        winkelRepository = new WinkelRepository();
    }

    public String[] geefDouchebakkenMetLengteEnMateriaal(int lengte, int breedte, String materiaal, String naamWinkel){
        DoucheBak[] doucheBaks = ((BadkamerWinkel) winkelRepository.geefWinkel(naamWinkel)).geefDoucheBakkenMetLengteEnBreedteEnMateriaal(lengte, breedte, materiaal);
        String[] strings = new String[doucheBaks.length];

        int index = 0;
        for (DoucheBak doucheBak: doucheBaks){
            strings[index] = doucheBaks[index++].toString();
        }
        return strings;
    }

    public String[] geefNamenWinkels(){
        List<Winkel> winkels = winkelRepository.getWinkels();
        String[] strings = new String[winkels.size()];
        int index = 0;
        for (Winkel winkel: winkels){
            strings[index] = winkel.toString();
        }
        return strings;
    }

    public void serialiseerWinkels(){
        winkelRepository.serialiseerWinkels("winkels_uit.ser");
    }
}
