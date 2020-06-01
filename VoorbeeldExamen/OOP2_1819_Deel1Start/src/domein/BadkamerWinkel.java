package domein;

import exceptions.SectorMisMatchException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BadkamerWinkel extends Winkel {

    private List<DoucheBak> voorraad;

    public BadkamerWinkel(String naam, String vestigingsplaats, String sector, int omzet, Classificatie classificatie) throws SectorMisMatchException {
        this(naam, vestigingsplaats, sector, omzet, classificatie, new ArrayList<>());
    }

    public BadkamerWinkel(String naam, String vestigingsplaats, String sector, int omzet, Classificatie classificatie, List<DoucheBak> voorraad) throws SectorMisMatchException {
        super(naam, vestigingsplaats, sector, omzet, classificatie);
        setVoorraad(voorraad);
    }

    public List<DoucheBak> getVoorraad(){
        return voorraad;
    }

    private void setVoorraad(List<DoucheBak> voorraad){
        this.voorraad = voorraad;
    }

    public DoucheBak[] geefDoucheBakkenMetLengteEnBreedteEnMateriaal(int deLengte, int deBreedte, String materiaal){
        List<DoucheBak> gevonden = new ArrayList<>();
        for (DoucheBak doucheBak: voorraad){
            if (doucheBak.getLengte() >= deLengte && doucheBak.getBreedte() >= deBreedte && doucheBak.getMateriaal().equals(materiaal)) {
                gevonden.add(doucheBak);
            }
        }
        return gevonden.toArray(new DoucheBak[gevonden.size()]);
    }

    @Override
    public String toString() {
        String res = super.toString();
        int i = 0;
        for (DoucheBak doucheBak: voorraad){
            res += String.format("%nDouchebak %d: %s", (i++ +1), doucheBak);
        }
        return res;
    }

    public void voegDoucheBakAanVoorraadToe(DoucheBak doucheBak){
        voorraad.add(doucheBak);
    }

    @Override
    public double geefJaarlijkseBelasting() {
        return super.getOmzet()*2.5/100;
    }
}
