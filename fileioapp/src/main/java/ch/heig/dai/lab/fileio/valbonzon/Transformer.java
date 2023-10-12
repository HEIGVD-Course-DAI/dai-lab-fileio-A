package ch.heig.dai.lab.fileio.valbonzon;

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
        String transformedString = source.replace("Chuck Norris", newName);
        return transformedString;
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        String[] words = source.split(" ");
        String transformedString = new String();
        for(String word : words){
            String firstletter = word.substring(0, 1);
            String remainingLetters = word.substring(1, word.length());
            firstletter = firstletter.toUpperCase();
            word = firstletter + remainingLetters;
            transformedString = String.join(" ", transformedString, word);

        }
        transformedString = transformedString.substring(1, transformedString.length());
        
        return transformedString;
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        
        
        String[] words = source.split(" ");

        StringBuilder transformedString = new StringBuilder();
        int numLine = 1;
        for(int n = 0; n < words.length;n += numWordsPerLine){

            transformedString.append(numLine + ". ");
            for(int m = 0; m < numWordsPerLine; m++){
                
                if(n+m < words.length){
                    if(m != 0)
                        transformedString.append(" ");  
                    transformedString.append(words[n+m]);
                }
                
            }
           
            transformedString.append("\n");
            numLine++;
        }
        return transformedString.toString();
    }
}   