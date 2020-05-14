package domein;


public class DoucheBak 
{
    private int lengte; 
    private int breedte; 
    private String materiaal;

    public DoucheBak(int lengte, int breedte, String materiaal)
    {
        setLengte(lengte);
        setBreedte(breedte);
        setMateriaal(materiaal);
    }

    public int getLengte()
    {
        return lengte;
    }

    private void setLengte(int lengte)
    {
        this.lengte = lengte;
    }

    public int getBreedte() {
        return breedte;
    }

    private void setBreedte(int breedte) {
        this.breedte = breedte;
    }

    public String getMateriaal() {
        return materiaal;
    }

    private void setMateriaal(String materiaal) {
        this.materiaal = materiaal;
    }

    @Override
    public String toString()
    {
        return String.format("lengte= %d cm, breedte= %d cm, materiaal= %s",lengte, breedte,materiaal);
    }
}
