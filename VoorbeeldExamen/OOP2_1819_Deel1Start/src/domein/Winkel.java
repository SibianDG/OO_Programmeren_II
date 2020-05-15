package domein;

import exceptions.SectorMisMatchException;

public abstract class Winkel implements TeBetalenBelasting {
    
    private String naam;
    private String vestigingsplaats;
    private String sector;
    private int omzet;
    private Classificatie classificatie;

    public Winkel(String naam, String vestigingsplaats, String sector, int omzet) {
        this(naam, vestigingsplaats, sector, omzet, Classificatie.KLEIN);
    }

    public Winkel(String naam, String vestigingsplaats, String sector, int omzet, Classificatie classificatie) {
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

    private void setSector(String sector) {
        if (sector == null || sector.isEmpty()){
            throw new SectorMisMatchException();
        } else if (!sector.matches("^[A-Z]{3}[0-9]{4}$") || !sector.matches("^[a-z]{5}[0-9]{2,}$")){
            throw new SectorMisMatchException();
        }
        this.sector = sector;
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

    @Override
    public String toString() {
        return String.format("%s %s; in %s; sector = %s, omzet = %d", getClass().getName(), naam, vestigingsplaats, sector, omzet);
    }
}
