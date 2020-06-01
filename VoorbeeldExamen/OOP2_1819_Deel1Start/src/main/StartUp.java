package main;

import domein.DomeinController;
import exceptions.SectorMisMatchException;
import ui.WinkelApplicatie;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StartUp {
    public static void main(String[] args) throws SectorMisMatchException {
        try {
            new WinkelApplicatie(new DomeinController()).start();
        } catch (SectorMisMatchException ex){
            Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null , ex);
        }
    }
}
