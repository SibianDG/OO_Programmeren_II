package persistentie;

import domein.Dier;
import domein.Hond;
import domein.Kat;

import java.util.ArrayList;
import java.util.List;

public class DierenMapper {
    public List<Dier> geefDieren(){
        List<Dier> dier = new ArrayList<>();
        dier.add(new Kat(2000));
        dier.add(new Hond(1998, "Fluffy"));
        dier.add(new Kat(2003));
        dier.add(new Hond(2005, "Lady"));
        return dier;
    }
}