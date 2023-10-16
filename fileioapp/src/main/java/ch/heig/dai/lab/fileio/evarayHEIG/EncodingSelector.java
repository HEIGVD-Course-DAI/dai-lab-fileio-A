package ch.heig.dai.lab.fileio.evarayHEIG;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.SortedMap;
import java.util.TreeMap;

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
        // map that links an extension to a charset
        SortedMap<String, Charset> extensionToCharset = new TreeMap<>();

        // add possible extensions
        extensionToCharset.put(".utf8", StandardCharsets.UTF_8);
        extensionToCharset.put(".txt", StandardCharsets.US_ASCII);
        extensionToCharset.put(".utf16be", StandardCharsets.UTF_16BE);
        extensionToCharset.put(".utf16le", StandardCharsets.UTF_16LE);

        for(String key : extensionToCharset.keySet()){
            if(file.getName().endsWith(key)){
                return extensionToCharset.get(key);
            }
        }

        return null;
    }
}