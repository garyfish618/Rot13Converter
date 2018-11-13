package com.company;

import javax.swing.*;
import java.lang.*;

public class Main {


    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog("Enter text to be encrypted using ROT13");

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < input.length(); i++)
        {

          char inputChar = input.charAt(i);

          if(Character.isAlphabetic(inputChar))
          {
              boolean upper;
              char rotChar = ' ';

              if(Character.isUpperCase(inputChar))
              {
                  upper = true;
              }

              else
              {
                  upper = false;
              }



              int asciiChar = toAscii(input.charAt(i));

              for(int h = 0; h < 13; h++)
              {



                  asciiChar++;
                  rotChar = (char) (asciiChar);

                  if(!(Character.isAlphabetic(rotChar)))
                  {
                      if(upper)
                      {
                          asciiChar = 65;
                      }

                      else
                      {
                          asciiChar = 97;
                      }
                  }

              }

              result.append(rotChar);
          }

          else
          {
              result.append(inputChar);
          }


        }


        JFrame finalResult = new JFrame();

        JOptionPane.showMessageDialog(finalResult,"ROT13 Line: " + result.toString());

        System.exit(0);





    }



    public static int toAscii(char charToUse)
    {
        int asciiChar = (int) charToUse;
        return asciiChar;
    }



}
