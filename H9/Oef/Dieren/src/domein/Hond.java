package domein;

public class Hond extends Dier {

    private final String naam;

    public Hond (int geboortejaar){
        this(geboortejaar, "onbekend");
    }

    public Hond(int geboortejaar, String naam) {
        super(geboortejaar);
        controleerGeboortejaar(geboortejaar);
        controleerNaam(naam);
        this.naam = naam;
    }

    private void controleerNaam(String naam){
        if (naam == null || naam.equals("")){
            throw new IllegalArgumentException("Lege naam");
        }
    }

    private void controleerGeboortejaar(int geboortejaar){
        if (super.berekenLeeftijd() > 29){
            throw new IllegalArgumentException("Te oud");
        }
    }

    @Override
    public int berekenLeeftijdVolgensMens(){
        int leeftijd = 0;
        for (int i = 0; i < super.berekenLeeftijd(); i++) {
            if (i < 5){
                leeftijd += 10 -i;
            } else {
                leeftijd += 5;
            }
        }
        return leeftijd;
    }

    @Override
    public String toString(){
        return String.format("%s, naam is %S%n", super.toString(), naam);
    }

    public String getNaam() {
        return naam;
    }

}
