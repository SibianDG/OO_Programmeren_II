package ui;

import domein.Driehoek;
import domein.Rechthoek;
import domein.Veelhoek;

public class VeelhoekApplicatie {


    public void start() {

        System.out.printf("Aantal veelhoeken = %d%n", Veelhoek.getAantal());

        Veelhoek veelhoek = new Veelhoek(5);
        Driehoek driehoek = new Driehoek(4, 5, 6);

        Rechthoek rechthoek = new Rechthoek(5, 8);

        System.out.println(veelhoek.toString());
        System.out.println(driehoek.toString());
        System.out.println(rechthoek.toString());

        System.out.printf("Aantal veelhoeken = %d", Veelhoek.getAantal());
    }
}
