package domein;

public class DomeinController {

   
    private BonusCode bonusCode1, bonusCode2;


    public void registreerBonusCode(String code) {
        bonusCode1 = new BonusCode(code);
    }

    public void registreerReeksBonusCodes(String code1, String code2) {
        bonusCode1 = new BonusCode(code1);
        bonusCode2 = new BonusCode(code2);
    }

    public boolean zijnOpeenvolgendeCodes() {
        return BonusCode.zijnOpeenvolgendeBonusCodes(
                bonusCode1, bonusCode2);

    }

   

}
