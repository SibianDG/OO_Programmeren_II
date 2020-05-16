package domein;

import java.io.Serializable;
import java.security.SecureRandom;

public class Aannemer implements Serializable
{
    private String naamBedrijf;
    private String typeBedrijf;
    private int afstandInKm;
    private final int percentageOnderBasis;
    private static final double KMPRIJS = 0.5;
    private static double basisPrijs;
    
    public Aannemer(String naamBedrijf, String typeBedrijf, int afstandInKm)
    {
        setNaamBedrijf(naamBedrijf);
        setTypeBedrijf(typeBedrijf);
        setAfstandInKm(afstandInKm);
        SecureRandom sr = new SecureRandom();
        percentageOnderBasis = sr.nextInt(20);
    }

    private void setNaamBedrijf(String naamBedrijf)
    {
        this.naamBedrijf = naamBedrijf;
    }

    private void setTypeBedrijf(String typeBedrijf)
    {
        this.typeBedrijf = typeBedrijf;
    } 

    private void setAfstandInKm(int afstandInKm)
    {
        if (afstandInKm < 0)
            throw new IllegalArgumentException("Afstand moet positief zijn");
        this.afstandInKm = afstandInKm;
    }
    
    public final static void setBasisPrijs(double basisPrijs)
    {
        if (basisPrijs < 0)
            throw new IllegalArgumentException("Basisprijs moet positief zijn");
        Aannemer.basisPrijs = basisPrijs;
    }
    
    public double bepaalOfferte()
    {
        return basisPrijs * (1 - percentageOnderBasis / 100.0) 
               + KMPRIJS * afstandInKm;
    }

    public String getNaamBedrijf()
    {
        return naamBedrijf;
    }

    public String getTypeBedrijf()
    {
        return typeBedrijf;
    }

    public int getAfstandInKm()
    {
        return afstandInKm;
    }

	public final int getPercentageOnderBasis()
	{
		return percentageOnderBasis;
	}

	public static final double getKmprijs()
	{
		return KMPRIJS;
	}

	public static final double getBasisPrijs()
	{
		return basisPrijs;
	} 
}