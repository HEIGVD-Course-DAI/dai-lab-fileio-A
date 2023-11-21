package ch.heig.dai.lab.fileio;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

// *** TODO: Change this to import your own package ***
import ch.heig.dai.lab.fileio.GuillaumeDnt2.*;

public class Main {
    // *** TODO: Change this to your own name ***
    private static final String newName = "Guillaume Dunant";

    /**
     * Main method to transform files in a folder.
     * Create the necessary objects (FileExplorer, EncodingSelector, FileReaderWriter, Transformer).
     * In an infinite loop, get a new file from the FileExplorer, determine its encoding with the EncodingSelector,
     * read the file with the FileReaderWriter, transform the content with the Transformer, write the result with the
     * FileReaderWriter.
     * 
     * Result files are written in the same folder as the input files, and encoded with UTF8.
     *
     * File name of the result file:
     * an input file "myfile.utf16le" will be written as "myfile.utf16le.processed",
     * i.e., with a suffixe ".processed".
     */
    public static void main(String[] args) {
        // Read command line arguments
        if (args.length != 2 || !new File(args[0]).isDirectory()) {
            System.out.println("You need to provide two command line arguments: an existing folder and the number of words per line.");
            System.exit(1);
        }
        String folder = args[0];
        int wordsPerLine = Integer.parseInt(args[1]);
        System.out.println("Application started, reading folder " + folder + "...");
        
        // TODO: implement the main method here
        FileExplorer fExplorer = new FileExplorer(folder);
        EncodingSelector eSelector = new EncodingSelector();
        FileReaderWriter fReaderWriter = new FileReaderWriter();
        Transformer transformer = new Transformer(newName, wordsPerLine);

        while (true) {
            try {
                //Récupère le prochain fichier ou quitte le programme s'il n'y en a plus aucun
                File file = fExplorer.getNewFile();
                if(file == null){
                    System.out.println("Plus aucun fichier à lire!");
                    System.exit(0);
                }

                //Récupère le charset et passe le fichier s'il n'est pas reconnu
                Charset charset = eSelector.getEncoding(file);
                if(charset == null){
                    continue;
                }

                //Lit le contenu et le transforme
                String content = fReaderWriter.readFile(file, charset);
                StringBuilder sb = new StringBuilder(transformer.replaceChuck(content));
                sb.append("\n" + transformer.capitalizeWords(content));
                sb.append("\n" + transformer.wrapAndNumberLines(content));

                //Crée le nouveau fichier et écrit le contenu
                File newFile = new File(file.getAbsolutePath() + ".processed");
                fReaderWriter.writeFile(newFile, sb.toString(), StandardCharsets.UTF_8);
        

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}

