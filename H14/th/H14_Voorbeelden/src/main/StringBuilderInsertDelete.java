// Fig. 14.14: StringBuilderInsertDelete.java
// StringBuilder methods insert, delete and deleteCharAt.

package main;

public class StringBuilderInsertDelete 
{
   public static void main(String[] args)
   {
      Object objectRef = "hello";  
      String string = "goodbye";  
      char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
      boolean booleanValue = true;
      char characterValue = 'K';
      int integerValue = 7;
      long longValue = 10000000;
      float floatValue = 2.5f; // f suffix indicates that 2.5 is a float
      double doubleValue = 33.333;

      StringBuilder buffer = new StringBuilder();

      buffer.insert(0, objectRef)
            .insert(0, "  ") // each of these contains new line
            .insert(0, string)
            .insert(0, "  ")
            .insert(0, charArray)
            .insert(0, "  ")
            .insert(0, charArray, 3, 3)
            .insert(0, "  ")
            .insert(0, booleanValue)
            .insert(0, "  ")
            .insert(0, characterValue)
            .insert(0, "  ")
            .insert(0, integerValue)
            .insert(0, "  ")
            .insert(0, longValue)
            .insert(0, "  ")
            .insert(0, floatValue)
            .insert(0, "  ")
            .insert(0, doubleValue);

      System.out.printf(
         "buffer after inserts:%n%s%n%n", buffer.toString());

      buffer.deleteCharAt(10); // delete 5 in 2.5
      buffer.delete(2, 6); // delete .333 in 33.333

      System.out.printf(
         "buffer after deletes:%n%s%n", buffer.toString());
   } 
} // end class StringBuilderInsertDelete
