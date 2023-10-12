package ch.heig.dai.lab.fileio.Neroil;

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

        try (var fis            = new FileInputStream   (file);
             var reader         = new InputStreamReader (fis, encoding);
             var bufferedReader = new BufferedReader    (reader)) {

            StringBuilder fileContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                fileContent.append(line).append("\r\n");
            }

            reader.close();
            bufferedReader.close();

            return fileContent.toString();

        } catch (IOException e) {
            System.out.println("Exeption: " + e);
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

        try (var bos            = new FileOutputStream  (file);
             var writer         = new OutputStreamWriter(bos,encoding);
             var bufferedWriter = new BufferedWriter    (writer)){

            bufferedWriter.write(content);
            bufferedWriter.flush();

        } catch (IOException e) {
        System.out.println("Exeption: " + e);
        return false;
    }
        return true;
    }
}
