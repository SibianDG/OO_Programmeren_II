package main;

import domein.DomeinController;
import ui.ConsoleApplicatie;
import ui.DierApplicatie;

public class StartUp {
    public static void main(String[] args) {
        DomeinController domeinController = new DomeinController();
        ConsoleApplicatie consoleApplicatie = new ConsoleApplicatie(domeinController);
        consoleApplicatie.startApplicatie();
        /*
        DierApplicatie dierApplicatie = new DierApplicatie();
        dierApplicatie.start();

         */
    }
}
