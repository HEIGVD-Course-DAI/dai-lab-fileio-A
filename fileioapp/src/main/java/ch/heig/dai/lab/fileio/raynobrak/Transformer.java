package ch.heig.dai.lab.fileio.raynobrak;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;

    private static final String CHUCK_NORRIS_NAME = "Chuck Norris";

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
        return source.replaceAll(CHUCK_NORRIS_NAME, newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        boolean isNextLetterStartOfWord = true;
        var str = new StringBuilder();

        for(int i = 0; i < source.length(); ++i) {
            Character currentChar = source.charAt(i);
            if(Character.isSpaceChar(currentChar)) {
                isNextLetterStartOfWord = true;
            }
            else if(isNextLetterStartOfWord && Character.isLetterOrDigit(source.charAt(i))) {
                currentChar =  Character.toUpperCase(currentChar);
                isNextLetterStartOfWord = false;
            }
            str.append(currentChar);
        }
        return str.toString();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        var words = source.split(" ");

        var wrappedText = new StringBuilder();

        int currentLine = 1;
        int wordsInCurrentLine = 0;
        for(int i = 0; i < words.length; ++i) {
            if(wordsInCurrentLine == 0) {
                wrappedText.append(currentLine);
                wrappedText.append(". ");
            }

            wrappedText.append(words[i]);
            ++wordsInCurrentLine;
            if(wordsInCurrentLine < numWordsPerLine && i != words.length - 1)
                wrappedText.append(' ');

            if(wordsInCurrentLine >= numWordsPerLine) {
                wrappedText.append('\n');
                wordsInCurrentLine = 0;
                ++currentLine;
            }
        }
        wrappedText.append('\n');

        return wrappedText.toString();
    }
}   