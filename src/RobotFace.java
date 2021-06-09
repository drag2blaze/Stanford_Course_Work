package src; /**
 * This program builds and outputs a graphical
 * display of a robot face.
 */

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.Color;
/** Creates a Robot face */
public class RobotFace extends GraphicsProgram {
   /* Defines the variables of the robot face */
   private static final int HEAD_WIDTH = 300;
   private static final int HEAD_HEIGHT = 350;
   private static final int EYE_RADIUS = 60;
   private static final int MOUTH_WIDTH = 160;
   private static final int MOUTH_HEIGHT = 40;

   public void run(){
      addFace(getWidth()/2, getHeight()/2);
   }

   /**
    * Adds the head, eyes, and mouth onto a face
    * @param width Double head width
    * @param height Double head height
    */
   private void addFace(double width, double height) {
      addHead(width, height);
      addEye(width - HEAD_WIDTH / 4, height - HEAD_HEIGHT / 4);
      addEye(width + HEAD_WIDTH / 4, height - HEAD_HEIGHT / 4);
      addMouth(width, height + HEAD_HEIGHT / 4);
   }

   /**
    *  Adds the head of the robot face
    * @param width Double head width
    * @param height Double head height
    */
   private void addHead(double width, double height){
      double x = width - HEAD_WIDTH / 2;
      double y = height - HEAD_HEIGHT / 2;
      GRect head = new GRect(x, y, HEAD_WIDTH, HEAD_HEIGHT);
      head.setFilled(true);
      head.setFillColor(Color.BLUE);
      add(head);
   }

   /**
    *  Adds an eye to the robot face
    * @param width Double head width
    * @param height Double head height
    */
   private void addEye(double width, double height) {
      double x = width - EYE_RADIUS;
      double y = height - EYE_RADIUS;
      GOval eye = new GOval(x, y, 2 * EYE_RADIUS, 2 * EYE_RADIUS);
      eye.setFilled(true);
      eye.setColor(Color.YELLOW);
      add(eye);
   }

   /**
    *  Adds a mouth to the robot face
    * @param width Double head width
    * @param height Double head height
    */
   private void addMouth(double width, double height) {
      double x = width - MOUTH_WIDTH / 2;
      double y = height - MOUTH_HEIGHT / 2;
      GRect mouth = new GRect(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
      mouth.setFilled(true);
      mouth.setColor(Color.WHITE);
      add(mouth);
   }
   /* Starts the program */
   public static void main(String[] args){
      new RobotFace().start();
   }
}
