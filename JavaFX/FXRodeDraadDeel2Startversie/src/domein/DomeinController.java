package domein;

import java.util.List;

public class DomeinController
{
    private final RekeningRepository rr;
    
    public DomeinController()
    {
        rr = new RekeningRepository();
    }
    
    public String[] geefAlleRekeningen() // komt op OverzichtPaneel
    {
        List<Rekening> deRekeningen = rr.getRekeningen();
        String[] alleRekeningen = new String[deRekeningen.size()];
        int index = 0;
        for (Rekening r: deRekeningen)
            alleRekeningen[index++] = r.toString();
        return alleRekeningen;
    }
    
    public String[] geefRekeningInfo(int rekeningIndex) // komt op DetailPaneel
    {
        List<Rekening> deRekeningen = rr.getRekeningen();
        Rekening eenRekening = deRekeningen.get(rekeningIndex);
        String info[] = new String[3]; // 3 gegs: reknr, saldo, houder
        info[0] = String.valueOf(eenRekening.getRekeningNr());
        info[1] = String.format("%.2f",eenRekening.getSaldo());
        info[2] = eenRekening.getHouder();
        return info;
    }
    
    public void stortOp(int index, int bedrag)
    {
        List<Rekening> deRekeningen = rr.getRekeningen();
        Rekening eenRekening = deRekeningen.get(index);
        eenRekening.stortOp(bedrag);
    }
}
