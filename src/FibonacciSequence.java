package src; /**
 * This program demonstrates the Fibonacci Sequence
 * up to a maximum value.
 */

import acm.program.ConsoleProgram;

public class FibonacciSequence extends ConsoleProgram {
   public void run(){
      println("This program demonstrates the Fibonacci Sequence output in a console");
      int fib1 = 0;
      int fib2 = 1;

      /* While loop to build Fibonacci Sequence */
      while(fib1 <= Max_Num) {
         println(fib1);
         int fib3 = fib1 + fib2;
         fib1 = fib2;
         fib2 = fib3;
      }
   }
   /* Defines the maximum number in the Fibonacci Sequence */
   private static final int Max_Num = 10000;
   /* Starts the program */
   public static void main(String[] args){
      new FibonacciSequence().start();
   }
}
