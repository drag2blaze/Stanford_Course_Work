package src; /**
 *
 * This program allows users to draw lines
 * by clicking and dragging with the mouse.
 */
import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import java.awt.event.MouseEvent;

/**
 * Draws a line based on mouse click, and drag
 */
public class DrawingLines extends GraphicsProgram {
   public void run() {
      addMouseListeners();
   }

   /**
    * Gets the mouse click
    * @param press Mouse press
    */
   public void mousePressed(MouseEvent press) {
      double x = press.getX();
      double y = press.getY();
      line = new GLine(x, y, x, y);
      add(line);
   }

   /**
    * Gets the mouse drag
    * @param drag Mouse dragged
    */
   public void mouseDragged(MouseEvent drag) {
      double x = drag.getX();
      double y = drag.getY();
      line.setEndPoint(x, y);
   }
   /* Creates line */
   private GLine line;
   /* Starts the program */
   public static void main(String[] args){
      new DrawingLines().start();
   }
} 