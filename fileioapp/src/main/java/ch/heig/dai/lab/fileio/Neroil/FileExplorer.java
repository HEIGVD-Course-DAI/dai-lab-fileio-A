package ch.heig.dai.lab.fileio.Neroil;

import java.io.File;
import java.util.HashSet;

public class FileExplorer {
    private final File folder;
    private HashSet<File> knownFiles;

    /**
     * Constructor
     * Memorize the folder to explore and initialize the set of known files.
     * @param folder
     */
    public FileExplorer(String folder) {
        this.folder = new File(folder);
        this.knownFiles = new HashSet<File>();
    }

    /**
     * Get a single new file from the folder.
     * The file must not have been returned before.
     * Use the java.io.file API to get the list of files in the folder.
     * Use the HashSet knownFiles to keep track of the files that have already been returned.
     * @return a new file, or null if there is no new file
     */
    public File getNewFile() {

        File[] listOfFile = folder.listFiles();

        if (listOfFile == null) return null;

        for (File file : listOfFile){

            if (!knownFiles.contains(file)){ //If we find an unused file, add it to the hash
                                             // and return the file
                knownFiles.add(file);

                return file;
            }
        }

        //If we don't find any unused files, return null
        return null;
    }
}