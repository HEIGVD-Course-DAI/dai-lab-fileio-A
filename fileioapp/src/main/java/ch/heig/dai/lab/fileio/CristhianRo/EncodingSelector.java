package ch.heig.dai.lab.fileio.CristhianRo;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class EncodingSelector {


    private static final Map<String, Charset> EXTENSION_TO_CHARSET = new HashMap<>();

    static {
        EXTENSION_TO_CHARSET.put("utf8", Charset.forName("UTF-8"));
        EXTENSION_TO_CHARSET.put("txt", Charset.forName("US-ASCII"));
        EXTENSION_TO_CHARSET.put("utf16be", Charset.forName("UTF-16BE"));
        EXTENSION_TO_CHARSET.put("utf16le", Charset.forName("UTF-16LE"));
    }



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
        // TODO: implement the method body here
        if (file == null) {
            return null;
        }

        String fileName = file.getName();
        int extension = fileName.lastIndexOf('.');

        if (extension == -1) {
            return null;  // There's no extension
        }

        String encoding = fileName.substring(extension + 1).toLowerCase();
        return EXTENSION_TO_CHARSET.get(encoding);
    }
}