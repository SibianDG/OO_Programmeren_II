package domein;

public class SpaarRekening extends Rekening {

    private static double aangroeiIntrest;
    private final static double GRENS = 300;
    private final static int PERCENTAGE_JAARLIJKSE_AANREKENING = 5;

    public SpaarRekening(long rekeningNr, String houder) {
        super(rekeningNr, houder);
    }

    public static double getAangroeiIntrest() {
        return aangroeiIntrest;
    }

    public final static void setAangroeiIntrest(double aangroeiIntrest) {
        if (aangroeiIntrest < 0.0) 
            throw new IllegalArgumentException("Aangroeiintrest met >= 0 zijn");
        SpaarRekening.aangroeiIntrest = aangroeiIntrest;
    }

    @Override
    public String geefCode() {
        return String.format("SR-%d-%.2f", getRekeningNr(), aangroeiIntrest);
    }

    
    @Override
    public boolean haalAf(double bedrag) {
        boolean succes = false;

        if (getSaldo() >= bedrag) {
            super.haalAf(bedrag);
            succes = true;
        }
        return succes;

    }

    @Override
    public String toString() {
        return String.format("%s. %s %.2f percent.",
                super.toString(),
                "Aangroeiintrest=", getAangroeiIntrest());

    }

    @Override
    public double geefJaarlijkseKost() {
        double huidigSaldo = super.getSaldo();
        if (huidigSaldo < GRENS){
            return (GRENS - huidigSaldo)* PERCENTAGE_JAARLIJKSE_AANREKENING/100;
        }
        return 0;
    }
}
