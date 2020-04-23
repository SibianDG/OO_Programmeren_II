package domein;

import java.util.Objects;

public class Container implements Comparable<Container> {

    private String eigenaar;
    private int volume;
    private int massa;
    private final int serialNumber;

    // Constructor 
    public Container(String eigenaar, int volume, int massa, int serialNumber) {
        setEigenaar(eigenaar);
        setVolume(volume);
        setMassa(massa);
        
        controleerSerialNumber(serialNumber);
        this.serialNumber = serialNumber;
    }
    
    private void setEigenaar(String eigenaar) {
        if (eigenaar == null || eigenaar.isEmpty()) {
            throw new IllegalArgumentException("Er moet een eigenaar opgegeven worden.");
        }
        this.eigenaar = eigenaar;
    }

    private void setVolume(int volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("Geen geldig volume opgegeven.");
        }
        this.volume = volume;
    }

    private void setMassa(int massa) {
        if (massa <= 0) {
            throw new IllegalArgumentException("Geen geldige massa opgegeven.");
        }
        this.massa = massa;
    }

    public String getEigenaar() {
        return eigenaar;
    }

    public int getVolume() {
        return volume;
    }

    public int getMassa() {
        return massa;
    }
    
    private int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString(){
        return String.format("%dm² - %s - %dkg", volume, eigenaar, massa);
    }
    
    private void controleerSerialNumber(int serialNumber) {
        if (serialNumber <= 0) {
            throw new IllegalArgumentException("Ongeldig serienummer!");
        }
    }

    @Override
    public int compareTo(Container o) {
        return this.serialNumber-o.getSerialNumber();
    }
}



