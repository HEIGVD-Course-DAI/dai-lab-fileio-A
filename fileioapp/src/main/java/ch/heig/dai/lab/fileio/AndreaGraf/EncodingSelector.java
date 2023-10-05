package ch.heig.dai.lab.fileio.AndreaGraf;

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
        if (file == null) {
            return null;
        }

        String fileName = file.getName();

        if (fileName.endsWith(".utf8"))
            return Charset.forName("UTF-8");

        if (fileName.endsWith(".txt"))
            return Charset.forName("US-ASCII");

        if (fileName.endsWith(".utf16be"))
            return Charset.forName("UTF-16BE");

        if (fileName.endsWith(".utf16le"))
            return Charset.forName("UTF-16LE");

        return null;

    }
}