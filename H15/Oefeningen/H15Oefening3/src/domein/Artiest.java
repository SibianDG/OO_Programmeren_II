package domein;

import java.io.Serializable;

public class Artiest implements Serializable {

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
        return String.format("%s %s speelt het genre %s", this.getClass().getSimpleName(), naam, genre);
    }

    public String getNaam() {
        return naam;
    }

    public MuziekGenre getGenre() {
        return genre;
    }
}
