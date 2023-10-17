package ch.heig.dai.lab.fileio.CamilleKoestli;

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
        String Chuck = "Chuck Norris";
        return source.replaceAll(Chuck,newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        char caractere;
        for(int i = 0;i<source.length();i++){
            if(i==0 || source.charAt(i-1) == ' '){
                caractere = Character.toUpperCase(source.charAt(i));
                source = source.substring(0,i) + caractere + source.substring(i+1);
            }
        }
        return source;
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
        int newLineStart = 0,wordCounter = 0,lineNumber = 1;
        StringBuilder result = new StringBuilder(source.length());
        String intermediate;

        for(int i = 0;;i++){
            //count the words
            if(source.charAt(i) == ' '){
                wordCounter++;
            }

            if(wordCounter == numWordsPerLine){
                //add the line number and content in the result buffer
                intermediate = source.substring(newLineStart,i);
                result.append(lineNumber + ". " + intermediate + "\n");

                wordCounter = 0;
                //set de beginning of the next line to the next character (skip the space)
                newLineStart = i+1;
                lineNumber++;
            }

            if(i==source.length() - 1){
                //i+1 is for the last character (usualy '.')
                intermediate = source.substring(newLineStart,i+1);
                result.append(lineNumber + ". " + intermediate + "\n");
                return result.toString();
            }
        }
    }
}   