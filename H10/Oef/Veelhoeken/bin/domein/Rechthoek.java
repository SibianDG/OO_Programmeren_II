package domein;

public class Rechthoek extends Veelhoek{
    private double lengte;
    private double breedte;

    public Rechthoek(double lengthe, double breedte) {
        super(4);
        setBreedte(breedte);
        setLengte(lengthe);
    }

    @Override
    public String toString(){
        return String.format("%s%nAantal hoeken = %d%nLengte = %.1f%nBreedte = %.1f%nOmtrek = %.1f%nOppervlakte = %.1f%n", getClass().getSimpleName(), super.getAantalHoeken(), lengte, breedte, berekenOmtrek(), berekenOppervlakte());
    }

    public double berekenOmtrek(){
        return 2*(lengte+breedte);
    }

    public double berekenOppervlakte() {
        return lengte*breedte;
    }

    public final void setLengte(double lengte) {
        if (lengte > 0 && lengte < 20) {
            this.lengte = lengte;
        } else {
            this.lengte = 1;
        }
    }

    public final void setBreedte(double breedte) {
        if (breedte > 0 && breedte < 20) {
            this.breedte = breedte;
        } else {
            this.breedte = 1;
        }
    }

    public double getBreedte() {
        return breedte;
    }

    public double getLengte() {
        return lengte;
    }

}
