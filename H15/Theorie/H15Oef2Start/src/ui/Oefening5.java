package ui;

import domein.DomeinController;
import java.util.Arrays;

public class Oefening5
{
    public Oefening5(DomeinController dc)
    {
        System.out.println(Arrays.toString(dc.leesTekstBestand("oef3.txt")));
    }  
}
