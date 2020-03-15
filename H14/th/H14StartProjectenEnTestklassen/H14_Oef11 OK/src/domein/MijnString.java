package domein;

public class MijnString
{
    private String inhoud;

    public MijnString()
    {
    }

    public MijnString(String inhoud)
    {
        setInhoud(inhoud);
    }

    public String getInhoud()
    {
        return inhoud;
    }

    private void setInhoud(String inhoud)
    {
        if (inhoud == null || inhoud.isEmpty())
        {
            throw new IllegalArgumentException("String mag niet leeg zijn");
        }
        this.inhoud = inhoud;
    }
               
    public String[] splitsOp (String woord) 
    {
        return inhoud.split(woord);
    }
}
