package domein;


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

    // controleerCode
   

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

   
    // zijnOpeenvolgendeBonusCodes

   // genereerBonusCode
    

}
