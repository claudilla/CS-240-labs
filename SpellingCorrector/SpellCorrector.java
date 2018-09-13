package spell;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;




public class SpellCorrector implements ISpellCorrector {
    //create Trie object
    Trie trie;


    public SpellCorrector() {

        trie = new Trie();

    }

    @Override
    public void useDictionary(String dictionaryFileName) throws IOException {
        //parse through my dictionaryFileName

        //create the file //option+enter
        File file = new File(dictionaryFileName);
        //scanning tru my file
        Scanner scanner = new Scanner(file);
        //get the next string
        //scanner.next();
        //i get each string..

        //pass each word to my trie
        while (scanner.hasNext()) {
            String words = scanner.next();
            trie.add(words);
        }
        scanner.close();


    }

    @Override
    public String suggestSimilarWord(String inputWord) {

        int freq = 0;
        String final_result = "";
        inputWord = inputWord.toLowerCase();
        //I am creating a set of Strings
        Set<String> editedWord = new TreeSet<>();

        //call trie.find
        Trie.Node findWord = trie.find(inputWord);
        /*if the input word is spelled correctly*/
        /*return the same word*/
        //if they are the same word//
        if (findWord != null) {
            return inputWord;
        }
        /*If the case independent version of the input string is not found, your program will return the most “similar” word (converted to lowercase)*/
        //if findword == null

        /*code modified*/
        else {

            DeletionDistance(editedWord, inputWord);
            TranspositionDistance(editedWord, inputWord);
            AlterationDistance(editedWord, inputWord);
            InsertionDistance(editedWord, inputWord);

            //for each loop - look for an element in my set
            for (String iterator : editedWord) {

                Trie.Node result = trie.find(iterator);

                //distance 1
                //ask ta//
                if (result != null && result.frequency > freq) {
                    freq = result.frequency;
                    //the one that has the highest freq
                    final_result = iterator;
                }

            }//end of my loop

            ///seconds time
            //if final result is empty
            if (final_result.equals("")) {
                //modifying editedword
                Set<String> editDistance2 = new TreeSet<>();

                for (String word : editedWord) {
                    DeletionDistance(editDistance2, word);
                    TranspositionDistance(editDistance2, word);
                    AlterationDistance(editDistance2, word);
                    InsertionDistance(editDistance2, word);

                }


                for (String iterator : editDistance2) {
                    Trie.Node result = trie.find(iterator);

                    if (result != null && result.frequency > freq) {

                        freq = result.frequency;
                        final_result = iterator;

                    }

                }

                if (final_result.equals("")) {
                    return null;

                } else {
                    return final_result;
                }

            } else {
                return final_result;
            }
        }
    }

    public void editDistance1(String inputWord) {



        /*
         If there is more than one word in the dictionary that is an edit distance of 1 from
          the input string then return the one that appears the greatest number of times in
          the original text file.
         */


    }


    public void DeletionDistance(Set<String> allTheWords, String word) {
        //Set <string> test = new TreeSet<string>;
//    Set<String>  modifiedWord = new TreeSet<String>();
        for (int i = 0; word.length() > i; i++) {
            StringBuilder sb = new StringBuilder(word);
            String myNewWord = sb.deleteCharAt(i).toString();
            allTheWords.add(myNewWord);
        }
        //System.out.println(allTheWords.toString());
    }

    public void TranspositionDistance(Set<String> allTheWords, String word) {
        //create string builder
        // StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length() - 1; i++) {
            char[] charArray = word.toCharArray();
            char temp = charArray[i];
            charArray[i] = charArray[i+1];
            charArray[i+1] = temp;
            allTheWords.add(new String(charArray));
        }
        //System.out.println(allTheWords.toString());
    }

    public void AlterationDistance(Set<String> allTheWords, String word) {
        for (int i = 0; i < word.length(); i++) {
            char[] charArray = word.toCharArray();
            for (char a = 'a'; a <= 'z'; a++) {
                charArray[i] = a;
                allTheWords.add(new String(charArray));
            }
        }
        // System.out.println(allTheWords.toString());
    }

    public void InsertionDistance(Set<String> allTheWords, String word) {
        for (int i = 0; i <= word.length(); i++) {
            for (char a = 'a'; a < 'z'; a++) {
                StringBuilder sb = new StringBuilder(word);
                String myNewWord = sb.insert(i, a).toString();
                allTheWords.add(myNewWord);
            }
        }
        // System.out.println(allTheWords.toString());
    }
}
