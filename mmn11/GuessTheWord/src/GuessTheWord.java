/**
 * This class represents the word that was chosen for particular game round
 *
 * @author Nadya Balandin (ID 336103726)
 * @version 04/11/2021
 */
import java.util.Scanner;

public class GuessTheWord {
    public static void main(String[] args)
    {
        //method variables
        Word currentWord;
        char letter;
        boolean[] abc;      //letters of alphabet which is still wasn't chosen (true if was chosen before)
        int count;          //counter of attempts to guess
        Scanner input = new Scanner(System.in);

        //one round of the game
        do {
            abc = new boolean[Vocabulary.ABC];
            count = 0;
            currentWord = new Word();

            while (!currentWord.isGameFinished()) {
                System.out.println("\nThe word to guess is " + currentWord.getWordBlank());
                System.out.print("Please enter a letter from the list: ");
                for(int i=0; i<abc.length; i++){
                    if(!abc[i]){
                        System.out.print((char)('a'+ i) + ",");
                    }
                }
                System.out.println();

                //read and validate input from user
                letter = inputValidation(input.next(), abc);

                if(letter >= 'a' && letter <= 'z') {
                    abc[letter - 'a'] = true;   //remove the letter from the list of suggested alphabet letters
                    if (currentWord.isWordLetter(letter)) {   //checks if the word contains the letter
                        System.out.println("Good guess!");
                    } else {
                        System.out.println("Wrong guess.");
                    }
                    count++;
                }
            } // end of while game is not finished

            System.out.println("\nCongratulations. The word is " + currentWord.getWordBlank() + ".\n" +
                                "It tooks " + count + " guesses to WIN (not include invalid inputs).\n" +
                                "Do you wanna try again?\n" +
                                "Please press 'Y' to continue or other keyboard key to exit.");

        } while(input.next().charAt(0) == 'Y');
        // end of do-while (one round of the game)
    } //end of main method

    private static char inputValidation(String guess, boolean[] abc) {
        char letter = (char) -1;
        if (guess.length() > 1) {
            System.out.println("Invalid input! Please enter a SINGLE character only.");
        }
        else {
            letter = guess.charAt(0);
            if (letter >= 'A' && letter <= 'Z') {
                letter += 'a' - 'A';       // convert to lowercase character
            }
            if (!(letter >= 'a' && letter <= 'z')) {    //the character is not a letter
                System.out.println("Invalid input! The character " + letter + " is not a alphabet letter.");
            }
            else if(abc[letter - 'a']){       //the letter already was chosen earlier
                System.out.println("Invalid input! The letter '" + letter +"' already was chosen earlier.");
                letter = (char) -1;
            }
        }
        return letter;
    } // end of inputValidation method
} //end of GuessTheWord class
