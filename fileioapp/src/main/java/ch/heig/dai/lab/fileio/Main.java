package ch.heig.dai.lab.fileio;

import java.io.File;

// *** TODO: Change this to import your own package ***
import ch.heig.dai.lab.fileio.kevinAuberson.*;

import javax.swing.*;

public class Main {
    // *** TODO: Change this to your own name ***
    private static final String newName = "Kevin Auberson";

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
        FileExplorer explorer = new FileExplorer(folder);
        EncodingSelector encoding = new EncodingSelector();
        FileReaderWriter fileRW = new FileReaderWriter();
        Transformer transformer = new Transformer(newName,wordsPerLine);

        while (true) {
            try {
                File file = explorer.getNewFile();
                if(file == null){
                    System.out.println("No more file in the directory");
                    break;
                }

                if(encoding.getEncoding(file) == null){
                    System.out.println("Unsupported file encoding for : " + file.getName());
                    continue;
                }

                String fileContent = fileRW.readFile(file, encoding.getEncoding(file));
                if(fileContent == null){
                    System.out.println("Error on reading the file : " + file.getName());
                    continue;
                }

                String convertedFileContent = transformer.replaceChuck(fileContent);
                convertedFileContent = transformer.capitalizeWords(convertedFileContent);
                convertedFileContent = transformer.wrapAndNumberLines(convertedFileContent);

                File outputFile = new File(file.getAbsolutePath() + ".processed");

                boolean writeFile = fileRW.writeFile(outputFile,convertedFileContent,encoding.getEncoding(file));
                if (writeFile) {
                    System.out.println("Processed! write in : " + outputFile.getName());
                } else {
                    System.out.println("Failed! to write in : " + outputFile.getName());
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}

