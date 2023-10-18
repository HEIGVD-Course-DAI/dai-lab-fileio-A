package ch.heig.dai.lab.fileio.Tasticoco;

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
        final String toReplace = "Chuck Norris";
        return source.replaceAll(toReplace, this.newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        String[] words = source.split("\\s+");
        StringBuilder capitalizeWords = new StringBuilder();
        for(String word : words){
            String firstChar = word.substring(0, 1);
            String remain = word.substring(1);
            capitalizeWords.append(firstChar.toUpperCase()).append(remain).append(" ");
        }
        return capitalizeWords.toString().trim();
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
        String[] words = source.split("\\s+");
        StringBuilder wrappedAndNumbered = new StringBuilder();
        int lastWordInd = words.length - 1;

        for(int i = 0; i < lastWordInd; i++){
            if(i % this.numWordsPerLine == 0)
                wrappedAndNumbered.append(i / this.numWordsPerLine + 1).append(". ");

            wrappedAndNumbered.append(words[i]);

            if((i + 1) % this.numWordsPerLine != 0)
                wrappedAndNumbered.append(" ");
            else
                wrappedAndNumbered.append("\n");
        }

        wrappedAndNumbered.append(words[lastWordInd]).append("\n");

        return wrappedAndNumbered.toString();
    }
}   