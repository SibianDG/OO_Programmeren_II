package domein;

import java.util.Comparator;
import java.util.Objects;

public class Bier implements Comparable<Bier>
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
    public int hashCode()
    {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.naam);
        hash = 13 * hash + Objects.hashCode(this.soort);
        hash = 13 * hash + Objects.hashCode(this.brouwerij);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Bier other = (Bier) obj;
        if (!Objects.equals(this.naam, other.naam))
        {
            return false;
        }
        if (!Objects.equals(this.soort, other.soort))
        {
            return false;
        }
        if (!Objects.equals(this.brouwerij, other.brouwerij))
        {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Bier o)
    {
        return Double.compare(this.alcoholgehalte, o.alcoholgehalte);
    }
}
