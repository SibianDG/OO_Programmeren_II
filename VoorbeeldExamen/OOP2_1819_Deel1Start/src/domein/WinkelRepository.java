package domein;

import exceptions.SectorMisMatchException;
import persistentie.WinkelMapper;

import java.util.List;

public class WinkelRepository {

    private List<Winkel> winkels;
    private WinkelMapper winkelMapper;

    public WinkelRepository() throws SectorMisMatchException {
        winkelMapper = new WinkelMapper();
        winkels = winkelMapper.leesTekstBestandWinkels("winkels_in.txt");
    }

    public Winkel geefWinkel(String naamWinkel){
        Winkel gevondenWinkel = null;
        for (Winkel winkel: winkels){
            if (winkel.getNaam().equals(naamWinkel)) {
                gevondenWinkel = winkel;
                break;
            }
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
