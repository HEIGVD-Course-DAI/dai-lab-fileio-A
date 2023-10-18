package ch.heig.dai.lab.fileio.StefBianchet;

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
        try (Reader reader = new FileReader(file,encoding)){

            String content = "";
            int c;

            while ((c = reader.read()) != -1){
                String str = content;
                content = str + (char) c;
            }

            reader.close();

            return  content;
        }catch (IOException e){
            System.out.println("Exception: " + e);
        }
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.
        return null;
    }

    /**
     * Write the content to a file with a given encoding. 
     * @param file the file to write to
     * @param content the content to write
     * @param encoding the encoding to use
     * @return true if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file, String content, Charset encoding) {
        try (Writer writer = new FileWriter(file,encoding)){
            writer.write(content);

            writer.flush();
            writer.close();

            return true;

        }catch (IOException e){
            System.out.println("Exception: " + e);
        }
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to flush the data and close the streams and readers at the end.
        return false;
    }
}
