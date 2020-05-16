package main;

import domein.DomeinController;
import ui.WinkelApplicatie;

public class StartUp {
    public static void main(String[] args) {
        new WinkelApplicatie(new DomeinController()).start();
    }
}
