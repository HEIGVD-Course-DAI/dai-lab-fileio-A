package ch.heig.dai.lab.fileio;

import java.io.File;
import java.nio.charset.Charset;

// *** TODO: Change this to import your own package ***
import ch.heig.dai.lab.fileio.Tasticoco.*;

public class Main {
    // *** TODO: Change this to your own name ***
    private static final String newName = "Arthur Junod";

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

        FileExplorer fileExplorer = new ch.heig.dai.lab.fileio.Tasticoco.FileExplorer(folder);
        EncodingSelector encodingSelector = new ch.heig.dai.lab.fileio.Tasticoco.EncodingSelector();
        FileReaderWriter fileReaderWriter = new ch.heig.dai.lab.fileio.Tasticoco.FileReaderWriter();
        Transformer transformer = new Transformer(newName, wordsPerLine);

        while (true) {
            try {
                // TODO: loop over all files
                File fileToProcess = fileExplorer.getNewFile();
                if(fileToProcess == null) break;

                Charset encoding = encodingSelector.getEncoding(fileToProcess);
                if(encoding == null) continue;

                String content = fileReaderWriter.readFile(fileToProcess, encoding);
                if(content == null) continue;

                String processedContent =
                        transformer.wrapAndNumberLines(transformer.capitalizeWords(transformer.replaceChuck(content)));

                fileReaderWriter.writeFile(new File(fileToProcess.getAbsolutePath() + ".processed"),
                        processedContent, Charset.forName("UTF-8"));

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}

