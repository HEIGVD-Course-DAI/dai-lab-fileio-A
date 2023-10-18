package ch.heig.dai.lab.fileio.JulienHolzer;

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
        return source.replaceAll("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        // Capitaliser la première lettre de chaque mot dans la chaîne.
        StringBuilder result = new StringBuilder();
        String[] words = source.split(" ");
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1));
                }
                result.append(" ");
            }
        }
        return result.toString().trim(); // Supprimer l'espace final.
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
        // Envelopper le texte avec au plus numWordsPerLine mots par ligne et numéroter les lignes.
        StringBuilder result = new StringBuilder();
        String[] words = source.split(" ");
        int lineCount = 1;
        int wordCount = 0;

        for (String word : words) {
            if (wordCount >= numWordsPerLine) {
                result.append("\n");
                wordCount = 0;
                lineCount++;
            }

            result.append(word).append(" ");
            wordCount++;
        }

        return result.toString().trim() + "\n"; // Ajouter un saut de ligne à la fin.
    }
}   