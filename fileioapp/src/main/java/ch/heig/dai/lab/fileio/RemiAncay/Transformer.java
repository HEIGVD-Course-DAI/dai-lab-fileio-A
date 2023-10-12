package ch.heig.dai.lab.fileio.RemiAncay;

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
        var words = source.split(" ");
        var builder = new StringBuilder();

        for (String w : words) {
            String capitalizedWord = w.substring(0, 1).toUpperCase() + w.substring(1) + " ";
            builder.append(capitalizedWord);
        }
        builder.deleteCharAt(builder.length()-1);

        return builder.toString();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        var words = source.split(" ");
        var builder = new StringBuilder();
        
        int n = 0;
        int line = 1;
        
        for (String w : words) {
            if(n == 0) //Start a new line with it number
                builder.append(line + ". ");

            builder.append(w + " ");
            n++;
            if(n == numWordsPerLine) //Start a new line
            {
                builder.deleteCharAt(builder.length()-1);
                builder.append("\n");
                n = 0;
                line++;
            }
        }
        //Clear the end of the string
        builder.deleteCharAt(builder.length()-1);
        builder.append("\n");
        
        return builder.toString();
    }
}   