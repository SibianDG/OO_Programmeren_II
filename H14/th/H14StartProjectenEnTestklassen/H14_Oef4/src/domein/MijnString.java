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

    public String keerOm()
    {
        StringBuilder result = new StringBuilder();
        String[] arr = inhoud.split("");
        int index = 0, inhoudLengte = arr.length;
        while (index < inhoudLengte){
            result.append(arr[inhoudLengte-1-index++]);
        }
        return result.toString();
        /* oplossing:
               return new StringBuilder(inhoud).reverse().toString();
         */
    }

    public boolean isPalindroom()
    {
        int index = 0;
        int lengteString = inhoud.length();
        while ((lengteString / 2) > index){
            if (inhoud.charAt(index) != inhoud.charAt((lengteString-1)-index)){
                return false;
            }
            index++;
        }
        return true;
        /* oplossing:
               return keerOm().equals(inhoud);
         */
    }
}
