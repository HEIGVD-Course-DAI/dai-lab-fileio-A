package ch.heig.dai.lab.fileio.AlejandroSta;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

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
        // TODO: implement the method body here
        List<String> extensions = Arrays.asList("utf8", "txt", "utf16be", "utf16le");
        Charset[] encoders = {StandardCharsets.UTF_8, StandardCharsets.US_ASCII, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE};
        String[] split = file.getName().split("\\.");
        int index = extensions.indexOf(split[split.length - 1]);
        if(index == -1){
            return null;
        }else{
            return encoders[index];
        }
    }
}