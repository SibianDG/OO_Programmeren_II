package ui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher1
{
	public static void main(String[] args)
	{      
            Scanner invoer = new Scanner(System.in);
            System.out.print("Geef een e-mail: ");
            String email = invoer.next();
            
//@ moet voorkomen
//Voor @: moet 1 of meerdere willekeurige karakters (letters, cijfers, 
//tekens) bevatten
//Na @: direct gevolgd door 1 of meerdere willekeurige karakters. 
//Vervolgens een punt. Na de punt 1 of meerdere kleine letters.
             Pattern p = Pattern.compile("[^@]+@[^.@]+\\.[a-z+]");
             //oplossing, maar waar ik aan twijfel:  Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

             Matcher m = p.matcher(email);

             boolean matchFound = m.find();

             System.out.println(matchFound);
        }
}
