package ch.heig.dai.lab.fileio.Rafou2898;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;

    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with
     * and the number of words per line to use when wrapping the text.
     *
     * @param newName         the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     *
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        // TODO: Implement the method body here.
        final String name = "Chuck Norris";

        return source.replaceAll(name, newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     *
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        if (source.isEmpty()) return "";

        String[] mots = source.split(" ");
        StringBuilder retour = new StringBuilder();
        int i = 0;
        for (String mot : mots) {
            Character toUp = Character.toUpperCase(mot.charAt(0));
            mot = toUp + mot.substring(1);
            retour.append(mot);
            if (i < mots.length - 1) {
                retour.append(" ");
            }
            i++;
        }
        return retour.toString();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     *
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        // TODO: Implement the method body here.
        // Use the StringBuilder class to build the result string.
        String[] mots = source.split(" ");
        StringBuilder retour = new StringBuilder("1. " + mots[0]);

        for (int i = 1; i < mots.length; i++) {
            if (i % numWordsPerLine == 0) {
                retour.append("\n").append(i / numWordsPerLine + 1).append(". ");
            } else {
                retour.append(" ");
            }
            retour.append(mots[i]);
        }
        retour.append("\n");
        return retour.toString();
    }
}   