package domein;

import java.util.Arrays;

public class MijnString
{
    String inhoud;

    public MijnString(String woord) {
        setInhoud(woord);
    }

    public Character bepaalMiddelsteKar() {
        return inhoud.charAt(inhoud.length()/2);
    }

    public Object bepaalInitialen() {
        StringBuilder initialen = new StringBuilder();
        String[] arr = inhoud.split(" ");
        boolean eerst = true;
        for (String woord: arr){
            initialen.append(woord.toUpperCase().charAt(0));
            initialen.append(".");
            if (eerst){
                initialen.append(" ");
                eerst = false;
            }
        }
        return initialen.toString();

        /* oplossing chamilo:
                String init = inhoud.toUpperCase().charAt(0) + ". ";
        int index = inhoud.indexOf(" ",1);
        while(index != -1)
        {
                init += inhoud.toUpperCase().charAt(index+1) + ".";
                index = inhoud.indexOf(" ",index+1);
        }
        return init;
         */
    }

    public boolean isPalindroom() {
        int index = 0;
        int lengteString = inhoud.length();
        while ((lengteString / 2) > index){
            if (inhoud.charAt(index) != inhoud.charAt((lengteString-1)-index)){
                return false;
            }
            index++;
        }
        return true;

        /* oplossing chamilo:
                for (int i = 0, j = inhoud.length() - 1; i < j; i++, j--) {
            if (inhoud.charAt(i) != inhoud.charAt(j)) {
                return false;
            }
        }
        return true;
         */
    }

    public void setInhoud(String inhoud) {
        if (inhoud == null || inhoud.isEmpty()){
            throw new IllegalArgumentException("Geen lege string");
        }
        this.inhoud = inhoud;
    }

    public String getInhoud() {
        return inhoud;
    }
}
