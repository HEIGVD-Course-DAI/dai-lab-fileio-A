package ch.heig.dai.lab.fileio.LucasHSN;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;

    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with
     * and the number of words per line to use when wrapping the text.
     *
     * @param newName         the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     *
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        return source.replace("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     *
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : source.toCharArray()) {
            if (Character.isWhitespace(c))
                capitalizeNext = true;
            else if (capitalizeNext) {
                c = Character.toUpperCase(c);
                capitalizeNext = false;
            }
            result.append(c);
        }
        return result.toString();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     *
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        String[] words = source.split("\\s+");
        StringBuilder result = new StringBuilder();
        int wordCount = 0;
        int lineCount = 1;

        for (String word : words) {
            if(wordCount == 0) {
                result.append(lineCount).append(". ");
                lineCount++;
            }
            if (wordCount == numWordsPerLine) {
                result.append("\n").append(lineCount).append(". ");
                lineCount++;
                wordCount = 0;
            }
            if (wordCount > 0) {
                result.append(" ").append(word);
            } else {
                result.append(word);
            }
            wordCount++;
        }
        result.append("\n");

        return result.toString();
    }
}