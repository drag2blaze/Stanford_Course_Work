package src;

import acm.program.ConsoleProgram;

public class RemoveCharacters extends ConsoleProgram{
   public void run(){
      removeChar();
   }

   private void removeChar(){
      String charInput = readLine("Enter a string with a 'e' or a 'S': ");
      String regx = "e,S";
      char[] characters = regx.toCharArray();
      for (char c : characters){
         charInput = charInput.replace("" +c, "#");
      }
      print(charInput);
   }

   public static void main(String[] args){
      new RemoveCharacters().start();
   }
}
