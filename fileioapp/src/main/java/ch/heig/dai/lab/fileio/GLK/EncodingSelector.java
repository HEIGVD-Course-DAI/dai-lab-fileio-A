package ch.heig.dai.lab.fileio.GLK;

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
        // TODO: implement the method body here
        int point = file.getName().lastIndexOf(('.'));
        if(point == -1 || file == null) {
            return null;
        }
        String endOfFile =  file.getName().substring(point);
        Charset charset;


        switch(endOfFile) {
            case ".txt" :
                charset = StandardCharsets.US_ASCII;
                break;

            case ".utf8" :
                charset = StandardCharsets.UTF_8;
                break;

            case ".utf16be" :
                charset = StandardCharsets.UTF_16BE;
                break;

            case ".utf16le" :
                charset = StandardCharsets.UTF_16LE;
                break;

            default :
                System.out.println("cannot find encoding format");
                return null;
            }
        return charset;
        }

    }

