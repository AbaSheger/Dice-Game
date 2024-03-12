import java.util.Scanner;
/**
* Assignment 3.
* This is a program that simulate Dice Game 12.
* 1.Create variables.
* 2.Declare a scanner class to read inputs.
* 3.If user enters roll dice other than 1,2,3 display "invalid input".
* 4.If the player presses q, print "Game Over!".
* 5.Roll one dice each at a time.
* 6.Roll each dice one time in each round.
* 7.If the the same dice rolls again before the round is over tell the user not to roll the same dice. 
* 8.add the dices.
* 9.check condition for win, loss and next round.
* 10.print results.
* 11.reset dices and start next round if condition is fullfilled.
* author Abenezer Anglo, abeang-2
*/

class DiceGame {
    public static void main(String[] args) {
        // declare variables

        int sumOfDice = 0;
        int diceOne = 0;
        int diceTwo = 0;
        int diceThree = 0;
        int countWin = 0;
        int countLoss = 0;
        int roll = 0;

        System.out.println("Welcome to the game 12. You must roll 1-3 dice and try to get the sum 12 ...");

        Scanner userInput = new Scanner(System.in);
        // Ask the player to choose a dice
        while (true) {
            System.out.print("Enter which dice you want to roll [1,2,3] (exit with q):");
            String diceText = userInput.nextLine();

            // roll the dices and count the number of roll
            switch (diceText) {
                case ("1"):
                    if (diceOne != 0) //to check if the dice rolled twice
                    {
                        System.out.println("You can't roll the same dice twice!");
                        break;
                    }
                    diceOne = (int)(Math.random() * 6) + 1;
                    roll++;

                    break;
                case ("2"):
                    if (diceTwo != 0) {
                        System.out.println("You can't roll the same dice twice!");
                        break;
                    }
                    diceTwo = (int)(Math.random() * 6) + 1;
                    roll++;

                    break;
                case ("3"):
                    if (diceThree != 0) {
                        System.out.println("You can't roll the same dice twice!");
                        break;
                    }

                    diceThree = (int)(Math.random() * 6) + 1;
                    roll++;
                    break;

                case ("q"):
                    System.out.println("Game over!");
                    return;

                default:
                    System.out.println("Invalid input!Please enter which dice you want to roll [1,2,3 ] (exit with q)");
                    break;
            }
            Boolean roundFinished = false; // use boolean to check if the condition to finish the round is fullfilled 
            sumOfDice = diceOne + diceTwo + diceThree; //add the dices


            // the three scenarios that call for  a new round 
            if (sumOfDice == 12) { //new round starts and win counter increase
                countWin++;
                roundFinished = true;
            }
            if (sumOfDice > 12 && roll == 3) { // new round starts and loss counter increase
                countLoss++;
                roundFinished = true;
            }
            if (roll == 3 && sumOfDice < 12) // new round starts and no win or loss incurred 
            {
                roundFinished = true;

            }

            //print results
            System.out.print(diceOne + " " + diceTwo + " " + diceThree + "\t");
            System.out.println(
                "sum :" + "\t" + sumOfDice + "\t" + "#win:" + "\t" + countWin + "\t" + "#Loss:" + "\t" + countLoss);
            if (roundFinished) { //if the if conditions above are true, reset the dices
                diceOne = 0;
                diceTwo = 0;
                diceThree = 0;
                roll = 0;
                System.out.println("New round!");
            }

        }

    }
}