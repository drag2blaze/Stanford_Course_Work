package src; /**
 *   @file ResistorColorCalculator.java
 *
 *   The purpose of this program is to evaluate the resistor color bands and return
 *   a value based on the information entered. It also takes into account 4, 5, and 6 band resistors.
 *   The number of bands vary based on the information the resistor presents.
 *
 *   @author Joshua Hill
 *   @date 03-22-2019
 */

import acm.program.ConsoleProgram;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Creates ResistorColorCalculator class and extends Console program
 */
public class ResistorColorCalculator extends ConsoleProgram{

   /**
    * Console run program that runs the user interface to enter the number of bands
    * on the resistor.
    */
   public void run(){
      numberOfBands(readInt("Enter the Integer number of bands to be entered: "));
   }

   /**
    * Uses a switch case to gather user defined input based on
    * the number of bands passed into the method from the run method
    *
    * @param bands Number of bands on resistor
    */
   private void numberOfBands(int bands){

      /* Variables used in each switch case */
      int num;
      int band1;
      int band2;
      int band3;
      int band4;
      String band6;
      String tolerancePercent;

      /*
       *  Switch case, to gather different user information, based on the number of bands on the resistor.
       *  The information gathered and presented will change based on the number of bands the resistor has.
       */
      switch(bands){
         case 4:
            band1 = bandColor(readLine("Enter first band color: ")) * 10;
            band2 = bandColor(readLine("Enter second band color: "));
            band3 = multiplier(bandColor(readLine("Enter multiplier (third) band color: ")));
            tolerancePercent = tolerance(readLine("Enter the tolerance band color: "));
            num = (band1 + band2) * band3;
            println("Your resistor is "+NumberFormat.getInstance(Locale.US).format(num)+" Ohms. With a tolerance of " +tolerancePercent);
            break;
         case 5:
            band1 = bandColor(readLine("Enter first band color: ")) * 100;
            band2 = bandColor(readLine("Enter second band color: ")) * 10;
            band3 = bandColor(readLine("Enter third band color: "));
            band4 = multiplier(bandColor(readLine("Enter the multiplier (fourth) band color: ")));
            tolerancePercent = tolerance(readLine("Enter the tolerance band color: "));
            num = (band1 + band2 + band3) * band4;
            println("Your resistor is "+NumberFormat.getInstance(Locale.US).format(num)+" Ohms. With a tolerance of " +tolerancePercent);
            break;
         case 6:
            band1 = bandColor(readLine("Enter first band color: ")) * 100;
            band2 = bandColor(readLine("Enter second band color: ")) * 10;
            band3 = bandColor(readLine("Enter third band color: "));
            band4 = multiplier(bandColor(readLine("Enter multiplier (fourth) band color: ")));
            tolerancePercent = tolerance(readLine("Enter the tolerance band color: "));
            band6 = ppm(readLine("Enter the ppm (sixth) band color: "));
            num = (band1 + band2 + band3) * band4;
            println("Your resistor is "+NumberFormat.getInstance(Locale.US).format(num)+" Ohms. With a tolerance of " +tolerancePercent+" and a temp ppm of "+band6);
            break;
      }
   }

   /**
    * Uses the input from user input to determine the multiplying function.
    * returns an error if hte multiplier is not found
    *
    * @param multi Integer number to determine how the multiplier is applied
    * @return num Integer multiplier
    */
   private int multiplier(int multi){

      /* Variable to initialize return value */
      int num = 1;

      /* Switch case based on input to determine multiplier */
      switch (multi){
         case 0:
            return num;
         case 1:
            num = num * 10;
            break;
         case 2:
            num = num * 100;
            break;
         case 3:
            num = num * 1000;
            break;
         case 4:
           num =  num * 10000;
           break;
         case 5:
            num = num * 100000;
            break;
         case 6:
            num = num * 1000000;
            break;
         case 7:
            num = num * 10000000;
            break;
         case 8:
            num = num * 100000000;
            break;
         case 9:
            num = num * 1000000000;
            break;
         default:
            println("Multiplier not found!!");
      }
      return num;
   }

   /**
    * Uses input from user to determine the correlation between color and
    * band value. Returns the value that represents the color entered.
    * Returns an error if the input in not valid.
    *
    * @param color String Color of band
    * @return num Value associated with color entered
    */
   private Integer bandColor(String color){

      /* Variable to initialize return value*/
      int num = 0;

      /* Switch case based on user input give the color of a band a value */
      switch (color){
         case "black":
            num = 0;
            break;
         case "brown":
            num = 1;
            break;
         case "red":
            num = 2;
            break;
         case "orange":
            num = 3;
            break;
         case "yellow":
            num = 4;
            break;
         case "green":
            num = 5;
            break;
         case "blue":
            num = 6;
            break;
         case "violet":
            num = 7;
            break;
         case "grey":
            num = 8;
            break;
         case "white":
            num = 9;
            break;
         default:
            println("Color does not have an associating value!!!");
      }
      return num;
   }

   /**
    * Determines the amount of tolerance the resistor is allowed based off the
    * user input of the color band. Tolerance is the percentage of error in the
    * resistor's resistance, or how much more or less you can expect a resistor's
    * actual measured resistance to be from its stated resistance. Returns a string
    * percentage based on the color, and return an error if the color entered is not valid.
    *
    * @param color String color of band
    * @return percentage String associated with band color entered
    */
   private String tolerance(String color){

      /* Variable to initialize return value*/
      String percentage = null;

      /* Switch case based on user input give the color of a band a value */
      switch (color){
         case "brown":
            percentage = "+/- 1%";
            break;
         case "red":
            percentage = "+/- 2%";
            break;
         case "green":
            percentage = "+/- 0.5%";
            break;
         case "blue":
            percentage = "+/- 0.25%";
            break;
         case "violet":
            percentage = "+/- 0.10%";
            break;
         case "grey":
            percentage = "+/- 0.05%";
            break;
         case "gold":
            percentage = "+/- 5%";
            break;
         case "silver":
            percentage = "+/- 10%";
            break;
         default:
            println("No parameters given for tolerance percentage");
      }
      return percentage;
   }

   /**
    * Determines a resistor's Temperature Coefficient of Resistance (TCR)
    * tells how much its value changes as its temperature changes. It is
    * usually expressed in ppm/°C (parts per million per degree Centigrade)
    * units. Returns a value based on the color, and returns an error if the
    * color entered is not valid.
    *
    * @param color String color of band
    * @return temp String associated with band color
    */
   private String ppm(String color){

      /* Variable to initialize return value */
      String temp = null;

      /* Switch case based in user input to give the color band a value */
      switch (color){
         case "brown":
            temp = "100ppm";
            break;
         case "red":
            temp = "50ppm";
            break;
         case"orange":
            temp = "15ppm";
            break;
         case "yellow":
            temp = "25ppm";
            break;
         case"blue":
            temp = "10ppm";
            break;
         case "violet":
            temp = "5ppm";
            break;
         default:
            println("No ppm is defined");
      }
      return temp;
   }

   /* Main method to start the program */
   public static void main(String[] args){
      new ResistorColorCalculator().start();
   }
}
