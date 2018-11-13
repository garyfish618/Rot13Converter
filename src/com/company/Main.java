package com.company;

import javax.swing.*;
import java.lang.*;

public class Main {


    public static void main(String[] args) {

        boolean encrypt;

        Object[] options = {"Encrypt", "Decrypt"};

        int a = JOptionPane.showOptionDialog(null,
                "Would you like to encrypt or decrypt?",
                "Select a choice", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);


        if(a == 0)
        {
            encrypt = true;
        }

        else if (a == 1)
        {
            encrypt = false;
            System.out.println("x");
        }

        else
        {
            encrypt = false;
            System.exit(0);
        }

        if(encrypt) {
            String input = JOptionPane.showInputDialog("Enter text to be encrypted using ROT13");

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {

                char inputChar = input.charAt(i);

                if (Character.isAlphabetic(inputChar)) {
                    boolean upper;
                    char rotChar = ' ';

                    if (Character.isUpperCase(inputChar)) {
                        upper = true;
                    } else {
                        upper = false;
                    }


                    int asciiChar = toAscii(input.charAt(i));
                    System.out.println(asciiChar);

                    for (int h = 0; h < 13; h++) {


                        asciiChar++;
                        rotChar = (char) (asciiChar);

                        if (!(Character.isAlphabetic(rotChar))) {
                            if (upper) {
                                asciiChar = 65;
                            } else {
                                System.out.println("not");
                                asciiChar = 97;

                            }
                        }

                        System.out.println(asciiChar);

                    }

                    result.append(rotChar);
                } else {
                    result.append(inputChar);
                }


            }


            JFrame finalResult = new JFrame();

            JOptionPane.showMessageDialog(finalResult, "ROT13 Line: " + result.toString());

            System.out.println("Exit");
            System.exit(0);


        }

        else // Selected Decrypt
        {

            String input = JOptionPane.showInputDialog("Enter text to be decrypted using ROT13");

            StringBuilder result = new StringBuilder();

            for(int i = 0; i < input.length(); i++)
            {
                Character inChar = input.charAt(i);
                int intChar = toAscii(inChar);

                if(Character.isAlphabetic(inChar))
                {
                    boolean upper;

                    if(Character.isUpperCase(inChar))
                    {
                        upper = true;
                    }

                    else
                    {
                        upper = false;
                    }



                    for(int h = 0; h < 13; h++)
                    {
                        intChar--;

                        Character decChar = (char) intChar;

                        if(!(Character.isAlphabetic(decChar)))
                        {
                            if(upper)
                            {
                                decChar = 'Z';
                            }

                            else
                            {
                                decChar = 'z';

                            }
                        }

                        intChar = toAscii(decChar);


                    }

                }

                Character finalChar = (char) intChar;
                result.append(finalChar);
            }


            JFrame finalResult = new JFrame();

            JOptionPane.showMessageDialog(finalResult, "Decrypted ROT13 Line: " + result.toString());

            System.exit(0);

        }


    }



    public static int toAscii(char charToUse)
    {

            int asciiChar = (int) charToUse;
            return asciiChar;


    }



}
