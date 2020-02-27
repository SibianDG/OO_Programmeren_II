package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroWithExceptionHandling {
    
    public static int berekenQuotient(int teller, int noemer){
                    return teller / noemer;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean blijvenHerhalenFlag = true;
        do {
            try {
                System.out.print("Geef een integere waarde voor de teller: ");
                int teller = scanner.nextInt();
                System.out.print("Geef een integere waarde voor de noemer: ");
                int noemer = scanner.nextInt();

                int result = berekenQuotient(teller, noemer);
                System.out.printf("%nResultaat: %d / %d = %d%n", teller,
                        noemer, result);
                blijvenHerhalenFlag = false; 
            } 
            catch (InputMismatchException inputMismatchException) {
                System.err.printf("%nException: %s%n",
                        inputMismatchException);
                scanner.nextLine(); 
                System.out.printf(
                        "De invoer moeten integere getallen zijn. Probeer opnieuw.%n%n");
            } catch (ArithmeticException arithmeticException) {
                System.err.printf("%nException: %s%n", arithmeticException);
                System.out.printf(
                        "Het cijfer 0 kan geen noemer zijn. Probeer opnieuw.%n%n");
            }
            catch (Exception exception)// ALL-catcher
            {
                System.err.printf("%nException: %s%n", exception);
            }
        } while (blijvenHerhalenFlag);
    }
}
