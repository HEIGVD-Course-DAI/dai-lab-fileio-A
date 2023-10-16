package ch.heig.dai.lab.fileio.Sainane;


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
        // TODO: Implement the method body here.

        return source.replaceAll("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     *
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {

        String[] words = source.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return String.join(" ", words);
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     *
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        // Use the StringBuilder class to build the result string.
        StringBuilder sb = new StringBuilder();
        String[] words = source.split(" ");
        int number = 0;
        int numberLine = 1;

        StringBuilder line = new StringBuilder();

        for (String word : words) {
            line.append(word);
            number++;

            if (number% numWordsPerLine == 0) {
                sb.append(numberLine).append(". ");
                numberLine++;


            }
            if(number== 3) {
                sb.append(line).append("\n");
                number = 0;
                line = new StringBuilder();
            } else {
                line.append(" ");
            }

        }
        if(!line.toString().trim().isEmpty()) {
            sb.append(numberLine).append(". ").append(line.toString().trim()).append("\n");
        }

        return sb.toString();
    }


}   