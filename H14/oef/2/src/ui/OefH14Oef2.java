package ui;

import java.util.Scanner;

public class OefH14Oef2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nieuweNaam;
        String[] namen = new String[10];
        int indexLijst = 0, indexEerst = 0, indexLaatste = 0;

        do {
            System.out.print("Geef een naam in (of stop met een lege naam): ");
            nieuweNaam = input.nextLine();
            if (!nieuweNaam.isEmpty()){
                namen[indexLijst] = nieuweNaam;
                if (vergelijkMetEerste(nieuweNaam, namen[indexEerst])){
                    indexEerst = indexLijst;
                }
                if (vergelijkMetLaatste(nieuweNaam, namen[indexLaatste])){
                    indexLaatste = indexLijst;
                }
                indexLijst++;
            }

        } while ( indexLijst < 2 || ( (!nieuweNaam.trim().isEmpty()) && indexLijst < 10 ) );
        System.out.println(bepaalUitvoer(namen, indexEerst, indexLaatste));

    }

    private static boolean vergelijkMetEerste(String string1, String string2){
            return !(string1.compareToIgnoreCase(string2) > 0);
    }

    private static boolean vergelijkMetLaatste(String string1, String string2){
        return string1.compareToIgnoreCase(string2) > 0;
    }

    private static String bepaalUitvoer(String[] stringArray, int indexEerste, int indexLaatse){
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (String naam : stringArray){
            if (naam != null){
                stringBuilder.append(naam).append("\t").append(index == indexEerste ? "EERSTE" : "").append(index == indexLaatse ? "LAATSTE" : "").append(System.lineSeparator());
                index++;
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
