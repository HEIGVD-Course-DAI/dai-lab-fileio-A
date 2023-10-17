package ch.heig.dai.lab.fileio.GLK;

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
    public String readFile(File file, Charset encoding) throws IOException {
        // TODO: Implement the method body here.
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.

        //creation of a new BufferedReader to be able to read the file with the right encoding.
        try {
            StringBuilder fileBuilder = new StringBuilder();
            String currentLine;
            var readingFile = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            while ((currentLine = readingFile.readLine()) != null) {
                    fileBuilder.append(readingFile).append('\n');
            }

        } catch(IOException e) {
            return null;
        }
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
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to flush the data and close the streams and readers at the end.
        try {
            var writerFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
            writerFile.write(content);
            writerFile.flush();
            writerFile.close();

        }catch(IOException e) {
            return false;
        }
        return false;
    }
}
