package ch.heig.dai.lab.fileio.Neroil;

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

        String chuck = "Chuck Norris";
        return source.replace(chuck, newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {

        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i < source.length();++i){

            if (((i == 0) || source.charAt(i-1) == ' ')){
                newStr.append(Character.toString(Character.toUpperCase(source.charAt(i))));
                continue;
            }

            newStr.append(source.charAt(i));
        }

        return newStr.toString();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {

        StringBuilder newStr = new StringBuilder();
        int count = 0;
        int line = 1;
        boolean isNewLine = true;

        for(int i = 0; i < source.length();++i){

            if (i == source.length() - 1 || (source.charAt(i+1) == ' ') && source.charAt(i) != ' '){
                ++count;
            }

            if (isNewLine){
                newStr.append(line);
                newStr.append('.');
                if(line == 1) newStr.append(' ');
                isNewLine = false;
            }

            newStr.append(source.charAt(i));

            if(count == numWordsPerLine){
                newStr.append("\n");
                count = 0;
                ++line;
                isNewLine = true;
            }

        }
        newStr.append("\n");

        return newStr.toString();
    }
}   