package domein;

import persistentie.BerheersKostenMapper;

import java.util.List;

public class KostenRepository {

    private final List<BeheersKost> beheersKostList;
    private final BerheersKostenMapper berheersKostenMapper;

    public KostenRepository() {
        this.berheersKostenMapper = new BerheersKostenMapper();
        this.beheersKostList = berheersKostenMapper.geefBeheersKosten();
    }

    public BeheersKost geefBeheersKost(int index){
        return beheersKostList.get(index);
    }

    public List<BeheersKost> getBeheersKostList() {
        return beheersKostList;
    }
}
