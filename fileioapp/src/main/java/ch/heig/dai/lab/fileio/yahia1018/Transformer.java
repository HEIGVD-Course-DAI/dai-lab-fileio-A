package ch.heig.dai.lab.fileio.yahia1018;

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
        final String chuck = "Chuck Norris";

        return source.replaceAll(chuck, this.newName);
    }

    /**
     * Extract all the words from a String into an array.
     * @param source the string from which to extract the words
     * @return an array with the (String) words
     */
    private String[] getWords(String source) {
        return source.split(" ");
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        if (source.isEmpty()) return "";

        String[] words = getWords(source);
        StringBuilder dest = new StringBuilder();

        for (String word:words) {
            String  firstLetter = word.substring(0, 1),
                    restOfWord = word.substring(1);
            dest.append(firstLetter.toUpperCase()).append(restOfWord).append(" ");
        }

        return dest.toString().trim();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        if (source.isEmpty()) return "";

        String[] words = getWords(source);
        StringBuilder dest = new StringBuilder("1.");
        int i = 0, j = 1;

        for (String word:words) {
            dest.append(" ").append(word);

            if (++i % numWordsPerLine == 0 && i != words.length) {
                dest.append('\n').append(++j).append('.');
            }
        }

        dest.append('\n');
        return dest.toString();
    }
}   