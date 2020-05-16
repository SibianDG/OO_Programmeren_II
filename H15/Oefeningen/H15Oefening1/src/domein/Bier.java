package domein;

import java.util.Comparator;

public class Bier
{
    private final String naam, soort, brouwerij;
    private double alcoholgehalte, beoordeling;

    public Bier(String naam, String soort, double alcoholgehalte,
                double beoordeling, String brouwerij)
    {
        controleerLeeg(naam, "Naam");
        controleerLeeg(soort, "Soort");
        controleerLeeg(brouwerij, "Brouwerij");
        this.naam = naam;
        this.soort = soort;
        this.brouwerij = brouwerij;
        setAlcoholgehalte(alcoholgehalte);
        setBeoordeling(beoordeling);
    }

    public double getAlcoholgehalte()
    {
        return alcoholgehalte;
    }

    private void setAlcoholgehalte(double alcoholgehalte)
    {
        if (alcoholgehalte >= 0 && alcoholgehalte <= 50) {
            this.alcoholgehalte = alcoholgehalte;
        } else {
            throw new IllegalArgumentException("Percentag niet binnen de grenzen");
        }
    }

    public double getBeoordeling()
    {
        return beoordeling;
    }

    private void setBeoordeling(double beoordeling)
    {
        if (beoordeling >= 0 && beoordeling <= 10){
            this.beoordeling = beoordeling;
        } else {
            throw new IllegalArgumentException("Beoordeling niet binnen de grenzen");
        }
    }

    public String getNaam() {
        return naam;
    }

    public String getSoort() {
        return soort;
    }

    public String getBrouwerij() {
        return brouwerij;
    }

    @Override
    public String toString()
    {
        return String.format("%s", this.naam.replaceAll("\\s", "_"));
    }

    private void controleerLeeg(String gegeven, String fout){
        if (gegeven == null || gegeven.isEmpty()){
            throw new IllegalArgumentException(fout + " mag niet leeg zijn.");
        }
    }
}
