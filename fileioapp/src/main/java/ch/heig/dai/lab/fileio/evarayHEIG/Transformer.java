package ch.heig.dai.lab.fileio.evarayHEIG;

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
        StringBuilder capitalizedString = new StringBuilder();
        for(String word : words){
            capitalizedString.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }

        // substring that doesn't include the last extra space
        return capitalizedString.substring(0, capitalizedString.length() - 1);
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        // Use the StringBuilder class to build the result string.

        StringBuilder newString = new StringBuilder();
        int lineNumber = 1;
        int numWordsCounter = 0;
        String[] words = source.split(" ");

        for(String word : words){
            if(numWordsCounter % numWordsPerLine == 0){
                if(numWordsCounter != 0){
                    // delete the extra space at the end of the line
                    newString.deleteCharAt(newString.length() - 1);
                    newString.append("\n");
                }
                newString.append(lineNumber).append(". ");
                lineNumber++;
            }
            newString.append(word).append(" ");
            numWordsCounter++;
        }
        // replace the last extra space by newline
        newString.setCharAt(newString.length() - 1, '\n');
        return newString.toString();
    }
}   