package persistentie;

import java.util.ArrayList;
import java.util.List;
import domein.*;

public class RekeningMapper
{
    public List<Rekening> geefRekeningen()
    {
        List<Rekening> rekeningen = new ArrayList<>();
        Rekening rekening1 =
                new Rekening(123456789911L, "Jan");
        Rekening rekening2 =
                new Rekening(123123456784L, "An");
        Rekening rekening3 =
                new Rekening(123123456986L, "Piet");
        rekeningen.add(rekening1);
        rekeningen.add(rekening2);
        rekeningen.add(rekening3);
        return rekeningen;
    }
}
