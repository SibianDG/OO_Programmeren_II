package domein;

import exceptions.BuitenBereikException;

public class Thermometer {

    private int aantalGraden; //farenheight
    private final int ONDERGRENS = 14;
    private final int BOVENGRENS = 104;
    private final int NULWAARDE = 32;

    public Thermometer() {
        this(32);
    }

    public Thermometer(int aantalGraden) {
        setAantalGraden(aantalGraden);
    }

    public int converteerNaarCelcius(){
        return (int) (5.0/9 * (aantalGraden-NULWAARDE));
    }

    public void stelAantalGradenIn(String invoer){
        int graden;
        try {
            graden = Integer.parseInt(invoer);
            setAantalGraden(graden);
        } catch (NumberFormatException ne) {
            throw new BuitenBereikException("Foutieve invoer! Temp moet numeriek zijn.");
        }

    }

    public int getAantalGraden() {
        return aantalGraden;
    }

    private void setAantalGraden(int aantalGraden) {
        if (aantalGraden > BOVENGRENS || aantalGraden < ONDERGRENS)
            throw new IllegalArgumentException("Moet in interval zijn");
        this.aantalGraden = aantalGraden;
    }
}
