package domein;

import java.util.Comparator;

public class Bier implements Comparator<Bier>
{
    private String naam, soort, brouwerij;
    private double alcoholgehalte, beoordeling;

    public Bier(String naam, String soort, double alcoholgehalte,
            double beoordeling, String brouwerij)
    {
        setNaam(naam);
        setSoort(soort);
        setBrouwerij(brouwerij);
        setAlcoholgehalte(alcoholgehalte);
        setBeoordeling(beoordeling);
    }

    public String getNaam()
    {
        return naam;
    }

    public void setNaam(String naam)
    {
        this.naam = naam;
    }

    public String getSoort()
    {
        return soort;
    }

    public void setSoort(String soort)
    {
        this.soort = soort;
    }

    public String getBrouwerij()
    {
        return brouwerij;
    }

    public void setBrouwerij(String brouwerij)
    {
        this.brouwerij = brouwerij;
    }

    public double getAlcoholgehalte()
    {
        return alcoholgehalte;
    }

    public void setAlcoholgehalte(double alcoholgehalte)
    {
        this.alcoholgehalte = alcoholgehalte;
    }

    public double getBeoordeling()
    {
        return beoordeling;
    }

    public void setBeoordeling(double beoordeling)
    {
        this.beoordeling = beoordeling;
    }

    @Override
    public String toString()
    {
        return String.format("naam = %s, soort= %s, brouwerij = %s, alcoholgehalte = %.2f, beoordeling = %.1f",
                naam, soort, brouwerij, alcoholgehalte, beoordeling);
    }

    @Override
    public int compare(Bier o1, Bier o2) {
        // TODO: 22/04/2020 ?
        return Double.compare(o1.getAlcoholgehalte(), o2.getAlcoholgehalte());
    }
}
