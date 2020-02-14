package domein;


public class Driehoek extends Veelhoek {

    private int a, b, c;

    public Driehoek(int a, int b, int c) {
        super(3);
        setA(a);
        setB(b);
        setC(c);
    }

    private void controleerZijde(int z){
        if (z < 1){
            throw new IllegalArgumentException("Zijde moet groter dan 1 zijn");
        }
    }

    @Override
    public String toString(){
        return String.format("%s%nAantal hoeken = %d%nZijde 1 = %d%nZijde 2 = %d%n Zijde 3 = %d%nRechthoeking: %s", getClass().getSimpleName(), super.getAantalHoeken(), a, b, c, isRechthoekigeDriehoek() ? "ja" : "nee");
    }

    public boolean isRechthoekigeDriehoek() {
        return getA()==getB() && getB()==getC();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
