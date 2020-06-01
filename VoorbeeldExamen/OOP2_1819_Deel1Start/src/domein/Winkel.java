package domein;

import exceptions.SectorMisMatchException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Winkel implements TeBetalenBelasting {
    
    private String naam;
    private String vestigingsplaats;
    private String sector;
    private int omzet;
    private Classificatie classificatie;

    public Winkel(String naam, String vestigingsplaats, String sector, int omzet) throws SectorMisMatchException {
        this(naam, vestigingsplaats, sector, omzet, Classificatie.KLEIN);
    }

    public Winkel(String naam, String vestigingsplaats, String sector, int omzet, Classificatie classificatie) throws SectorMisMatchException {
        setNaam(naam);
        setVestigingsplaats(vestigingsplaats);
        setSector(sector);
        setOmzet(omzet);
        setClassificatie(classificatie);
    }

    private void setNaam(String naam) {
        if (naam == null || naam.isEmpty())
            throw new IllegalArgumentException("Naam mag niet leeg zijn!");
        this.naam = naam;

    }

    private void setVestigingsplaats(String vestigingsplaats) {
        this.vestigingsplaats = vestigingsplaats;
    }

    private void setSector(String sector) throws SectorMisMatchException {
        Pattern p1 = Pattern.compile("^[A-Z]{3}\\d{4}$");
        Pattern p2 = Pattern.compile("^[a-z]{5}\\d{2,}$");

        if (sector == null || sector.isEmpty()){
            throw new SectorMisMatchException();
        } else if (p1.matcher(sector).find() || p2.matcher(sector).find()){
            this.sector = sector;
        } else {
            throw new SectorMisMatchException();
        }
    }

    private void setOmzet(int omzet) {
        if (omzet <= 0)
            throw new IllegalArgumentException("Omzet moet groter dan 0 zijn!");
        this.omzet = omzet;
    }

    private void setClassificatie(Classificatie classificatie) {
        if (classificatie == null){
            throw new IllegalArgumentException("Classificatie mag niet leeg zijn");
        }
        this.classificatie = classificatie;
    }

    public String getNaam() {
        return naam;
    }

    public String getVestigingsplaats() {
        return vestigingsplaats;
    }

    public String getSector() {
        return sector;
    }

    public int getOmzet() {
        return omzet;
    }

    @Override
    public String toString() {
        return String.format("%s %s; in %s; sector = %s, omzet = %d", getClass().getSimpleName(), naam, vestigingsplaats, sector, omzet);
    }
}
