package ch.heig.dai.lab.fileio;

import java.io.File;
import java.nio.charset.StandardCharsets;

import ch.heig.dai.lab.fileio.raynobrak.*;

public class Main {
    private static final String newName = "Lucas Charbonnier";

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

        // Create objects
        FileExplorer explorer = new FileExplorer(folder);
        EncodingSelector selector = new EncodingSelector();
        FileReaderWriter readerWriter = new FileReaderWriter();
        Transformer transformer = new Transformer(newName, wordsPerLine);

        while (true) {
            try {
                // for each new file...
                File f;
                while((f = explorer.getNewFile()) != null) {
                    // get the encoding
                    var encoding = selector.getEncoding(f);
                    if(encoding == null)
                        continue;

                    // read the content
                    var content = readerWriter.readFile(f, encoding);

                    // transform content
                    content = transformer.replaceChuck(content);
                    content = transformer.capitalizeWords(content);
                    content = transformer.wrapAndNumberLines(content);

                    // save file in UTF-8 and add ".processed" to name

                    String resultingPath = f.getPath() + ".processed";
                    readerWriter.writeFile(new File(resultingPath), content, StandardCharsets.UTF_8);
                }

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}
