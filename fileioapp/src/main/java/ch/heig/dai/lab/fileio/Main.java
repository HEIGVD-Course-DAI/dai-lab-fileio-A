package ch.heig.dai.lab.fileio;

import java.io.File;
import java.nio.charset.Charset;

// *** TODO: Change this to import your own package ***
import ch.heig.dai.lab.fileio.Tobi2o.*;

public class Main {
    // *** TODO: Change this to your own name ***
    private static final String newName = "Tobi2o";

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
        if (args.length != 2 || !new File(args[0]).isDirectory()) {
            System.out.println("You need to provide two command line arguments: an existing folder and the number of words per line.");
            System.exit(1);
        }

        String folder = args[0];
        int wordsPerLine = Integer.parseInt(args[1]);

        FileExplorer fileExplorer = new FileExplorer(folder);
        EncodingSelector encodingSelector = new EncodingSelector();
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        Transformer transformer = new Transformer(newName, wordsPerLine);

        System.out.println("Application started, reading folder " + folder + "...");

        while (true) {
            try {
                // Loop over all files in the directory
                File file = fileExplorer.getNewFile();
                if (file == null) {
                    System.out.println("No more files to process.");
                    break;
                }


                if (encodingSelector.getEncoding(file) == null) {
                    System.out.println("Unsupported file format for file: " + file.getName());
                    continue; // skip processing this file and move on to the next one
                }

                String content = fileReaderWriter.readFile(file, encodingSelector.getEncoding(file));

                if (content == null) {
                    System.out.println("Error reading file: " + file.getName());
                    continue;
                }

                // Transform the content
                String transformedContent = transformer.replaceChuck(content);
                transformedContent = transformer.capitalizeWords(transformedContent);
                transformedContent = transformer.wrapAndNumberLines(transformedContent);

                // Write the result back to the file with a ".processed" suffix
                File outFile = new File(file.getAbsolutePath() + ".processed");
                boolean isSuccess = fileReaderWriter.writeFile(outFile, transformedContent, encodingSelector.getEncoding(file));
                if (isSuccess) {
                    System.out.println("Processed and wrote to: " + outFile.getName());
                } else {
                    System.out.println("Failed to write to: " + outFile.getName());
                }

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}