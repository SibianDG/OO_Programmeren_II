package domein;

import java.io.Serializable;

public class AccountRecord implements Serializable
{
   private int account;
   private String firstName;
   private String lastName;
   private double balance;
   
   public AccountRecord() 
   {
      this( 0, "", "", 0.0 ); 
   } 
  
 
   public AccountRecord( int account, String firstName, String lastName, double balance )
   {
       this.setAccount(account);
       this.setFirstName(firstName);
       this.setLastName(lastName);
       this.setBalance(balance);
   } 

   private void setAccount( int acct )
   {
      account = acct;
   } 

   public int getAccount() 
   { 
      return account; 
   } 
   
      
   private void setFirstName( String first )
   {
      firstName = first;
   } 

     
   public String getFirstName() 
   { 
      return firstName; 
   } 
   
    
   private void setLastName( String last )
   {
      lastName = last;
   } 

   
   public String getLastName() 
   {
      return lastName; 
   } 
   
  
   private void setBalance( double bal )
   {
      balance = bal;
   } 

     
   public double getBalance() 
   { 
      return balance; 
   } 
} 
