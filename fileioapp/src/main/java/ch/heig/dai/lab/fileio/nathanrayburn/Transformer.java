package ch.heig.dai.lab.fileio.nathanrayburn;

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
        return source.replaceAll("Chuck Norris", this.newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        String[] words = source.split("\s+");
        StringBuilder res = new StringBuilder();

        for(String word : words) {
            res.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
            res.append(" ");
        }

        return res.toString().trim();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {

        StringBuilder res = new StringBuilder();
        String[] words = source.split("\s+");

        int wordCount  = 0;
        int lineNUmber = 1;

        res.append("1. ");

        for(String word : words) {
            res.append(word);
            wordCount++;

            if(wordCount >= numWordsPerLine){
                res.append("\n").append(++lineNUmber).append(". ");
                wordCount = 0;
            }else {
                if(word != words[words.length-1])
                    res.append(" ");
                else
                    res.append("\n");
            }

        }

        return res.toString();
    }
}   