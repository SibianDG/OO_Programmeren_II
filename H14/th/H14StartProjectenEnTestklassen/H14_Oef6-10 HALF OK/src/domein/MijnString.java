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

//Oefening 6 op slide 71    
    //wartaal -> Character
    public String maakWartaal(char oud,char nieuw)
    {
        //todo -> hoe vervang je met een parameter in replaceAll
        String result = inhoud.replace(Character.toLowerCase(oud), Character.toLowerCase(nieuw));
        return result.replace(Character.toUpperCase(oud), Character.toUpperCase(nieuw));
	}

      
    
//Oefening 10 op slide 110
        /* maakWartaal -> replaceAll */
       
}