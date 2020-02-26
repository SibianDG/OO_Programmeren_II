package domein;

import java.util.ArrayList;
import java.util.List;

public class VeelhoekRepository {
    private List<GriekseBenaming> veelhoekenlijst ;

    public VeelhoekRepository() {
        veelhoekenlijst = new ArrayList<>();
    }

    public void voegVeelhoekToe(String[] gegevens){
        if (gegevens[0].equals("3")){
            voegDriehoekToe(gegevens);
        } else if (gegevens[0].equals("4")){
            voegRechthoekToe(gegevens);
        } else {
            veelhoekenlijst.add(new Veelhoek(Integer.parseInt(gegevens[0])));
        }
    }

    private void voegRechthoekToe(String[] gegevens){
        veelhoekenlijst.add(new Rechthoek(Integer.parseInt(gegevens[1]), Integer.parseInt(gegevens[2])));
    }

    private void voegDriehoekToe(String[] gegevens){
        veelhoekenlijst.add(new Driehoek(Integer.parseInt(gegevens[1]), Integer.parseInt(gegevens[2]), Integer.parseInt(gegevens[3])));
    }

    public List<GriekseBenaming> getVeelhoekenlijst() {
        return veelhoekenlijst;
    }
}
