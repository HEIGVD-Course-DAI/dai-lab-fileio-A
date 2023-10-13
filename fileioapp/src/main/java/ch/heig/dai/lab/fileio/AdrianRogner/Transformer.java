package ch.heig.dai.lab.fileio.AdrianRogner;

import java.util.regex.Pattern;

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
        return source.replaceAll("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        String[] str = source.split(" ");
        String capitalized = "";
        for(String w:str){
            String first = w.substring(0,1);
            String other = w.substring(1);
            capitalized += first.toUpperCase() + other + " ";
        }
        String result = capitalized.substring(0, capitalized.length() - 1);
        return result;
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        // TODO: Implement the method body here.
        // Use the StringBuilder class to build the result string.
        StringBuilder stringBuilder = new StringBuilder();
        String[]str = source.split(" ");
        int j = 1;
        for(int i = 0; i < str.length; ++i){
            if(i % numWordsPerLine == 0){
                if(i == 0) {
                    stringBuilder.append(j++ + ". " + str[i]);
                } else {
                    stringBuilder.append("\n" + j++ + ". " + str[i]);
                }
            } else {
                stringBuilder.append(" " + str[i]);
            }
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}   