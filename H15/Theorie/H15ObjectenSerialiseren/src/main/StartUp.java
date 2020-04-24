package main;

import domein.DomeinController;
import ui.Applicatie;

public class StartUp {
    public static void main(String[] args) {
        new Applicatie(new DomeinController()).start();
    }
 
}
