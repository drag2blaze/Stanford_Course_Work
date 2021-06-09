package src; /**
 * Counts the characters, words, and lines in a file given by the user.
 */
import acm.program.ConsoleProgram;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class WordCount extends ConsoleProgram {
   public void run() {
      int lines = 0;
      int words = 0;
      int chars = 0;
      BufferedReader reader = openFileReader("File: ");
      /* Tries to read the input file and catches the error
       if not readable*/
      try {
         while (true) {
            String line = reader.readLine();
            if (line == null) break;
            lines++;
            words += countWords(line);
            chars += line.length();
         }
         reader.close();
      } catch (IOException ex) {
         println("An I/O exception has occurred");
      }
      println("Lines = " + lines);
      println("Words = " + words);
      println("Chars = " + chars);
   }

   /**
    * Asks the user for the location of an input file and returns
    * the contents to be read. If the file does
    * not exist, the user is given another chance to try.
    */
   private BufferedReader openFileReader(String file) {
      BufferedReader reader = null;
      while (reader == null) {
         String name = readLine(file);
         try {
            reader = new BufferedReader(new FileReader(name));
         } catch (IOException ex) {
            println("Can't open that file.");
         }
      }
      return reader;
   }

   /**
    * Counts the words (consecutive strings of letters and/or digits)
    * in the input line.
    */
   private int countWords(String line) {
      boolean inWord = false;
      int words = 0;
      for (int j = 0; j < line.length(); j++) {
         char characters = line.charAt(j);
         if (Character.isLetterOrDigit(characters)) {
            inWord = true;
         } else {
            if (inWord) words++;
            inWord = false;
         }
      }
      if (inWord) words++;
      return words;
   }
   /* Starts the program */
   public static void main(String[] args){
      new WordCount().start();
   }
}