package ch.heig.dai.lab.fileio.AndreCostaaa;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;

public class EncodingSelector {

    private final HashMap<String, Charset> extensionToCharsetMap = new HashMap<String, Charset>() {
        {
            put(".utf8", Charset.forName("UTF-8"));
            put(".txt", Charset.forName("US-ASCII"));
            put(".utf16be", Charset.forName("UTF-16BE"));
            put(".utf16le", Charset.forName("UTF-16LE"));
        }
    };

    private final char EXTENSION_SEPARATOR = '.';

    /**
     * Gets the file extension of a file
     * 
     * @param fileName
     * @return the file extension or null if the file has no extension
     */
    private String getFileExtension(File file) {

        final String fileName = file.getName();

        if (fileName.indexOf(EXTENSION_SEPARATOR) == -1)
            return null;

        return fileName.substring(fileName.lastIndexOf(EXTENSION_SEPARATOR));
    }

    /**
     * Get the encoding of a file based on its extension.
     * The following extensions are recognized:
     * - .utf8: UTF-8
     * - .txt: US-ASCII
     * - .utf16be: UTF-16BE
     * - .utf16le: UTF-16LE
     * 
     * @param file the file to get the encoding from
     * @return the encoding of the file, or null if the extension is not recognized
     */
    public Charset getEncoding(File file) {

        final String fileExtension = getFileExtension(file);
        if (fileExtension == null) {
            return null;
        }
        return extensionToCharsetMap.get(fileExtension);
    }
}