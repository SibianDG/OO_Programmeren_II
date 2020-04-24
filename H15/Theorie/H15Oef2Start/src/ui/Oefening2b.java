package ui;

import domein.DomeinController;

public class Oefening2b
{
    public Oefening2b(DomeinController dc)
    {
        
        String spelers[][]={{"50","elf","zwaard","stof"},
            {"200","trol","aks","blote handen"},
            {"120","tovenaar","vloek","onzichtbaar"}};
       
        dc.serialiseerVolledigeLijst(spelers);
    }

}