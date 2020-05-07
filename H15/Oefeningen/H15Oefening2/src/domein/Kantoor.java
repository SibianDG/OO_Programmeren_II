package domein;

public class Kantoor {
    private int postcode;
    private String gemeente;
    private String adres;

    public Kantoor(int postcode, String gemeente, String adres) {
        setPostcode(postcode);
        setGemeente(gemeente);
        setAdres(adres);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s", postcode, gemeente, adres);
    }

    public int getPostcode() {
        return postcode;
    }

    private void setPostcode(int postcode) {
        if (postcode < 100 || postcode > 9999){
            throw new IllegalArgumentException("Foute postcode");
        }
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    private void setGemeente(String gemeente) {
        if (gemeente == null || gemeente.isEmpty()){
            throw new IllegalArgumentException("Gemeente mag niet leeg zijn");
        }
        this.gemeente = gemeente;
    }

    public String getAdres() {
        return adres;
    }

    private void setAdres(String adres) {
        if (adres == null || adres.isEmpty()){
            throw new IllegalArgumentException("Adres mag niet leeg zijn");
        }
        this.adres = adres;
    }
}
