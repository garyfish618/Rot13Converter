package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;


public class Main {


    public static void main(String[] args) {


        String output = null;
        String resultText;
        boolean encrypt;
        StringBuilder result = new StringBuilder();

        //Prompts user to state whether encrypting or decrypting

        Object[] options = {"Encrypt", "Decrypt"};

        int a = JOptionPane.showOptionDialog(null,
                "Would you like to encrypt or decrypt?",
                "Select a choice", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);


        if(a == 0)
        {
            encrypt = true;
            resultText = "ROT 13 Line (Copied to clipboard): ";
        }

        else if (a == 1)
        {
            encrypt = false;
            resultText = "Decrypted ROT 13 Line (Copied to clipboard): ";
        }

        else
        {
            encrypt = false;
            resultText = null;
            System.exit(0);
        }

        if(encrypt) {

            //Asks user for input text

            String input = JOptionPane.showInputDialog("Enter text to be encrypted using ROT13");

            for (int i = 0; i < input.length(); i++) {

                //Checks if character is alphabetic, if not, does not do shift

                char inputChar = input.charAt(i);

                if (Character.isAlphabetic(inputChar)) {
                    boolean upper;
                    char rotChar = ' ';


                    //If it is upper case, different ascii values must be assigned
                    if (Character.isUpperCase(inputChar)) {
                        upper = true;
                    } else {
                        upper = false;
                    }


                    int asciiChar = toAscii(inputChar);


                    for (int h = 0; h < 13; h++) {

                        asciiChar++;
                        rotChar = (char) (asciiChar);
                        //If a one character shift goes past alphabetic ascii characters, then it is reset to front of alphabet to shift from there
                        if (!(Character.isAlphabetic(rotChar))) {
                            if (upper) {
                                asciiChar = 65;
                            } else {
                                asciiChar = 97;

                            }
                            rotChar = (char) (asciiChar);
                        }
                    }



                    result.append(rotChar);
                } else {
                    result.append(inputChar);
                }


            }







        }

        else // Selected Decrypt
        {
            //Asks user to input text to decrypt
            String input = JOptionPane.showInputDialog("Enter text to be decrypted using ROT13");

            for(int i = 0; i < input.length(); i++)
            {

                Character inChar = input.charAt(i);
                int intChar = toAscii(inChar);

                //Checks if character is alphabetic, if not, does not do shift

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
                        //Shifts back a character 13 times to get original character

                        intChar--;

                        Character decChar = (char) intChar;

                        if(!(Character.isAlphabetic(decChar)))
                        {
                            //If shift goes out of bounds, reverts to end of alphabet and continues from there

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



        }



        // Copies output to clipboard
        output = result.toString();
        StringSelection selection = new StringSelection(output);
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        clip.setContents(selection, selection);


        //Shows graphical display of resulting string
        JFrame finalResult = new JFrame();
        JOptionPane.showMessageDialog(finalResult, resultText + output);


    }



    public static int toAscii(char charToUse)
    {
        //Converts a character to its ascii value

            int asciiChar = (int) charToUse;
            return asciiChar;


    }



}
