package domein;

public class Rechthoek extends Veelhoek{
    private double lengte;
    private double breedte;

    public Rechthoek(double breedte, double lengte) {
        super(4);

        setBreedte(breedte);
        setLengte(lengte);
    }

    @Override
    public String geefGriekseBenaming() {
        return "tetragoon";
    }

    @Override
    public String toString(){
        return String.format("%s%nLengte = %.1f%nBreedte = %.1f%nOmtrek = %.1f%nOppervlakte = %.1f%n", super.toString(), lengte, breedte, berekenOmtrek(), berekenOppervlakte());
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
            throw new IllegalArgumentException("lengte fout");
        }
    }

    public final void setBreedte(double breedte) {
        if (breedte > 0 && breedte < 20) {
            this.breedte = breedte;
        } else {
            throw new IllegalArgumentException("breedte fout");
        }
    }

    public double getBreedte() {
        return breedte;
    }

    public double getLengte() {
        return lengte;
    }

}
