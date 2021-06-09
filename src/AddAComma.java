package src;

import acm.program.ConsoleProgram;

import java.text.*;
import java.util.Locale;

public class AddAComma extends ConsoleProgram {
   public void run() {
      print("Enter a number: ");
      int numberEntered;
      numberEntered = readInt();
      println("Your integer number with commas is: " +NumberFormat.getInstance(Locale.US).format(numberEntered));
   }

   public static void main(String[] args){
      new AddAComma().start();
   }
}
