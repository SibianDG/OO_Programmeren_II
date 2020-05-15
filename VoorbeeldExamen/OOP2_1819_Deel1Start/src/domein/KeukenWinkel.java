package domein;

public class KeukenWinkel extends Winkel {

    public KeukenWinkel(String naam, String vestigingsplaats, String sector, int omzet) {
        super(naam, vestigingsplaats, sector, omzet);
    }

    public KeukenWinkel(String naam, String vestigingsplaats, String sector, int omzet, Classificatie classificatie) {
        super(naam, vestigingsplaats, sector, omzet, classificatie);
    }

    @Override
    public double geefJaarlijkseBelasting() {
        return 0;
        //return super.geefJaarlijkseBelasting();
    }
}
