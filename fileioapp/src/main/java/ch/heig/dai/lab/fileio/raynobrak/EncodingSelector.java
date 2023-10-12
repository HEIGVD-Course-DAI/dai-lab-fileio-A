package ch.heig.dai.lab.fileio.raynobrak;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;

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
        String filename = file.getName();
        var index = filename.lastIndexOf('.');
        if(index == -1)
            return null;
        var ext = filename.substring(index);
        
        if(ext.equals(".utf8"))
            return StandardCharsets.UTF_8;
        else if(ext.equals(".txt"))
            return StandardCharsets.US_ASCII;
        else if(ext.equals(".utf16be"))
            return StandardCharsets.UTF_16BE;
        else if(ext.equals(".utf16le"))
            return StandardCharsets.UTF_16LE;
            
        return null;
    }
}