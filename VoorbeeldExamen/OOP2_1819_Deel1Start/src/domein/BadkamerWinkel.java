package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BadkamerWinkel extends Winkel {

    private List<DoucheBak> voorraad;

    public BadkamerWinkel(String naam, String vestigingsplaats, String sector, int omzet, Classificatie classificatie) {
        super(naam, vestigingsplaats, sector, omzet, classificatie);
        voorraad = new ArrayList<>();
    }

    public BadkamerWinkel(String naam, String vestigingsplaats, String sector, int omzet, Classificatie classificatie, List<DoucheBak> voorraad) {
        this(naam, vestigingsplaats, sector, omzet, classificatie);
        this.voorraad = voorraad;
    }

    public List<DoucheBak> getVoorraad(){
        return voorraad;
    }

    private void setVoorraad(List<DoucheBak> voorraad){
        this.voorraad = voorraad;
    }

    public DoucheBak[] geefDoucheBakkenMetLengteEnBreedteEnMateriaal(int deLengte, int deBreedte, String materiaal){
        return null;
    }

    @Override
    public String toString() {
        String[] strings = new String[voorraad.size()+1];
        strings[0] = super.toString();
        for (int i = 1; i <= voorraad.size(); i++) {
            strings[i] = voorraad.get(i).toString();
        }
        return Arrays.toString(strings);
    }

    public void voegDoucheBakAanVoorraadToe(DoucheBak doucheBak){
        voorraad.add(doucheBak);
    }

    @Override
    public double geefJaarlijkseBelasting() {
        return super.getOmzet()*2.5/100;
    }
}
