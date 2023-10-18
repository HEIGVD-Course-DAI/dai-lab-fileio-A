package ch.heig.dai.lab.fileio.GLK;

import java.io.*;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;

    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with 
     * and the number of words per line to use when wrapping the text.
     * @param newName the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        // TODO: Implement the method body here.
        // replaces the words "Chuck Norris" by another name (provided to the constructor).
        String result;
        String chuckNorris = "Chuck Norris";
        try {

            result = source.replaceAll(chuckNorris, newName);

        } catch (Exception e) {
            return null;
        }
        return result;


    }


    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        //capitalizes the first letter of each word
        //seperates the source string into words
        //s+ for all the spaces until the end of the source
        String wordsTab[] = source.split("\s+");
        StringBuilder result = new StringBuilder();
        try {
            for(String word : wordsTab) {
               result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }

        }catch(Exception e) {
            return null;
        }
        return result.toString().trim();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        // TODO: Implement the method body here.
        // wraps the text to a given number of words per line and add a number at the beginning of each line.
        // Use the StringBuilder class to build the result string.
        StringBuilder result = new StringBuilder();
        String words[] = source.split("\s+");
        int nbrLines = 1;
        int offset = 0;
        try {
            //ajout du numéro de ligne
            result.append(nbrLines + ". ");

            //boucle pour ensuite \n à chaque 3 mots
            for(String word : words) {
                //ajout des 3 premiers mots
                result.append(word);
                offset++;

                //si offset == numwordsperline alors on doit retourner à la ligne
                if(offset == numWordsPerLine) {
                    result.append("\n");
                    result.append(++nbrLines + ". ");
                    offset = 0;

                } else {

                    //si on est pas encore à la fin du tableau on ajoute un espace si c'est la fin on fait un retour à la ligne
                    if(word != words[words.length - 1]) {
                        result.append(" ");

                    } else {
                        result.append("\n");
                    }

                }
            }


        }catch(Exception e) {
            return null;
        }
        return result.toString();
    }
}   