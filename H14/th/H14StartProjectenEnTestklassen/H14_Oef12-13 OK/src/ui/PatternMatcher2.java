package ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*bepaal hoeveel public methoden zonder argumenten (+ public defaultconstructor)
voorkomen in een java-programma*/
public class PatternMatcher2
{

    public static void main(String[] args)
    {    
            String programma = "public class Voorbeeld{"+
            "public static void main(String args[]) { test(); new Voorbeeld();}"+
            "public static void test(  ) {}"+
            "public Voorbeeld(){ we2er_geven$();}"+
            "public void we2er_geven$(){}"+
               "}";

            Pattern pattern = Pattern.compile("public [a-zA-Z \\d_$]+\\(\\s*\\)");

            Matcher matcher = pattern.matcher(programma);

            int aantal=0;
            while (matcher.find())
            {
                aantal++;
                System.out.printf("%s%n",matcher.group());
            }
            System.out.printf("%d%n",aantal);
    }


}
