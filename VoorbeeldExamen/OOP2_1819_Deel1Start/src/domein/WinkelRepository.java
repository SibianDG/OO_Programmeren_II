package domein;

import persistentie.WinkelMapper;

import java.util.List;

public class WinkelRepository {

    private List<Winkel> winkels;
    private WinkelMapper winkelMapper;

    public WinkelRepository() {
        winkelMapper = new WinkelMapper();
        winkels = getWinkels();
    }

    public Winkel geefWinkel(String naamWinkel){
        Winkel gevondenWinkel = null;
        for (Winkel winkel: winkels){
            if (winkel.getNaam().equals(naamWinkel))
                gevondenWinkel = winkel;
        }
        return gevondenWinkel;
    }

    public List<Winkel> getWinkels(){
        return winkelMapper.geefStandaardWinkels();
    }

    public void serialiseerWinkels(String naamBestand){
        winkelMapper.serialiseerWinkels(winkels, naamBestand);
    }
}
