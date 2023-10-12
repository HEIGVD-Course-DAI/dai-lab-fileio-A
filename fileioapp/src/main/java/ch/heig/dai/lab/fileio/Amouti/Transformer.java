package ch.heig.dai.lab.fileio.Amouti;

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

        StringBuilder result = new StringBuilder(source.length());
        for(int i = 0; i < source.length(); ++i){
            if(source.charAt(i) == ' '){
                result.append(' ').append(Character.toUpperCase(source.charAt(++i)));
            }
            else{
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
        // TODO: Implement the method body here.
        // Use the StringBuilder class to build the result string.
        int lineCounter = 1;
        int wordCounter = 0;
        StringBuilder result = new StringBuilder();
        result.append("1. ");

        for(int i = 0; i < source.length(); ++i){
            result.append(source.charAt(i));

            if((i + 1) < source.length() && source.charAt(i+1) == ' ') {
                ++wordCounter;
            }
            if(wordCounter == numWordsPerLine){
                result.append('\n').append(++lineCounter).append('.');
                wordCounter = 0;
            }
        }
        return result.append('\n').toString();
    }
}   