

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class EvilHangmanGame implements IEvilHangmanGame {

    //list of characters of guess
    Set<String> usedGuessLetters = new TreeSet<>();
    String guestLetterLeft = "";
    String pattern = new String();

    //constructor
    public EvilHangmanGame(){

    }

    int wordLength;
    //create a new empty set of Dictionary
    Set<String> myDictionary = new TreeSet<String>();
    Map<String, TreeSet<String>> myMap = new HashMap<String, TreeSet<String>>();


    String key;
    char g;


    @Override
    public void startGame(File dictionary, int wordLength) {

        try {
            Scanner scanner = new Scanner(dictionary);
            while (scanner.hasNext()) {
                String words = scanner.next();
if ( words.length() == wordLength){               
 myDictionary.add(words.toLowerCase());
            }
}
            scanner.close();


        } catch (IOException e) {
            System.err.println("There was an error: " + e.toString());
        }

        
        for (int i = 0; i < wordLength; i++) {
            pattern += '-';
        }
    }

    @Override
    public Set<String> makeGuess(char guess) throws GuessAlreadyMadeException {

        char letter;

        if (Character.isLetter(guess)) {
            //System.out.println("Valid Letter");
            guestLetterLeft = Character.toString(guess);

            //if my set contains my guessletter
            if (usedGuessLetters.contains(guestLetterLeft)) {
                throw new GuessAlreadyMadeException();
            }
            usedGuessLetters.add(String.valueOf(guess));
            myMap.clear();
            for (String currWord : myDictionary) {
                StringBuilder sb = new StringBuilder();
                //if they are the same length
                for (int i = 0; i < currWord.length(); i++) {
                    letter = currWord.charAt(i); //letter I
                    if (guess == letter) {
                        sb.append(letter); //key
                    }
                    else {
                        //old key
                        sb.append(pattern.charAt(i));
                    }
                }
                if (myMap.containsKey(sb.toString())) {
                    //add words attach to the key
                    myMap.get(sb.toString()).add(currWord);
                    //System.out.println(myMap.get(sb.toString()).size());
                } else {
                    //else add the key
                    Set<String> tempSet = new TreeSet<String>();
                    tempSet.add(currWord);
                    myMap.put(sb.toString(), (TreeSet<String>) tempSet);
                }


            }
        } else {
            System.out.println("Not a Valid Letter");
        }
        //Call Largest Set group
        String LargestGroup = largestSet();
        myDictionary = myMap.get(LargestGroup);

        return myDictionary;


    }

    public String largestSet() {
        String bestKeyLS = ""; // set that contains more words
        int largestSize = 0;

        Set<String> keySet = myMap.keySet(); //will return all the KEYS of my set
        for (String key : keySet) {
            int currSizeSet = myMap.get(key).size(); //return the size .. RETURN SIZE OF TREESRET
            //choose the largest set
            if (currSizeSet > largestSize) {
                //System.out.println("here");
                bestKeyLS = key; // the key is going to give me the value that is pointing to.
                myMap.get(bestKeyLS); //save best key onto map
                largestSize = myMap.get(bestKeyLS).size();

            }
            //if they are the same size
            else if (currSizeSet == largestSize) {
                bestKeyLS = fewestLetter(key, bestKeyLS);//call Fewest Letter function
            }
        }
        pattern = bestKeyLS;
        //myDictionary = myMap.get(bestKeyLS);
        return bestKeyLS;
    }

    //best key vs key
    public String fewestLetter(String s1, String s2) {
        String fewLettersGroup = "";
        int s1Counter = 0;
        int s2Counter = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != '-') {
                s1Counter++;
            }
            if (s2.charAt(i) != '-') {
                s2Counter++;
            }
        }
        if (s1Counter > s2Counter) {
            return s2;
        } else if (s1Counter < s2Counter) {
            return s1;

        } else {
            fewLettersGroup = rightMostLetter(s1, s2);
            return fewLettersGroup;
        }
    }

    public String rightMostLetter(String s1, String s2) {

        int l = s1.length();
        for (int i = l - 1; i > -l; i--) {
            if (s1.charAt(i) == '-' && s2.charAt(i) != '-') {
              //  pattern =s2;
                return s2;

            } else if (s1.charAt(i) != '-' && s2.charAt(i) == '-') {
              //  pattern =s1;
                return s1;
            }
        }
        return null;
    }


}






/*


You have 10 guesses left
Used letters:
Word: -----
Enter guess: a
Sorry, there are no a's
You have 9 guesses left
Used letters: a
Word: -----
Enter guess: e
Sorry, there are no e's


 */




    /*
    public String Pattern(char guess, Map<String, TreeSet> myMap) {

        myMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String currWord : myDictionary) {
            //if they are the same length
            if (currWord.length() == wordLength) {
                for (int i = 0; i < currWord.length(); i++) {
                    char letter = currWord.charAt(i); //letter at [i]
                    if (guess == letter) {
                        sb.append(letter); //key
                    } else {
                        sb.append("-");
                    }
                }
                if (myMap.containsKey(sb.toString())) {
                    myMap.get(sb.toString()).add(currWord);
                } else {
                    Set<String> tempSet = new TreeSet<>();
                    myMap.put(sb.toString(), (TreeSet) tempSet);
                }

            }
        }
        return sb.toString();
    }


}


    public Set<String> getGuessesLeft() {
        return usedGuessLetters;
    }


*/


























/*



int letter = 0;

for  ( int i=0; i <words.size(); i++){
    if (word.charAt(i)!= "-"){
        letter++;
    }
    return letters;
}


for key: keyset{

    key < letter
        > dashes
}



 else if ( key.charAt(i) == guess){
                                   if (countLetter < key.length()) {
                                       String FewestLettersGroup = key;
                                       myMap.get(FewestLettersGroup);
                                   }


                                                         //if two or more groups are of the same size

                                //1. Choose the group in which the letter does not appear at all.

                                //2. If each group has the guessed letter, choose the one with the
                                // fewest letters.


                                //3. If this still has not resolved the issue, choose the one with the
                                //rightmost guessed letter.


                                //4. If there is still more than one group, choose the one with the next
                                //rightmost letter. Repeat this step (step 4) until a group is chosen.


                                                     String NoLettersGroup = key;
                                        myMap.get(NoLettersGroup);
                                    } else if (countGuessLetter > 0) { //else if have a letter
                                        if (countGuessLetter < 1) {  // choose the less letters ? wrong
                                            String FewestLettersGroup = key;
                                            myMap.get(FewestLettersGroup);

    //ask Ta



                                        }

                                     s1.length;


                                     for  ( int i= l-1; i> -l; i--){
                                        if(s1.chartat(i) == "-" && s2.chartat(i) != '-'){
                                        return s2;
                                        }
                                        else if( the opposite)

                                        //return s1;

                                     }


 */
