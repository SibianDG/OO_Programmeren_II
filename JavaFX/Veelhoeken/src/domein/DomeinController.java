package domein;

import java.util.List;

public class DomeinController {

    private final VeelhoekRepository veelhoekRepository;

    public DomeinController() {
        veelhoekRepository = new VeelhoekRepository();
    }

    public void voegVeelhoekToe(String[] gegevens){
        veelhoekRepository.voegVeelhoekToe(gegevens);
    }

    public String geefVeelhoeken(){
        String result = "";
        List<GriekseBenaming> lijst = veelhoekRepository.getVeelhoekenlijst();
        if (lijst.isEmpty()){
            return String.format("De lijst is leeg: geen veelhoeken beschikbaar.%n");
        } else {
            for (GriekseBenaming veelhoek: lijst){
                result += String.format("%s%n", veelhoek.toString());
            }
            return result;
        }
    }

}
