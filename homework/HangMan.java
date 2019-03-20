/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
    /*******************
Homework #2
Due Date: 2/9/19
Names: Eric Av and Tommy Engels
A program that simulates Hangman
********************/

import java.util.*;
import javax.swing.JOptionPane;

public class HangMan
{
    /*
     Entering main driver function
     */
    public static void main(String[] args)
    {
        displayMenu();
    }
    /*
     displays the menu and allows the user to begin the Hangman!
     */
    public static void displayMenu()
    {
        char choose;
        String input;
        String userWord;
        do{
            JOptionPane.showMessageDialog(null, "Welcome to Hangman! Below are you options for ways to play this game:\n"
                                          + "Option a: Play with Random word provided by the computer\n"
                                          +"Option b: Play with a word of your choosing\n"
                                          + "Option c: Stop Playing\n");
            input= JOptionPane.showInputDialog("Please enter 'a, b, or c' (exclusively) for option a, b, or c respectively ");
            choose = input.charAt(0);
            switch(choose)
            {
                case 'a':
                {
                    userWord = getRandomWord();
                    play(userWord);
                    break;
                }
                case 'b':
                {
                    userWord = getUserWord();
                    play(userWord);
                    break;
                }
                case 'c':
                {
                    System.exit(0);
                    break;
                }
                default:
            
            }
        }while((choose != 'a') || (choose != 'b') || (choose !='c'));
    }
    /*
     provides a random word to play game with
     */
    public static String getRandomWord()
    {
        String randomWord;
        String [] randomArray = {"hello", "gonzaga", "college", "hemmingson", "spokane", "tommy", "eric", "logan", "pepsi", "guizani", "nadra", "yerion"};
        Random rand = new Random();
        int randomInt = rand.nextInt(10);
        return randomWord = randomArray[randomInt];
    }
    
    
    /*
     provides a user-entered word
     */
    public static String getUserWord()
    {

        String userWord;
        userWord = JOptionPane.showInputDialog("Enter a word (be nice) : ");
        return userWord;
    }
    
    
     /*
      displays strikes
      */
    public static void strikeDisplay(int strikes)
    {
        String man = null;
        
        String strike1 = "";
        strike1 += "   _________       \n" +
"    |/   |              \n" +
"    |   (_)\n" +
"    |                         \n" +
"    |                       \n" +
"    |                         \n" +
"    |                          \n" +
"    |___                       ";
        String strike2 = "";
        strike2 += "   ________               \n" +
"    |/   |                   \n" +
"    |   (_)                  \n" +
"    |    |                     \n" +
"    |    |                    \n" +
"    |                           \n" +
"    |                            \n" +
"    |___                    ";
        
        String strike3 = "";
        strike3 += "   _________             \n" +
"    |/   |               \n" +
"    |   (_)                   \n" +
"    |   /|                     \n" +
"    |    |                    \n" +
"    |                        \n" +
"    |                          \n" +
"    |___                          ";
        
        String strike4 = "";
        strike4 += "   _________              \n" +
"    |/   |                     \n" +
"    |   (_)                     \n" +
"    |   /|\\                    \n" +
"    |    |                       \n" +
"    |                             \n" +
"    |                            \n" +
"    |___                          ";
        
        String strike5 = "";
        strike5 += "   ________                   \n" +
"    |/   |                         \n" +
"    |   (_)                      \n" +
"    |   /|\\                             \n" +
"    |    |                          \n" +
"    |   /                            \n" +
"    |                                  \n" +
"    |___                              ";
        
        String strike6 = "";
        strike6 += "   ________\n" +
"    |/   |     \n" +
"    |   (_)    \n" +
"    |   /|\\           \n" +
"    |    |        \n" +
"    |   / \\        \n" +
"    |               \n" +
"    |___           ";
        
        switch (strikes) {
            case 1:
            JOptionPane.showMessageDialog(null, "Strikes:  '" + strikes + "'" + "\n" + strike1);
                break;
            case 2:
            JOptionPane.showMessageDialog(null, "Strikes:  '" + strikes + "'" + "\n" + strike2);
                break;
            case 3:
            JOptionPane.showMessageDialog(null, "Strikes:  '" + strikes + "'" + "\n" + strike3);
                break;
            case 4:
            JOptionPane.showMessageDialog(null, "Strikes:  '" + strikes + "'" + "\n" + strike4);
                break;
            case 5:
            JOptionPane.showMessageDialog(null, "Strikes:  '" + strikes + "'" + "\n" + strike5);
                break;
            case 6:
            JOptionPane.showMessageDialog(null, "Strikes:  '" + strikes + "'" + "\n" + strike6);
                break;
            default:
                break;
        }
        
    }
    /*
     reveals the word if the user has striked out
     */
    
    public static void wordReveal(int strikes, String answer)
    {
        if(strikes >= 6)
        {
            JOptionPane.showMessageDialog(null, "You have run out of guesses..dead:( the correct answer is " + answer);
        }
    }
    
    /*
     ensures the entry of only upper and  lowercase letters for guessing
     */
   public static boolean inputValidation(char input)
    {
        int ascii = (int) input;
        if((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122))
        {
            return true;
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Incorrect input, try again");
            return false;
        }
    }
    /*
     acquires user guess
     */
    public static char getUserGuess()
    {
        char userGuess;
        String convert;
        boolean valid;
        do
        {
            convert = JOptionPane.showInputDialog("Enter in ONE character (upper and lower case only) ");
            userGuess = convert.charAt(0); //1
            
            valid = inputValidation(userGuess);
        } while( valid == false);
        
        return userGuess;
    }
    /*
     The nitty and gritty game play action; involves the entry of guesses and maybe storing a guess if its right
     */
    public static void play(String userWord)
    {
        int strikes = 0;
        int SIZE = userWord.length();
        char [] userWordArray = userWord.toCharArray();
        //int SIZE = userWordArray.length();
        char [] userGuessArray = new char[SIZE];
        for( int i = 0; i < SIZE; i++)
        {
            userGuessArray[i] = '_';
        }
        boolean win = false;
        while(strikes < 6 && win != true)
        {
            if (strikes == 6)
            {
                wordReveal(strikes, userWord);
            }
            else
            {
            char userGuess = getUserGuess();
            boolean located = false;
            for(int i = 0; i < SIZE ; i++)
            {
                if( userGuess == userWordArray[i])
                {
                    userGuessArray[i] = userGuess;
                    located = true;
                }
                //else
                    //located = false;
            }
            if(located == false)
            {
                strikes++;
            }
            
            strikeDisplay(strikes);
                
            }
            String partialWord = new String(userGuessArray);
            JOptionPane.showMessageDialog(null, "So far, you have the following word..." + partialWord);
            
            
            win = youWon(userWordArray, userGuessArray, SIZE);
        }
        
         if (win == true)
         {
             wordReveal(strikes, userWord);
             JOptionPane.showMessageDialog(null, "You win!!" );
         }
         else
         {
             JOptionPane.showMessageDialog(null, "You lost");
             wordReveal(strikes, userWord);
         }
        
    }
    
    /*
     the youWon function compares the user's guesses with actual word to determine if the user won
     */
    public static boolean youWon(char userWordArray[], char userGuessArray[], int size)
        {
            boolean win = false;
            int counter = 0;
            for (int i = 0; i < size  ; i++)
            {
                if (userWordArray[i] == userGuessArray[i] )
                    counter++;
                else
                    win = false;
            }
            if(counter == size)
            {
                win = true;
            }
            return win;

        }
}

