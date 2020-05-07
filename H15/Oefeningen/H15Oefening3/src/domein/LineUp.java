package domein;

import java.util.ArrayList;
import java.util.List;

public class LineUp {
    private List<Artiest> artiesten;

    public LineUp() {
        artiesten = new ArrayList<>();
    }

    public Artiest getArtiest(int i){
        return artiesten.get(i);
    }

    public int getAantalArtisten(){
        return artiesten.size();
    }

    public void voegNieuweArtiestToe(Artiest a){
        artiesten.add(a);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Artiest artiest: artiesten){
            stringBuilder.append(artiest).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
