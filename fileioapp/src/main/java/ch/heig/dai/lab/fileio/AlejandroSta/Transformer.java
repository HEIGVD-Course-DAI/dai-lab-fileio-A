package ch.heig.dai.lab.fileio.AlejandroSta;

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
        String[] split = source.split("Chuck Norris");
        return String.join(newName, split);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        String[] split = source.split(" ");
        for(int i = 0; i < split.length; ++i){
            String s = split[i];
            split[i] = Character.toUpperCase(s.charAt(0)) + s.substring(1);
        }
        return String.join(" ", split);
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
        String[] split = source.split(" ");
        for(int i = 0; i <= split.length / numWordsPerLine; ++i){
            stringBuilder.append(i + 1);
            stringBuilder.append(".");
            for(int j = 0; j < numWordsPerLine && i * numWordsPerLine + j < split.length; ++j){
                stringBuilder.append(" ");
                stringBuilder.append(split[i * numWordsPerLine + j]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}   