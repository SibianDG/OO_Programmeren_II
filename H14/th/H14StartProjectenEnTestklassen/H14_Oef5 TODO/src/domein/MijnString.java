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
            Character[] result = new Character[GROOTTE * 2];
            int index = 0;
            for (int i = 0; i < inhoud.length(); i++) {
                for (int j = 0; j < inhoud.length(); j++) {
                    if (i != j) {
                        result[index++] = inhoud.charAt(j);
                    }
                }
            }
            String string = "";
            for (Character character : result) {
                string += String.format("%s%n", character);
            }
            return string;
        }
    }
    public String geefAllePermutatiesVanDrieMetStringBuilder()
    {
        if (inhoud.length() > GROOTTE){
            throw new IllegalArgumentException("Te lang");
        } else if (inhoud.length() < GROOTTE){
            throw new IllegalArgumentException("Te kort");
        } else {

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < GROOTTE; i++) {
                for (int j = 0; j < 2; j++) {
                    StringBuilder permutatie = new StringBuilder();
                    permutatie.append(inhoud.charAt(i));
                    for (int k = 0; k < GROOTTE; k++) {
                        if (inhoud.charAt(i) != inhoud.charAt(k)) {
                            permutatie.append(inhoud.charAt(k));
                        }
                    }
                    for (int k = GROOTTE - 1; k >= 0; k--) {
                        if (inhoud.charAt(i) != inhoud.charAt(k)) {
                            permutatie.append(inhoud.charAt(k));
                        }
                    }
                    result.append(permutatie);
                    result.append(System.getProperty(System.lineSeparator()));
                }
            }
            return result.toString();
        }
    }
}