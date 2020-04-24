package main;

import domein.DomeinController;
import ui.Oefening2a;
import ui.Oefening2b;
import ui.Oefening3;
import ui.Oefening4a;
import ui.Oefening4b;
import ui.Oefening5;

public class StartUp
{
   public static void main(String args[])
   {
       DomeinController dc=new DomeinController();
       Oefening2a oef2a=new Oefening2a(dc);
  //     Oefening2b oef2b=new Oefening2b(dc);
  //     Oefening3 oef3= new Oefening3(dc);
  //     Oefening4a oef4a=new Oefening4a(dc);
  //     Oefening4b oef4b=new Oefening4b(dc);
   //     Oefening5 oef5= new Oefening5(dc);
   }
            
}
