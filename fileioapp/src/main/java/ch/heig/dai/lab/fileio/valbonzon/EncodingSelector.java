package ch.heig.dai.lab.fileio.valbonzon;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

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
        if(!file.getName().contains(".")){
            return null;
        }

        //Get only the text after the last dot.
        String extension = getExtension(file);

        switch(extension){

            case "utf8":
                return StandardCharsets.UTF_8;
            case "txt":
                return StandardCharsets.US_ASCII;
            case "utf16be":
                return StandardCharsets.UTF_16BE;
            case "utf16le":
                return StandardCharsets.UTF_16LE;
            default:
                return null;

        }

        
    }
    public String getExtension(File file){
        Optional<String> extension = Optional.ofNullable(file.getName())
        .filter(f -> f.contains("."))
        .map(f -> f.substring(file.getName().lastIndexOf(".") + 1));
        
        return extension.get();
    }
}