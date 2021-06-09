package src; /**
 * This program randomly generates 10 random circles,
 * of 10 random colors, in a console output.
 */

import acm.program.GraphicsProgram;
import acm.graphics.GOval;
import acm.util.RandomGenerator;

/**
 * Draws random circles with random colors
 */
public class RandomCircles extends GraphicsProgram {
   /* Defines number of circles */
   private static final int numOfCircles = 10;
   /* Defines min and max radius of circles */
   private static final double minRadius = 5;
   private static final double maxRadius = 50;

   public void run(){
      /* Runs a for loop for number of circles to generate random circles of random colors */
      for (int j = 0; j < numOfCircles; j++){
         double radius = random.nextDouble(minRadius, maxRadius);
         double width = random.nextDouble(0, getWidth() - 2 * radius);
         double height = random.nextDouble(0, getHeight() - 2 * radius);
         GOval circle = new GOval(width, height, 2 * radius, 2 * radius);
         circle.setFilled(true);
         circle.setColor(random.nextColor());
         add(circle);
      }
   }
   /* Creates an instance of a random generator */
   private RandomGenerator random = RandomGenerator.getInstance();
   /* Starts the program */
   public static void main(String[] args){
      new RandomCircles().start();
   }
}
