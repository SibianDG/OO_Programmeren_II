package domein;

public class Artiest {
    private final String naam;
    private MuziekGenre genre;

    public Artiest(String naam, MuziekGenre genre) {
        if (naam == null || naam.isEmpty()){
            throw new IllegalArgumentException("Naam mag niet leeg zijn");
        }
        this.naam = naam;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("Artiest %s speelt het genre %s", naam, genre);
    }

    public String getNaam() {
        return naam;
    }

    public MuziekGenre getGenre() {
        return genre;
    }
}
