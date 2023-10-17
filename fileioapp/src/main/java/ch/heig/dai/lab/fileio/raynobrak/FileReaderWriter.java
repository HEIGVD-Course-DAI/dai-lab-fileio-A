package ch.heig.dai.lab.fileio.raynobrak;

import java.io.*;
import java.nio.charset.Charset;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {
        var text = new String();
        try {
            var bis = new BufferedInputStream(new FileInputStream(file));
            var reader = new BufferedReader(new InputStreamReader(bis, encoding));

            var line = new String();
            while((line = reader.readLine()) != null) {
                text += line;
            }

            bis.close();
            reader.close();
        }
        catch(Exception exception) {
            return null;
        }

        return text;
    }

    /**
     * Write the content to a file with a given encoding. 
     * @param file the file to write to
     * @param content the content to write
     * @param encoding the encoding to use
     * @return true if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file, String content, Charset encoding) {
        try {
            var bos = new BufferedOutputStream(new FileOutputStream(file));
            var writer = new BufferedWriter(new OutputStreamWriter(bos, encoding));

            writer.write(content);

            writer.flush();
            bos.flush();

            bos.close();
            writer.close();
        }
        catch(Exception exception) {
            return false;
        }

        return true;
    }
}
