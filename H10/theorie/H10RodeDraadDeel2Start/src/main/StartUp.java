package main;

import gui.BeheersKostenApplicatie;
import gui.RekeningApplicatie;
import domein.DomeinController;

public class StartUp {
    
    public static void main(String[] args) {

        BeheersKostenApplicatie beheersKostenApplicatie = new BeheersKostenApplicatie(new DomeinController());
    }
}
