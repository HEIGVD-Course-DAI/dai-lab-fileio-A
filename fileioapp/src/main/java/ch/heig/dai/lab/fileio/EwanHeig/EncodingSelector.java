package ch.heig.dai.lab.fileio.EwanHeig;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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
        String name = file.getName();
        int point = name.lastIndexOf(".");

        String extension = name.substring(point+1);

        if(extension.equals("utf8")){
            return StandardCharsets.UTF_8;
        } else if (extension.equals("txt")) {
            return StandardCharsets.US_ASCII;
        }else if (extension.equals("utf16be")) {
            return StandardCharsets.UTF_16BE;
        }else if (extension.equals("utf16le")) {
            return StandardCharsets.UTF_16LE;
        }

        return null;
    }
}