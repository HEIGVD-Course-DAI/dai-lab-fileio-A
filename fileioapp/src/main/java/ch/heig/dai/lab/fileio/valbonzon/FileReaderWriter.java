package ch.heig.dai.lab.fileio.valbonzon;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.

        try (var reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), encoding))){

            String content = new String();
            String line;
            while((line = reader.readLine()) != null){
                content += line + "\n";
            }
            return content;

        } catch (Exception e) {
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
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to flush the data and close the streams and readers at the end.
        

        try (var writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()),encoding));){
            
            try {
                writer.write(content);
            } catch (Exception e) {
                return false;
            }
            return true;

        } catch (Exception e) {
            return false;
        }

        
    }
}
