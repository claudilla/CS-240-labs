
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Main {

    static EvilHangmanGame game;
    static int guesses;


    public static void main(String[] args) {
        boolean won = false;
        // char guess = 'a';

        File file = new File(args[0]);
        int wordLength = Integer.valueOf(args[1]);
        guesses = Integer.valueOf(args[2]);

        if (wordLength < 2) {
            System.out.println("Invalid Length.");
        } else if (guesses < 1) {
            System.out.println("Invalid Integer.");
        }
        game = new EvilHangmanGame();
        game.startGame(file, wordLength);

        while (guesses > 0 && !won) {
            if (guesses > 1) {
                System.out.println("You have " + guesses + " guesses left");
            } else {
                System.out.println("You have " + guesses + " guess left");
            }
            System.out.print("Used letters: ");
            int counter = 0;
            //if we haven't made any guess yet
            if (game.usedGuessLetters.size() == 0) {
                System.out.println(" ");
            }
            //if we have make guesses, print the guess letters
            else {
                for (String letter : game.usedGuessLetters) {
                    System.out.print(letter + " ");
                }
            }
            System.out.println();
            System.out.print("Word: ");
            //print pattern
            System.out.println(game.pattern);

            /* Input Letter*/
            Scanner input = new Scanner(System.in);
            System.out.print("Enter guess: ");
            String x = input.nextLine();
  x= x.toLowerCase();

            if (x.length() > 1 || x.isEmpty()) {
                System.out.println("It is not a valid letter");
            } else if (!Character.isLetter(x.charAt(0))) {
                System.out.println("It is not a valid letter");
            } else if (game.usedGuessLetters.contains(x)) {
                System.out.println("This letter has already been guessed");

            } else {

                try { //everything after here means it is a valid guess
                    //System.out.println(game.usedGuessLetters);
                    game.makeGuess(x.charAt(0));


                    if ( !game.pattern.contains(x)){
                        System.out.println("Sorry, there are no " + x + "\'s");
                        guesses--;


                    }

                } catch (IEvilHangmanGame.GuessAlreadyMadeException e) {
                    System.err.println("There was an error: " + e.toString());

                }
                int count = 0;
                for(int i=0; i < game.pattern.length(); i++){
                    if(game.pattern.charAt(i)!= '-'){
                        count++;
                    }
                }
                if(count == game.pattern.length()){
                    System.out.println("You WIN!");
                    
                    break;
                }
                if(guesses == 0){
                    System.out.println("You lose!");
                    System.out.println("The word was: ");
                    System.out.println(game.myDictionary.iterator().next());
                }





            }



            //break;
        }
/*
        if (!won) {

            System.out.println("You lose!");
            System.out.println("The word was: ");
            System.out.println(game.myDictionary.iterator().next());

        }
        */

    }
}

