package domein;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private final long stamboeknr;
    private final String naam, voornaam;
    private String woonplaats;

    public Student(long stamboeknr, String naam, String voornaam) {
        this(stamboeknr,naam,voornaam,"Gent");
    }

    public Student(long stamboeknr, String naam, String voornaam, String woonplaats) {
        this.stamboeknr = stamboeknr;
        this.naam = naam;
        this.voornaam = voornaam;
        setWoonplaats(woonplaats);
    }

    
    public long getStamboeknr() {
        return stamboeknr;
    }

    public String getNaam() {
        return naam;
    }


    public String getVoornaam() {
        return voornaam;
    }


    public String getWoonplaats() {
        return woonplaats;
    }

    private void setWoonplaats(String woonplaats) {
        if(woonplaats == null || woonplaats.isBlank())
        	throw new IllegalArgumentException("Een woonplaats moet doorgegeven worden!");
        this.woonplaats = woonplaats;
    }

    @Override
    public String toString() {
        return String.format("Student: %d - %s %s", stamboeknr, voornaam, naam);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return stamboeknr == student.stamboeknr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stamboeknr);
    }

    @Override
    public int compareTo(Student o) {
        return Long.compare(this.stamboeknr, o.stamboeknr);
    }
}
