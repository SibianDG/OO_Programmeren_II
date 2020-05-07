package domein;

import persistentie.FestivalMapper;

import java.util.List;

public class Festival {
    private FestivalMapper festivalMapper;
    private List<Podium> podia;

    public Festival() {
        initPodia();
    }

    public Podium getPodium(int i){
        return podia.get(i);
    }

    public int geefAantalPodia(){
        return podia.size();
    }

    private void initPodia(){
        //podia = festivalMapper.maakPodia();
    }

    public void schrijfWeg(){

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
