package domein;

import exceptions.SectorMisMatchException;

public class KeukenWinkel extends Winkel {

    public KeukenWinkel(String naam, String vestigingsplaats, String sector, int omzet) throws SectorMisMatchException {
        super(naam, vestigingsplaats, sector, omzet);
    }

    public KeukenWinkel(String naam, String vestigingsplaats, String sector, int omzet, Classificatie classificatie) throws SectorMisMatchException {
        super(naam, vestigingsplaats, sector, omzet, classificatie);
    }

    @Override
    public double geefJaarlijkseBelasting() {
        return 2500;
    }
}
