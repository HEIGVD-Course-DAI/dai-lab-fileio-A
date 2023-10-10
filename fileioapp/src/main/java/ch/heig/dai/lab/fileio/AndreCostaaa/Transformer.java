package ch.heig.dai.lab.fileio.AndreCostaaa;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;

    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with
     * and the number of words per line to use when wrapping the text.
     * 
     * @param newName         the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the
     *                        text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the
     * constructor.
     * 
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {

        final String textToReplace = "Chuck Norris";

        return source.replaceAll(textToReplace, newName);
    }

    private String capitalizeFirstLetter(String word) {
        if (word.isEmpty()) {
            return word;
        }
        String firstCharacter = word.substring(0, 1).toUpperCase();

        if (word.length() > 1) {
            return firstCharacter + word.substring(1);
        }

        return firstCharacter;
    }

    private String[] getWordsInText(String text) {
        return text.split(" ");
    }

    /**
     * Capitalize the first letter of each word in the string.
     * 
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {

        var words = getWordsInText(source);

        var builder = new StringBuilder(capitalizeFirstLetter(words[0]));

        // iterate over every word and capitalize its first letter
        for (int i = 1; i < words.length; ++i) {
            builder.append(" " + capitalizeFirstLetter(words[i]));
        }
        return builder.toString();

    }

    private String newLinePrefix(int lineNumber) {
        return String.format("\n%d.", lineNumber);
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * 
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {

        var words = getWordsInText(source);

        var builder = new StringBuilder("1. " + words[0]);

        for (int i = 1; i < words.length; ++i) {
            if (i % numWordsPerLine == 0) { // add new line
                final int lineNumber = i / numWordsPerLine + 1;
                builder.append(newLinePrefix(lineNumber));
            }
            builder.append(" " + words[i]);

        }
        builder.append('\n');
        return builder.toString();
    }
}