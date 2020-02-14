package domein;

import java.time.Year;

public class Dier {

    private final int geboortejaar;

    public Dier(int geboortejaar){
        controleerGeboortejaar(geboortejaar);
        this.geboortejaar = geboortejaar;
    }

    private void controleerGeboortejaar(int geboortejaar){
        if (geboortejaar > geefHuidigeJaar()){
            throw new IllegalArgumentException("Jaar groter dan huidig");
        }
    }

    public int berekenLeeftijd(){
        return geefHuidigeJaar()-geboortejaar;
    }

    public int berekenLeeftijdVolgensMens(){
        return 0;
    }

    @Override
    public String toString(){
        return String.format("%S: leeftijd is %d en volgens de mens %d", getClass().getSimpleName(), berekenLeeftijd(), berekenLeeftijdVolgensMens());
    }

    protected int geefHuidigeJaar (){
        return Year.now().getValue();
    }

    public int getGeboortejaar() {
        return geboortejaar;
    }
}
