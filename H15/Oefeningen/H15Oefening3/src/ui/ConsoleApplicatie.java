package ui;

import domein.Festival;

public class ConsoleApplicatie {
    private Festival f;

    public ConsoleApplicatie(Festival f) {
        this.f = f;
        toonEnSchrijf();
    }

    private void toonEnSchrijf(){
        System.out.println(f.toString());;
        f.schrijfWeg();
    }
}
