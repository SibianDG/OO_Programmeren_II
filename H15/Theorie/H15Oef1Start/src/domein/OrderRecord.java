package domein;

public class OrderRecord
{

    private String naam;
    private String product;
    private int aantal;
    private double prijs;

    public OrderRecord()
    {
        this("", "", 0, 0.0);
    }

    public OrderRecord(String naam, String product, int aantal, double prijs)
    {
        this.setNaam(naam);
        this.setProduct(product);
        this.setAantal(aantal);
        this.setPrijs(prijs);
    }

    public int getAantal()
    {
        return aantal;
    }

    public final void setAantal(int aantal)
    {
        this.aantal = aantal;
    }

    public String getNaam()
    {
        return naam;
    }

    public final void setNaam(String naam)
    {
        this.naam = naam;
    }

    public double getPrijs()
    {
        return prijs;
    }

    public final void setPrijs(double prijs)
    {
        this.prijs = prijs;
    }

    public String getProduct()
    {
        return product;
    }

    public final void setProduct(String product)
    {
        this.product = product;
    }
}
