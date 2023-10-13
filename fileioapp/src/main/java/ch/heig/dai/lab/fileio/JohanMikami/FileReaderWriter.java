package ch.heig.dai.lab.fileio.JohanMikami;

import java.io.*;
import java.nio.charset.Charset;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding charset
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.
        try(Reader reader = new FileReader(file.getAbsolutePath(), encoding)){
            int c = -1;
            StringBuilder str = new StringBuilder();
            while ((c = reader.read()) != -1) {
                str.append((char)c);
            }
            if (str.isEmpty())
                return null;
            return str.toString();
        }catch (IOException e){
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
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to flush the data and close the streams and readers at the end.
        try(Writer writer = new FileWriter(file.getAbsolutePath(), encoding)){
            writer.write(content, 0, content.length());
            writer.flush();
            return true;
        }catch(IOException e){
            return false;
        }
    }
}
