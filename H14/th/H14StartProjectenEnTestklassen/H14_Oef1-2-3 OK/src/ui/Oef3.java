package ui;

import domein.MijnString;
import java.util.Scanner;

public class Oef3
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String woord;
        
        System.out.print("Geef een  woord in : ");
        woord = input.next();
        
        MijnString object = new MijnString(woord);
        
        System.out.printf("%s %s%n", woord, (object.isPalindroom() ?
                                             "is een palindroom"
                                           : "is geen palindroom")
                    );
    }
}
