package ui;

import domein.DomeinController;

public class ConsoleApplicatie {

    private DomeinController domeinController;

    public ConsoleApplicatie(DomeinController domeinController) {
        this.domeinController = domeinController;
    }

    public void startApplicatie() {
        System.out.println(domeinController.geefVeelhoeken());

        String[] driehoek = {"3", "4", "5", "6"};
        String[] rechthoek = {"4", "5", "6"};

        domeinController.voegVeelhoekToe(driehoek);
        domeinController.voegVeelhoekToe(rechthoek);

        System.out.println("Na toevoeging van 2 veelhoeken:");
        System.out.println(domeinController.geefVeelhoeken());

    }
}
