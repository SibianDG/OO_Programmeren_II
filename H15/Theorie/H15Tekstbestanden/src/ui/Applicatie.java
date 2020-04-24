package ui;

import domein.DomeinController;

public class Applicatie
{
    private final DomeinController dc;

    public Applicatie(DomeinController dc)
    {
        this.dc = dc;
    }

    public void start() 
    {
        dc.schrijfAccountRecordWeg(123, "Peter", "Janssens", 150.00);
        dc.schrijfAccountRecordWeg(876, "Elke", "Janssens", 850.00);
        dc.schrijfAccountRecordWeg(876, "Bart", "Janssens", 450.00);
        dc.sluitAf();
        
        System.out.printf("%-10s%-12s%-12s%10s%n", "Account",
                "First Name", "Last Name", "Balance");

        System.out.println(dc.leesAccountsUitBestand());
        dc.sluitAf();
    }
}
