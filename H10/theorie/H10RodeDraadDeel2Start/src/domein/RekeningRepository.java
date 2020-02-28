package domein;

import java.util.List;
import persistentie.RekeningMapper;

public class RekeningRepository {
    
    private RekeningMapper rekeningMapper;
    private List<Rekening> rekeningen;

    public RekeningRepository() {
        rekeningMapper = new RekeningMapper();
        rekeningen = rekeningMapper.geefRekeningen();
    }

    public List<Rekening> getRekeningen() {
        return rekeningen;
    }   
}
