package ui;

import domein.DomeinController;
import java.util.Arrays;

public class Oefening4a
{
    public Oefening4a(DomeinController dc)
    {
        System.out.println(Arrays.toString(dc.deSerialiseerObjectPerObject("oef2a.ser")));
    }
}
