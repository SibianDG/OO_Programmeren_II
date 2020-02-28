package domein;

import java.util.List;

public class DomeinController
{
    private final KostenRepository kostenRepository;

    public DomeinController()
    {
            kostenRepository = new KostenRepository();
    }

    public String[] geefTitelsBeheersKosten(){
        List<BeheersKost> list = kostenRepository.getBeheersKostList();
        String[] titels = new String[list.size()];

        int i = 0;
        for (BeheersKost item : list){
            if (item instanceof Kluis){
                titels[i++] = item.toString();
            } else {
                titels[i++] = String.format("%s, houder is %s", item.getClass().getSimpleName(), ((Rekening)item).getHouder());
            }
        }
        return titels;
    }

    public String geefDetailBeheersKost(int index){
        return kostenRepository.geefBeheersKost(index).toString();

    }

    public double geefBeheersKostWaarde(int index){
        return kostenRepository.geefBeheersKost(index).geefJaarlijkseKost();
    }

}
