package ch.heig.dai.lab.fileio.AndreaGraf;

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
        return source.replace("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {

        String[] words = source.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(word.substring(0, 1).toUpperCase());
                result.append(word.substring(1));
                result.append(" ");
            }
        }

        // Remove the trailing space and return the result
        return result.toString().trim();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {

        String[] words = source.split("\\s+");
        StringBuilder result = new StringBuilder();
        int wordsInCurrentLine = 0;

        for (String word : words) {
            if (wordsInCurrentLine >= numWordsPerLine) {
                result.append("\n");
                wordsInCurrentLine = 0;
            }
            result.append(word).append(" ");
            wordsInCurrentLine++;
        }

        // Append line numbers at the beginning of each line
        String[] lines = result.toString().split("\n");
        result.setLength(0); // Clear the StringBuilder
        int lineCounter = 1;
        for (String line : lines) {
            line = line.substring(0, line.length() - 1);
            result.append(lineCounter).append(". ").append(line).append("\n");
            lineCounter++;
        }
        return result.toString();
    }
}   