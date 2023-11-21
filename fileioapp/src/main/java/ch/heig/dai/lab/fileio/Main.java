package ch.heig.dai.lab.fileio;

import java.io.File;

// *** TODO: Change this to import your own package ***
import ch.heig.dai.lab.fileio.nathanrayburn.*;

public class Main {
    // *** TODO: Change this to your own name ***
    private static final String newName = "nathanrayburn";

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

        FileExplorer dir = new FileExplorer(folder);
        EncodingSelector encoding = new EncodingSelector();
        FileReaderWriter fileRW = new FileReaderWriter();
        Transformer transformer = new Transformer(newName, wordsPerLine);
        while (true) {
            try {
                File file =  dir.getNewFile();
                if(file==null) {
                    System.out.println("No more files to process\n");
                    break;
                }

                if(encoding.getEncoding(file) == null) {
                    System.out.println("Unsupported file format for file : " + file.getName());
                    continue;
                }

                String content = fileRW.readFile(file,encoding.getEncoding(file));

                if (content == null) {
                    System.out.println("Error reading file: " + file.getName());
                    continue;
                }

                String convertedContent = transformer.replaceChuck(content);

                convertedContent = transformer.capitalizeWords(convertedContent);
                convertedContent = transformer.wrapAndNumberLines(convertedContent);

                File output = new File(file.getAbsolutePath() + ".processed");

                boolean isFileWritten = fileRW.writeFile(output,convertedContent,encoding.getEncoding(file));
                if (isFileWritten) {
                    System.out.println("Processed and wrote to : " + output.getName());
                } else {
                    System.out.println("Failed to write to : " + output.getName());
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}

