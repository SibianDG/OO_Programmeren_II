package domein;

public class Kluis implements BeheersKost
{
    private final int kluisnummer;
    private final String houder;
    private final static double JAARLIJKSE_KOST = 29;
    
    public Kluis(int kluisnummer, String houder)
    {
        this.kluisnummer = kluisnummer;
        this.houder = houder;
    }

    public int getKluisnummer()
    {
        return kluisnummer;
    }

    
    public String getHouder()
    {
        return houder;
    }

    @Override
    public double geefJaarlijkseKost()
    {
        return JAARLIJKSE_KOST;
    }

    @Override
    public String toString()
    {
        return String.format("kluisnr = %d, houder = %s",
                kluisnummer, houder);
    }
}