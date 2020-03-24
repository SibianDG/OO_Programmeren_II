package persistentie;

import domein.*;
import java.util.ArrayList;
import java.util.List;

public class BeheersKostenMapper {

    public List<BeheersKost> geefBeheersKosten() {
        List<BeheersKost> beheerskosten = new ArrayList<>();
        beheerskosten.add(new Kluis(100, "Tania"));
        Rekening rek = new ZichtRekening(123456700082L, "Jan", -2000);
        rek.stortOp(1500);
        beheerskosten.add(rek);
        beheerskosten.add(new Kluis(250, "Steve"));
        rek = new SpaarRekening(123456780009L, "Sandra");
        rek.stortOp(1250);
        beheerskosten.add(rek);
        SpaarRekening.setAangroeiIntrest(5);
        return beheerskosten;
    }
}
