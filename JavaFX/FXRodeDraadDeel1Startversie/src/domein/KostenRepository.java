package domein;

import java.util.*;
import persistentie.*;

public class KostenRepository
{
    private final List<BeheersKost> kostenLijst;
    private final BeheersKostenMapper beheerskostenMapper;

    public KostenRepository()
    {
        beheerskostenMapper = new BeheersKostenMapper();
        kostenLijst = beheerskostenMapper.geefBeheersKosten();
    }

    public BeheersKost geefBeheersKost(int index)
    {
        return kostenLijst.get(index);
    }

    public List<BeheersKost> getKostenLijst()
    {
        return this.kostenLijst;
    }
}
