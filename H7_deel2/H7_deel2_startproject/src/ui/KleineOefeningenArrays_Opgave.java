package ui;

import java.util.Arrays;
import java.util.Scanner;

public class KleineOefeningenArrays_Opgave {

    private Integer[] getallen = new Integer[10];

    public static void main(String[] args) {
        KleineOefeningenArrays_Opgave oefening = new KleineOefeningenArrays_Opgave();
    }

    public KleineOefeningenArrays_Opgave() {
        test();
    }

    public void test() {
        //Vul de array "getallen" op als volgt:
        //6 6 6 6 6 6 6 6 6 6
        //------------------------------------
        /*for (int i = 0; i < getallen.length; i++) {
            getallen[i] = 6;
        } */
        Arrays.fill(getallen, 6);

        //Vul de array "getallen" op als volgt:
        //6 6 6 6 6 4 4 8 8 8    (enkel methode fill gebruiken)
        //--------------------------------------------------------
        Arrays.fill(getallen, 0, 4, 6);
        Arrays.fill(getallen, 5, 6, 4);
        Arrays.fill(getallen, 7, 9, 8);

        //getallen weergeven op het scherm
        toonArray("oplossing : 6 6 6 6 6 4 4 8 8 8", getallen);

        Integer[] getallen2 = new Integer[14];
        //Zorg dat "getallen2" gelijk is aan "getallen" (m.a.w. getallen2[0]=getallen[0], getallen2[1]=getallen[1],...
        //en vanaf de index "getallen.length" : getallen2[10]=null, ...)
        //--------------------------------------------------------------------------------------------------------
        System.arraycopy(getallen, 0, getallen2, 0, getallen.length);

        //getallen2 weergeven op het scherm
        toonArray("oplossing : 6 6 6 6 6 4 4 8 8 8 null null null null", getallen2);

        //Zorg dat "getallen2" gelijk is aan {1 1 1 1 6 6 6 4 4 8 1 1 1 1 }
        //eerst opvullen met 1	(methode fill)
        //vervolgens methode arrayCopy gebruiken  6 6 6 4 4 8
        //---------------------------------------------------------------
        Arrays.fill(getallen2, 1);
        System.arraycopy(new Integer[]{6, 6, 6, 4, 4, 8}, 0, getallen2, 4, 6);
        //"getallen2" weergeven op het scherm
        toonArray("oplossing : 1 1 1 1 6 6 6 4 4 8 1 1 1 1", getallen2);

        //Is "getallen3" gelijk aan "getallen4"?
        //--------------------------------------------
        //uitvoer = gelijk of niet gelijk
        //TODO
        
        
        
        String namen[]
                = {
                    "Roobrouck", "Malfait", "Bernard", "Vandermeersch", "Van Schoor", "Vanenens"
                };
        //sorteer de array in alfabetische volgorde
        //-----------------------------------------
        Arrays.sort(namen);

        
        //"namen" weergeven op het scherm
        toonArray("oplossing : namen alfatisch", namen);

        //De gebruiker geeft een naam in via het toetsenbord (klasse Scanner gebruiken)
        //-----------------------------------------------------------------------------
        Scanner input = new Scanner(System.in);
        String naam = input.next();
        
        
        //Komt de ingegeven naam voor in de array "namen". Zoja, geef je de index weer waar
        //de naam staat. Zonee, geef je index weer waar de ingegeven naam zou moeten staan
        //in de array. 
        //--------------------------------------------------------------------------------
        System.out.println(Arrays.asList(namen).indexOf(naam));
        // TODO: 22/04/2020   Zonee, geef je index weer waar de ingegeven naam zou moeten staan
        
    }

    public void toonArray(String oplossing, Integer[] elementen) //Toon oplossing en daaronder alle elementen op het scherm (laat 1 spatie tussen)
    {
        System.out.printf("%s%n%12s", oplossing, " ");
        for (Integer integer: elementen){
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public void toonArray(String oplossing, String[] elementen) //Toon oplossing en daaronder alle elementen op het scherm (laat 1 spatie tussen)
    {
        System.out.printf("%s%n%12s", oplossing, " ");
        for (String string: elementen){
            System.out.print(string + " ");
        }
        System.out.println();
    }

}
