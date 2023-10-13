package ch.heig.dai.lab.fileio.kdemont;

import java.io.File;
import java.nio.charset.Charset;

public class EncodingSelector {

    /**
     * Get the encoding of a file based on its extension.
     * The following extensions are recognized:
     *   - .utf8:    UTF-8
     *   - .txt:     US-ASCII
     *   - .utf16be: UTF-16BE
     *   - .utf16le: UTF-16LE
     *
     * @param file the file to get the encoding from
     * @return the encoding of the file, or null if the extension is not recognized
     */
    public Charset getEncoding(File file) {
        String fileName = file.getName();
        //  Get the file extension
        String fileExtension = getFileExtension(fileName);

        // Check the file extension and return the corresponding encoding
        if (fileExtension.equalsIgnoreCase("utf8")) {
            return Charset.forName("UTF-8");
        } else if (fileExtension.equalsIgnoreCase("txt")) {
            return Charset.forName("US-ASCII");
        } else if (fileExtension.equalsIgnoreCase("utf16be")) {
            return Charset.forName("UTF-16BE");
        } else if (fileExtension.equalsIgnoreCase("utf16le")) {
            return Charset.forName("UTF-16LE");
        } else {
            // If the extension is not recognised, return null
            return null;
        }
    }

    private String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex != -1) {
            return fileName.substring(lastDotIndex + 1);
        } else {
            return ""; // If no extension is found, return an empty string
        }
    }
}