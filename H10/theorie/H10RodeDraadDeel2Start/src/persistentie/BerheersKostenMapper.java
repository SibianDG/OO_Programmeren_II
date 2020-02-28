package persistentie;

import domein.*;

import java.util.ArrayList;
import java.util.List;

public class BerheersKostenMapper {

    public List<BeheersKost> geefBeheersKosten() {

        List<BeheersKost> beheersKostArrayList = new ArrayList<>();

        beheersKostArrayList.add(new Kluis(100, "Tania"));


        Rekening rekening1
                = new ZichtRekening(123456700082L, "Jan", -2000);
        rekening1.stortOp(1200);
        beheersKostArrayList.add(rekening1);

        beheersKostArrayList.add(new Kluis(250, "Steve"));

        Rekening rekening2
                = new SpaarRekening(123456780009L, "Sandra");
        rekening2.stortOp(5000);
        SpaarRekening.setAangroeiIntrest(5);
        beheersKostArrayList.add(rekening2);

        return beheersKostArrayList;
    }
}
