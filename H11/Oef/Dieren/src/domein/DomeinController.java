package domein;

import persistentie.DierenMapper;

import java.util.List;

public class DomeinController {

    private final DierRepository dierRepository;

    public DomeinController() {
        dierRepository = new DierRepository();
    }

    public void voegKatToe(int geboortejaar){
        dierRepository.voegKatToe(geboortejaar);
    }

    public void voegHondToe(String naam, int geboortejaar){
        dierRepository.voegHondToe(naam, geboortejaar);
    }

    public String maakOverzicht(){
        List<Dier> dieren = dierRepository.getDieren();
        String overzicht = "";
        for (Dier dier: dieren){
            overzicht += dier.toString() + String.format("%n");
        }
        return overzicht;
    }
}
