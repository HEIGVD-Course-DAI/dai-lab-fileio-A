package ch.heig.dai.lab.fileio.Tasticoco;

import java.io.*;
import java.nio.charset.Charset;

// #387
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
        StringBuilder readString = new StringBuilder();
        try {
            var is = new BufferedReader(new InputStreamReader(new FileInputStream(file.getName()), encoding));

            while(is.readLine() != null){
                readString.append(is.readLine()).append("\n");
            }

            is.close();

        }catch(IOException e){
            System.out.println("IOException: " + e);
            return null;
        }

        return readString.toString();
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
            var os = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getName()), encoding));

            os.write(content);

            os.flush();
            os.close();

        }catch(IOException e){
            System.out.println("IOException: " + e);
            return false;
        }

        return true;
    }
}
