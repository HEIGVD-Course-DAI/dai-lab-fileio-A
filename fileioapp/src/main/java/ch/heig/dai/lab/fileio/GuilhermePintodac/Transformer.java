package ch.heig.dai.lab.fileio.GuilhermePintodac;

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
        StringBuilder result = new StringBuilder();

        result.append(Character.toUpperCase(source.charAt(0)));
        for (int i = 1; i < source.length(); i++){
            if (source.charAt(i - 1) == ' '){
                result.append(Character.toUpperCase(source.charAt(i)));
            }else {
                result.append(source.charAt(i));
            }
        }
        return result.toString();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        StringBuilder result = new StringBuilder();

        var words = source.split(" ");
        var nbWords = words.length;

        int line = 1;
        result.append(line + ". ");
        for (int i = 0; i < nbWords; i++){
            if (i % numWordsPerLine == 0 && i != 0){
                result.deleteCharAt(result.length() - 1);
                result.append("\n" + ++line + ". ");
            }
            result.append(words[i] + " ");
        }
        result.deleteCharAt(result.length() - 1);
        result.append("\n");
        return result.toString();
    }
}   