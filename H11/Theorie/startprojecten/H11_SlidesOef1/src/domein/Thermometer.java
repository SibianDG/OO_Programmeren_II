package domein;

public class Thermometer {

    private int aantalGraden; //farenheight

    public Thermometer() {
        this(32);
    }

    public Thermometer(int aantalGraden) {
        setAantalGraden(aantalGraden);
    }

    public int converteerNaarCelcius(){
        return (int) (5.0/9 * (aantalGraden-32));
    }

    public int getAantalGraden() {
        return aantalGraden;
    }

    private void setAantalGraden(int aantalGraden) {
        this.aantalGraden = aantalGraden;
    }
}
