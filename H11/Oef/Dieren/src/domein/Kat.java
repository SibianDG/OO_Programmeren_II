package domein;

public class Kat extends Dier{


    public Kat(int geboortejaar) {
        super(geboortejaar);
    	controleerGeboortejaar(geboortejaar);
    }

    private void controleerGeboortejaar(int geboortejaar){
        if (super.berekenLeeftijd() >= 27){
            throw new IllegalArgumentException("Kat kan maximaal 27 jaar zijn!");
        }
    }

    public int berekenLeeftijdVolgensMens(){
        return super.berekenLeeftijd()*7;
    }
}
