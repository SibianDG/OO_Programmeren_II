package domein;

import java.util.List;

public class BadkamerWinkel extends Winkel {

    private List<DoucheBak> voorraad;

    public BadkamerWinkel(String naam, String vestigingsplaats, String sector, int omzet) {
        super(naam, vestigingsplaats, sector, omzet);
    }

    public BadkamerWinkel(String naam, String vestigingsplaats, String sector, int omzet, Classificatie classificatie) {
        super(naam, vestigingsplaats, sector, omzet, classificatie);
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
        return super.toString();
    }

    public void voegDoucheBakAanVoorraadToe(DoucheBak doucheBak){
        voorraad.add(doucheBak);
    }

    @Override
    public double geefJaarlijkseBelasting() {
        return 0;
        //return super.geefJaarlijkseBelasting();
    }
}
