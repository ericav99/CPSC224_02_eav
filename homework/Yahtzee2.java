/*******************
Homework #1
Due Date: 1/29/19
Names: Eric Av and Tommy Engels
A program that simulates Yahtzee
********************/

import java.util.*;

public class Yahtzee2 {

    public static void main(String[] args) {
        
        final int DICE_IN_PLAY = 5;
        int hand[] = new int[DICE_IN_PLAY];
        char playAgain = 'y';
        Scanner scan = new Scanner(System.in);
        while (playAgain == 'y') {
            String keep = "nnnnn"; //setup to roll all dice in the first roll
            int turn = 1;
            while (turn < 4 && keep != "yyyyy") {
                // roll dice not kept
                for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++) {
                    if (keep.charAt(dieNumber) != 'y')
                        hand[dieNumber] = rollDie();
                }
                // output roll
                System.out.print("\"Your roll was: ");
                for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++) {
                    System.out.print(hand[dieNumber] + " ");
                }
                System.out.println();
                //if not the last roll of the hand prompt the user for dice to keep
                if (turn < 3) {
                    System.out.print("enter dice to keep (y or n) ");
                    keep = scan.next();
                }
                turn++;
            }
            //start scoring
            //hand need to be sorted to check for straights
            sortArray(hand, DICE_IN_PLAY);
            System.out.print("Here is your sorted hand : ");
            for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++) {
                System.out.print(hand[dieNumber] + " ");
            }
            System.out.println();
            //upper scorecard
            for (int dieValue = 1; dieValue <= 6; dieValue++) {
                int currentCount = 0;
                for (int diePosition = 0; diePosition < 5; diePosition++) {
                    if (hand[diePosition] == dieValue)
                        currentCount++;
                }
                System.out.print("Score " + dieValue * currentCount + " on the ");
                System.out.println(dieValue + " line");
            }
            //lower scorecard
            if (maxOfAKindFound(hand) >= 3) {
                System.out.print("Score " + totalAllDice(hand));
                System.out.println("3 of a Kind line");
            }
            else System.out.println("Score 0 on the 3 of a Kind line");
            if (maxOfAKindFound(hand) >= 4) {
                System.out.print("Score " + totalAllDice(hand) + " on the ");
                System.out.println("4 of a Kind line");
            }
            else System.out.println("Score 0 on the 4 of a Kind line");
            
            if (fullHouseFound(hand))
                System.out.println("Score 25 on the Full House line");
            else
                System.out.println("Score 0 on the Full House line");
            if (maxStraightFound(hand) >= 4)
                System.out.println("Score 30 on the Small Straight line");
            else
                System.out.println("Score 0 on the Small Straight line");

            if (maxStraightFound(hand) >= 5)
                System.out.println("Score 40 on the Large Straight line");
            else
                System.out.println("Score 0 on the Large Straight line");
            
            if (maxOfAKindFound(hand) >= 5)
                System.out.println("Score 50 on the Yahtzee line" );
            else
                System.out.println("Score 0 on the Yahtzee line");
            
            System.out.print("Score " + totalAllDice(hand) + " on the ");
            System.out.println("Chance line");
            System.out.print("\nEnter 'y' to play again ");
            playAgain = scan.next().charAt(0); 
        }
    }
    
    //this function simulates the rolling of a single die
    public static int rollDie() {
        Random rand = new Random();
        int roll = rand.nextInt(6) + 1;
        return roll;
    }
    
    //this function returns the count of the die value occurring most in the hand
    //but not the value itself  
    public static int maxOfAKindFound(int hand[]) {
        int maxCount = 0;
        int currentCount;
        for (int dieValue = 1; dieValue <= 6; dieValue++) {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++) {
                if (hand[diePosition] == dieValue)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }
    
    //this function returns the total value of all dice in a hand
    public static int totalAllDice(int hand[]) {
        int total = 0;
        for (int diePosition = 0; diePosition < 5; diePosition++)
        {
            total += hand[diePosition];
        }
        return total;
    }
    
    //bubble sort from  Gaddis chapter 8
    public static void sortArray(int array[], int size) {
        boolean swap;
        int temp;
        do {
           swap = false;
           for (int count = 0; count < (size - 1); count++) {
              if (array[count] > array[count + 1]) {
                 temp = array[count];
                 array[count] = array[count + 1];
                 array[count + 1] = temp;
                 swap = true;
              }
           }
        } while (swap);
    }
    
    //this function returns the length of the longest
    //straight found in a hand
    public static int maxStraightFound(int hand[]) {
        int maxLength = 1;
        int curLength = 1;
        for(int counter = 0; counter < 4; counter++) {
            if (hand[counter] + 1 == hand[counter + 1] ) //jump of 1
                curLength++;
            else if (hand[counter] + 1 < hand[counter + 1]) //jump of >= 2
                curLength = 1;
            if (curLength > maxLength)
                maxLength = curLength;
        }
        return maxLength;
    }
    
    //this function returns true if the hand is a full house
    //or false if it does not
    public static boolean fullHouseFound(int hand[]) {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount ;
        for (int dieValue = 1; dieValue <=6; dieValue++) {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++) {
                if (hand[diePosition] == dieValue)
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K && found3K)
            foundFH = true;
        return foundFH;
    }
}






