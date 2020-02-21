package domein;

import java.util.ArrayList;
import java.util.List;

public class VeelhoekRepository {
    private List<GriekseBenaming> veelhoekenlijst ;

    public VeelhoekRepository() {
        veelhoekenlijst = new ArrayList<>();
    }

    public void voegVeelhoekToe(String[] gegevens){
        // todo
    }

    private void voegRechthoekToe(String[] gegevens){
// todo
    }

    private void voegDriehoekToe(String[] gegevens){
// todo
    }

    public List<GriekseBenaming> getVeelhoekenlijst() {
        return veelhoekenlijst;
    }
}
