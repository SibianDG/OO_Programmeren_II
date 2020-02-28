package domein;

import persistentie.DierenMapper;

import java.util.ArrayList;
import java.util.List;

public class DierRepository {
    private final List<Dier> dieren;
    private final DierenMapper dierenMapper;

    public DierRepository() {
        dierenMapper = new DierenMapper();
        dieren = dierenMapper.geefDieren();
    }

    public void voegKatToe(int geboortejaar){
        dieren.add(new Kat(geboortejaar));
    }

    public void voegHondToe(String naam, int geboortejaar){
        dieren.add(new Hond(geboortejaar, naam));
    }

    public List<Dier> getDieren() {
        return dieren;
    }
}
