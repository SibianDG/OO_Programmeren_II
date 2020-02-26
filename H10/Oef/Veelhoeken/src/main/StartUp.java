package main;

import domein.DomeinController;
import ui.ConsoleApplicatie;

public class StartUp {
    public static void main(String[] args) {
        ConsoleApplicatie consoleApplicatie = new ConsoleApplicatie(new DomeinController());
        consoleApplicatie.startApplicatie();
    }
}
