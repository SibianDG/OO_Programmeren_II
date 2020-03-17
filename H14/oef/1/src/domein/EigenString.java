package domein;

public class EigenString {
    private String tekst;

    public EigenString(String tekst) {
        setTekst(tekst);
    }

    public String telKaraktersVolgensSoort(){
        StringBuilder stringBuilder = new StringBuilder();
        int klinker = 0, medeklinker = 0, cijfer = 0, ander = 0, kleineLetter = 0, hoofdLetter = 0;

        String[] strings = tekst.split("");
        for (String string : strings){
            if (string.matches("[a-zA-Z]")){
                if (string.toLowerCase().matches("[aeyuio]")){
                    klinker++;
                } else {
                    medeklinker++;
                }
            }
            if (string.matches("\\d")){
                cijfer++;
            }
            if (string.matches("[^0-9a-zA-Z]")){
                ander++;
            }
            if (string.matches("[a-z]")){
                kleineLetter++;
            }
            if (string.matches("[A-Z]")){
                hoofdLetter++;
            }
        }
        stringBuilder.append("In de zin \" ").append(tekst).append(" \" ").append(System.lineSeparator()).append(System.lineSeparator());
        stringBuilder.append(String.format("%20s%20s%n", "Soort karakter", "Aantal"))
                .append(String.format("%20s%20d%n", "Klinker", klinker))
                .append(String.format("%20s%20d%n", "Medeklinker", medeklinker))
                .append(String.format("%20s%20d%n", "Cijfer", cijfer))
                .append(String.format("%20s%20d%n", "Andere", ander))
                .append(String.format("%20s%20d%n", "Kleine letter", kleineLetter))
                .append(String.format("%20s%20d%n", "Hoofdletter", hoofdLetter));
        return stringBuilder.toString();
    }

    public void setTekst(String tekst) {
        if (tekst == null || tekst.isEmpty()){
            throw new IllegalArgumentException("De tekst mag niet leeg zijn. Probeer opnieuw");
        }
        this.tekst = tekst;
    }

    public String getTekst() {
        return tekst;
    }
}
