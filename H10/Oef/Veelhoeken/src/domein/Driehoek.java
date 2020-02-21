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
    public String geefGriekseBenaming() {
        return "trigoon";
    }

    @Override
    public String toString(){
        return String.format("%s%nZijde 1 = %d%nZijde 2 = %d%nZijde 3 = %d%nRechthoeking: %s%n", super.toString(), a, b, c, isRechthoekigeDriehoek() ? "ja" : "nee");
    }

    public boolean isRechthoekigeDriehoek() {
        return a*a + b*b == c*c || b*b + c*c == a*a || a*a + c*c == b*b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        controleerZijde(a);
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        controleerZijde(b);
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        controleerZijde(c);
        this.c = c;
    }
}
