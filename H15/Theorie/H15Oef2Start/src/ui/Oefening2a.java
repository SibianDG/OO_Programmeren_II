package ui;

import domein.DomeinController;

public class Oefening2a
{
    public Oefening2a(DomeinController dc)
    {
        
        String spelers[][]={{"50","elf","zwaard","stof"},
            {"200","trol","aks","blote handen"},
            {"120","tovenaar","vloek","onzichtbaar"}};
       
        dc.serialiseerObjectPerObject(spelers);
    }

}
