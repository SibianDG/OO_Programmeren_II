package domein;

import java.io.Serializable;
import java.util.Arrays;

public class Speler implements Serializable
{
    private int kracht;
    private String type;
    private Wapen[] wapens;

    public Speler(int kracht, String type, Wapen[] wapens)
    {
        this.setKracht(kracht);
        this.setType(type);
        this.setWapens(wapens);
    }

    public int getKracht()
    {
        return kracht;
    }

    private void setKracht(int kracht)
    {
        this.kracht = kracht;
    }

    public String getType()
    {
        return type;
    }

    private void setType(String type)
    {
        this.type = type;
    }

    public Wapen[] getWapens()
    {
        return wapens;
    }

    private void setWapens(Wapen[] wapens)
    {
        this.wapens = wapens;
    }

    @Override
    public String toString()
    {
        return String.format("%nkracht=%d, type=%s, wapens=%s",
                                 kracht,type, Arrays.toString(wapens) );
    }
   
}
