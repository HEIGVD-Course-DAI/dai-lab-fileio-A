package ch.heig.dai.lab.fileio.JustinFerrara14;

import java.io.*;
import java.io.File;
import java.nio.charset.Charset;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.

        try(var is = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))){

            var content = new StringBuilder();
            String line;

            while((line = is.readLine()) != null){
                content.append(line);
            }

            is.close();
            return content.toString();

        } catch (IOException e) {
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

        try(var os = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding))){
            os.write(content, 0, content.length());
            os.flush();
            os.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
