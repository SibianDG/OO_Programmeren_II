package domein;

public class DomeinController {

    private VeelhoekRepository veelhoekRepository;

    public DomeinController() {
        veelhoekRepository = new VeelhoekRepository();
    }

    public void voegVeelhoekToe(String[] gegevens){
        //todo
    }

    public String geefVeelhoeken(){
        String result = "";
        // todo
        /*
        for (Veelhoek veelhoek: veelhoekRepository.getVeelhoekenlijst()){
            result += veelhoek;
        }

         */
        return result;
    }

}
