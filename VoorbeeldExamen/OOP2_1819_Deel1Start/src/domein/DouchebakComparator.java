package domein;

import java.util.Comparator;

public class DouchebakComparator implements Comparator<DoucheBak>
{
    @Override
    public int compare(DoucheBak o1, DoucheBak o2)
    {
        int res = o2.getLengte()-o1.getLengte();
        if (res >= 0){
            res = o2.getBreedte()-o1.getBreedte();
            if (res >= 0){
                res = o1.getMateriaal().compareTo(o2.getMateriaal());
            }
        }
        return res;
    }
}