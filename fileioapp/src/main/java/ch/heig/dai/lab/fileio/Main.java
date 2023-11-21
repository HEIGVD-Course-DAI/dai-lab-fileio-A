package ch.heig.dai.lab.fileio;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

// *** TODO: Change this to import your own package ***
import ch.heig.dai.lab.fileio.GLK.EncodingSelector;
import ch.heig.dai.lab.fileio.GLK.FileExplorer;
import ch.heig.dai.lab.fileio.GLK.FileReaderWriter;
import ch.heig.dai.lab.fileio.GLK.Transformer;
import ch.heig.dai.lab.fileio.GLK.*;

public class Main {
    // *** TODO: Change this to your own name ***
    private static final String newName = "Leonard";

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

        //permet de connaître le nombre de mots par ligne.
        int wordsPerLine = Integer.parseInt(args[1]);
        System.out.println("Application started, reading folder " + folder + "...");
        // TODO: implement the main method here

        FileExplorer fileExplorer = new FileExplorer(folder);
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        EncodingSelector encodingSelector = new EncodingSelector();
        Transformer transformer = new Transformer(newName, wordsPerLine);


        while (true) {
            try {
                // TODO: loop over all files
                File file = fileExplorer.getNewFile();
                if(file == null) {
                    System.out.println("no files found");
                    break;
                }


                Charset encoding = encodingSelector.getEncoding(file);
                if(encoding == null) {
                    System.out.println("not the right encoding");
                    continue;
                }

                String content = fileReaderWriter.readFile(file, encoding);
                if(content == null) {
                    System.out.println("cannot read file ");
                    continue;
                }

                content = transformer.capitalizeWords(content);
                content = transformer.replaceChuck(content);
                content = transformer.wrapAndNumberLines(content);

                File result = new File(file + ".processed");
                boolean hasWritten = fileReaderWriter.writeFile(result, content, encoding);
                if(hasWritten){
                    System.out.println(result.getName() + " file was not written");
                } else {
                    System.out.println(result.getName() + " file was written correctly");
                }


            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}

