package domein;

public class Login {
    private String gebruikersnaam;
    private String wachtwoord;

    public Login() {

    }

    public Login(String gebruikersnaam, String wachtwoord) {
        setGebruikersnaam(gebruikersnaam);
        setWachtwoord(wachtwoord);
    }

    private boolean controleerLengte(String s, int I){
        if (s == null){
            throw new IllegalArgumentException("Het mag niet leeg zijn");
        }
        return s.length() >= I;
    }

    @Override
    public String toString(){
        return "";
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        if (gebruikersnaam == null){
            throw new IllegalArgumentException("Gelieve een gebruikersnaam in te voeren!");
        }
        if (controleerLengte(gebruikersnaam, 12) && gebruikersnaam.matches("[A-Z][^ ]{3,} [^ ]{7,}\\d]")){
            this.gebruikersnaam = gebruikersnaam;
        } else {
            throw new IllegalArgumentException("Foute gebruikersnaam");
        }
    }

    public void setWachtwoord(String wachtwoord) {
        if (wachtwoord == null){
            throw new IllegalArgumentException("Gelieve een wachtwoord in te voeren!");
        }
        if (controleerLengte(wachtwoord, 6) && wachtwoord.matches("([a-z]*\\d{2,}[a-z]*)")) {
            this.wachtwoord = wachtwoord;
        }else {
            throw new IllegalArgumentException("Het wachtwoord moet minstens 2 cijfers bevatten en kleine kars.");
        }
        //feedback: stap per stap een melding geven.
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }
}
