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
    
    //geefUnicodeTabel -> char
    public static String geefUnicodeTabel()
    {
        StringBuilder stringBuilder = new StringBuilder("Unicode Tabel:\n");
        for (int i = 0; i < 255; i++) {
            stringBuilder.append(String.format("%3d= %2c ", i, i));
            if ((i+1)%8 == 0)
                stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }
}