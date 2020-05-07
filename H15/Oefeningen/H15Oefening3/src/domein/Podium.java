package domein;

import java.util.List;

public class Podium {

    private LineUp[] lineUps;

    public Podium(int aantalDagen) {
        lineUps = new LineUp[aantalDagen];
    }

    public int geefAantalDagenInGebruik() {
        int aantalDagen = 0;
        for (LineUp lineUp: lineUps){
            if (lineUp != null)
                aantalDagen++;
        }
        return aantalDagen;
    }

    public void voegLineUpToe(LineUp lineUp){
        for (int i = 0; i < lineUps.length; i++) {
            if (lineUps[i] == null)
                lineUps[i] = lineUp;
        }
    }

    public LineUp geefLineUp(int i) {
        return lineUps[i];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (LineUp lineUp: lineUps){
            stringBuilder.append("Dag ").append(++index).append(System.lineSeparator());
            stringBuilder.append(lineUp).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
