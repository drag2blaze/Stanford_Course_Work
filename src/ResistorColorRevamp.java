package src;

import acm.program.ConsoleProgram;

import java.text.NumberFormat;
import java.util.Locale;

public class ResistorColorRevamp extends ConsoleProgram {
   public void run(){
      numberOfBands();
   }

   private void numberOfBands(){

      /* Variables used in each switch case */
      int num;
      ResistorColor band1 = ResistorColor.valueOf(readLine("Enter the color of first band of the resistor: "));
      ResistorColor band2 = ResistorColor.valueOf(readLine("Enter the color of second band of the resistor: "));
      ResistorColor band3 = ResistorColor.valueOf(readLine("Enter color of the third band: "));
      ResistorColor band4 = ResistorColor.valueOf(readLine("Enter the color of the fourth band: "));
      num = (band1.getNum()*10 + band2.getNum()) * band3.getMultiplier();
      String moBands = readLine("Are there more bands? Type: y/n:  ");
      if (moBands.equals("y")){
         ResistorColor band5 = ResistorColor.valueOf(readLine("Enter the color of the fifth band:"));
         num = (band1.getNum()*100 + band2.getNum()*10 + band3.getNum()) * band4.getMultiplier();
         String moreBands = readLine("Are there more bands? Type: y/n:  ");
         if (moreBands.equals("y")){
            ResistorColor band6 = ResistorColor.valueOf(readLine("Enter the color of the sixth band:"));
            println("Your resistor is "+NumberFormat.getInstance(Locale.US).format(num)+" Ohms. With a tolerance of " +band5.getTol()+"% and a temp ppm of "+band6.getPpm());
         } else {
            println("Your resistor is "+NumberFormat.getInstance(Locale.US).format(num)+" Ohms. With a tolerance of " +band5.getTol()+"%");
         }
      } else {
         println("Your resistor is "+ NumberFormat.getInstance(Locale.US).format(num)+" Ohms. With a tolerance of "+band4.getTol()+"%");
      }
   }

   public enum ResistorColor {
      black(0, null, null),
      brown(1,1.0,100),
      red(2,2.0,50),
      orange(3,null,15),
      yellow(4,null,25),
      green(5,0.5,null),
      blue(6,0.25,null),
      violet(7,0.1,5),
      grey(8,0.05,null),
      white(9, null, null),
      gold(null,5.0,null),
      silver(null,10.0,null);

      private Integer num;
      private Double tolerance;
      private Integer ppm;

      ResistorColor(Integer num, Double tolerance, Integer ppm) {
         this.num = num;
         this.tolerance = tolerance;
         this.ppm = ppm;
      }

      public Integer getNum()
      {
         return(num);
      }

      public Double getTol()
      {
         return(tolerance);
      }

      public Integer getPpm()
      {
         return(ppm);
      }

      public Integer getMultiplier()
      {
         if(num != null)
            return((int)Math.pow(10,num));
         return(1);
      }
   }
   public static void main(String[] args){
      new ResistorColorRevamp().start();
   }

}
