package ch.heig.dai.lab.fileio.borishuu;

import java.io.IOException;

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
        return source.replaceAll("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        String[] words = source.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            stringBuilder.append(word.substring(0, 1).toUpperCase());
            stringBuilder.append(word.substring(1));
            stringBuilder.append(" "); 
        }
        return stringBuilder.toString().trim();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        String[] words = source.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        int numWords = 0;
        int line = 1;

        for (String word : words) {
            if (numWords % numWordsPerLine == 0) {
                if (numWords != 0) {
                    stringBuilder.append("\n");
                }
                stringBuilder.append(line + "."); 
                line++;                          
            }
            stringBuilder.append(" " + word);
            numWords++;
        }
        return stringBuilder.append('\n').toString();
    }
}   