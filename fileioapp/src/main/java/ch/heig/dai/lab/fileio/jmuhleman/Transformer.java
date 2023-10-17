package ch.heig.dai.lab.fileio.jmuhleman;

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

        if (source.isEmpty())
            return "";
        return source.replace("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        
        if (source.isEmpty()) {
            return source;
        }

        StringBuilder result = new StringBuilder();
        String[] words = source.split("\s+"); // Split the input string into words

        for (String word : words) {
            if (word.length() > 1) {
                // Capitalize the first letter and append the rest of the word
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
            else {
                // If the word has only one letter, capitalize it and append a space
                result.append(Character.toUpperCase(word.charAt(0))).append(" ");
            }
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
        if (source == null || source.isEmpty() || numWordsPerLine <= 0) {
            return source;
        }

        String[] words = source.split("\s+");
        StringBuilder result = new StringBuilder();
        int wordCount = 0;
        int lineCount = 1;
        result.append(lineCount).append(".");

        for (String word : words){
            if (wordCount == numWordsPerLine) {
                // Start a new line and increment the line number
                result.append("\n").append(++lineCount).append(".");
                wordCount = 0;
            }
            result.append(" " + word);
            wordCount++;
        }

        return result.append("\n").toString();
    }
}
