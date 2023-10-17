package ch.heig.dai.lab.fileio.JulienHolzer;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class EncodingSelector {

    private Map<String, Charset> extensionToCharsetMap;

    public EncodingSelector() {
        extensionToCharsetMap = new HashMap<>();
        // Add recognized extensions and their corresponding charsets
        extensionToCharsetMap.put("utf8", Charset.forName("UTF-8"));
        extensionToCharsetMap.put("txt", Charset.forName("US-ASCII"));
        extensionToCharsetMap.put("utf16be", Charset.forName("UTF-16BE"));
        extensionToCharsetMap.put("utf16le", Charset.forName("UTF-16LE"));
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
        String fileName = file.getName();
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex != -1) {
            String fileExtension = fileName.substring(lastDotIndex + 1).toLowerCase();
            Charset charset = extensionToCharsetMap.get(fileExtension);
            return charset;
        }
        return null;
    }
}