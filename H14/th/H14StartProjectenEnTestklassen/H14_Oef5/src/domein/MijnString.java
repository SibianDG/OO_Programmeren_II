 package domein;

public class MijnString
{
    private String inhoud;
    final int GROOTTE = 3;

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

        if (inhoud == null || inhoud.isEmpty()) {
            throw new IllegalArgumentException("String mag niet leeg zijn");
        }
        this.inhoud = inhoud;
    }
   
    public String geefAllePermutatiesVanDrieMetArray()
    {
        if (inhoud.length() > GROOTTE){
            throw new IllegalArgumentException("Te lang");
        } else if (inhoud.length() < GROOTTE){
            throw new IllegalArgumentException("Te kort");
        } else {
            String res = String.format("Permutaties van 3 letters met gebruik van arrays%n");
            char[] array = inhoud.toCharArray();

            for (int index1 = 0; index1 < GROOTTE; index1++)
            {
                int index2 = (index1+1)%GROOTTE,
                        index3 = (index1+2)%GROOTTE;

                res += String.format("%c%c%c%n",
                        array[index1], array[index2], array[index3]);
                res += String.format("%c%c%c%n",
                        array[index1], array[index3], array[index2]);
            }
            return res;
        }
    }
    public String geefAllePermutatiesVanDrieMetStringBuilder()
    {
        if (inhoud.length() > GROOTTE){
            throw new IllegalArgumentException("Te lang");
        } else if (inhoud.length() < GROOTTE){
            throw new IllegalArgumentException("Te kort");
        } else {

            StringBuilder buffer = new StringBuilder();
            buffer.append("Permutaties van 3 letters met gebruik van builder")
                    .append(System.getProperty("line.separator"));

            for (int index1 = 0; index1 < GROOTTE; index1++)
            {
                int index2 = (index1+1)%GROOTTE,
                        index3 = (index1+2)%GROOTTE;

                buffer.append(inhoud.charAt(index1))
                        .append(inhoud.charAt(index2))
                        .append(inhoud.charAt(index3))
                        .append(System.getProperty("line.separator"));
                buffer.append(inhoud.charAt(index1))
                        .append(inhoud.charAt(index3))
                        .append(inhoud.charAt(index2))
                        .append(System.getProperty("line.separator"));

            }

            return buffer.toString();
        }
    }
}