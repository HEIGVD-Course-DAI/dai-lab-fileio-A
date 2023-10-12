package ch.heig.dai.lab.fileio.michaelstrefeler;

import java.io.*;
import java.nio.charset.Charset;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))){
            StringBuilder contents = new StringBuilder();
            int c; // is -1 if end of file or char value 0-65535
            while ((c = reader.read()) != -1) contents.append(c);
            reader.close();
            return contents.toString();
        }catch (IOException e) {
            return null;
        }
    }

    /**
     * Write the content to a file with a given encoding. 
     * @param file the file to write to
     * @param content the content to write
     * @param encoding the encoding to use
     * @return true if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file, String content, Charset encoding) {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding))){
            writer.write(content, 0, content.length());
            writer.flush();
            writer.close();
            return readFile(file, encoding).isEmpty();
        }catch (IOException e) {
            return false;
        }
    }
}
