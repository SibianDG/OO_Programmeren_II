package domein;

import persistentie.FestivalMapper;

import java.io.Serializable;
import java.util.List;

public class Festival implements Serializable {
    private FestivalMapper festivalMapper;
    private List<Podium> podia;

    public Festival() {
        festivalMapper = new FestivalMapper();
        initPodia();
    }

    public Podium getPodium(int i){
        return podia.get(i);
    }

    public int geefAantalPodia(){
        return podia.size();
    }

    private void initPodia(){
        List<Artiest> artiesten = festivalMapper.leesArtiestenUit("artiesten.txt");
        podia = festivalMapper.maakPodia("podia.txt", artiesten);
    }

    public void schrijfWeg(){
        festivalMapper.schrijfFestivalWeg(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Festival met ").append(geefAantalPodia()).append(" podia");

        int index = 0;
        for (Podium podium: podia){
            stringBuilder.append("Podium ").append(index++);
            stringBuilder.append(podium);
        }
        return stringBuilder.toString();
    }
}
