package ch.heig.dai.lab.fileio.LeVraiGG;

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
        return source.replaceAll("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     *
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        String[] words = source.split("\\s");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     *
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        String[] words = source.split("\\s");
        StringBuilder sb = new StringBuilder();


        int nbWordsInLine = 0;
        int nbLine = 1;
        for (String word : words) {
            if (nbWordsInLine == 0) {
                sb.append(nbLine).append(".");
            }
            ++nbWordsInLine;

            sb.append(" ").append(word);

            if (nbWordsInLine >= numWordsPerLine || word.equals(words[words.length-1])) {
                nbWordsInLine = 0;
                ++nbLine;
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}   