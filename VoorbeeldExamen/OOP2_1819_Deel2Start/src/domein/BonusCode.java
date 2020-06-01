package domein;


import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BonusCode
{
    private String code;

    public BonusCode()
    {
        genereerBonusCode();
    }
    
    public BonusCode(String code)
    {
        controleerCode(code);
        this.code = code;
    }

    private void controleerCode(String code){
        Pattern p = Pattern.compile("^A\\d{5}[A-Z]{3}");
        if (!p.matcher(code).find())
            throw new IllegalArgumentException("Geen correcte BonusCode");
    }
   

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }


    public static boolean zijnOpeenvolgendeBonusCodes(BonusCode bonusCode1, BonusCode bonusCode2) {
        for (int i = 6; i < 6+3; i++) {
            if (bonusCode1.getCode().charAt(i) != bonusCode2.getCode().charAt(i))
                return false;
        }
        int som1 = Integer.parseInt(bonusCode1.getCode().substring(1, 6));
        int som2 = Integer.parseInt(bonusCode2.getCode().substring(1, 6));
        System.out.println("sommen " + som1 + " " + som2);
        return  som1 - som2 <= 150 && som1 - som2 >= -150;
    }

   private void genereerBonusCode(){
        StringBuilder stringBuilder = new StringBuilder("A");
        Random rg = new Random();
       for (int i = 0; i < 5; i++) {
           stringBuilder.append((char)rg.nextInt(10));
       }
       for (int i = 0; i < 3; i++) {
           stringBuilder.append((char)rg.nextInt(26)+65);
       }
       this.code = stringBuilder.toString();
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusCode bonusCode = (BonusCode) o;
        return Objects.equals(code, bonusCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
