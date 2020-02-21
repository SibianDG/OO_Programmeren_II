package domein;

public class Veelhoek implements GriekseBenaming {


    private final int aantalHoeken;
    private static int aantal;

    public Veelhoek(int aantalHoeken){
        controleerAantalHoeken(aantalHoeken);
        this.aantalHoeken = aantalHoeken;
        aantal++;
    }

    @Override
    public String geefGriekseBenaming() {
        return null;
    }

    @Override
    public String toString(){
        return String.format("%s%nAantal hoeken = %d%n", getClass().getSimpleName(), aantalHoeken);
    }

    private void controleerAantalHoeken(int aantalHoeken){
        if (aantalHoeken <= 2){
            throw new IllegalArgumentException("2 hoeken kan niet");
        }
    }

    public int getAantalHoeken() {
        return aantalHoeken;
    }

    public static int getAantal() {
        return aantal;
    }

    public static void setAantal(int aantal) {
        Veelhoek.aantal = aantal;
    }



}
