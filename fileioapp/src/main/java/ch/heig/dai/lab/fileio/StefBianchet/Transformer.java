package ch.heig.dai.lab.fileio.StefBianchet;

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

        String oldName = "Chuck Norris";

        return source.replaceAll(oldName,newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {

        String[] words = source.split(" ");
        StringBuilder capitalizeWord = new StringBuilder();
        for(String w:words){
            String first = w.substring(0,1);
            String afterfirst = w.substring(1);
            capitalizeWord.append(first.toUpperCase()).append(afterfirst).append(" ");
        }

        return capitalizeWord.toString().trim();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {

        String[] words = source.split(" ");
        StringBuilder createLines = new StringBuilder();

        int wordIndex = 0;
        int lineNumber = 1;

        for (String w : words){

            if ((wordIndex % numWordsPerLine) == 0)
                createLines.append(lineNumber++).append(". ");

            createLines.append(w);
            wordIndex++;

            if ((wordIndex % numWordsPerLine) == 0)
                createLines.append("\n");
            else
                createLines.append(" ");
        }

        createLines.deleteCharAt(createLines.length() - 1);

        createLines.append("\n");


        // Use the StringBuilder class to build the result string.
        return createLines.toString();
    }
}   