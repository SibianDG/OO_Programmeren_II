package domein;

public class Kat extends Dier{


    public Kat(int geboortejaar) {
        super(geboortejaar);
    	controleerGeboortejaar(geboortejaar);
    }

    private void controleerGeboortejaar(int geboortejaar){
        if (super.berekenLeeftijd() >= 27){
            throw new IllegalArgumentException("Te oud");
        }
    }

    public int berekenLeeftijdVolgensMens(){
        return super.berekenLeeftijd()*7;
    }
}
