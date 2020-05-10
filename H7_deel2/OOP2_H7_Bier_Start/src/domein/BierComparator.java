package domein;

import java.util.Comparator;

public class BierComparator implements Comparator<Bier>
{
    @Override
    public int compare(Bier o1, Bier o2)
    {
        int res = Double.compare(o2.getAlcoholgehalte(), o1.getAlcoholgehalte());
        if(res==0)
            res = o1.getNaam().compareTo(o2.getNaam());

        return res;

    }

}
