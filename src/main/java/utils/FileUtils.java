package utils;

import java.io.File;
import java.nio.file.Files;

public class FileUtils {

    private FileUtils(){
        super();
    }

    public static File getLatestFileInDirectory(String directory){
        File fileDirectory = new File(directory);
        // check if there is no directory
        if (!fileDirectory.exists() || !fileDirectory.isDirectory()){
            LogsManager.error("there is no directory");
            return null;
        }

        // get all the files to check the latest modified

        File[] allFiles = fileDirectory.listFiles();

        // check if there are files or not
        if (allFiles.length == 0 || allFiles == null){
            LogsManager.warn("there are no files ");
            return null;
        }

        File latestFile = null;
        long latestModified = Long.MIN_VALUE;

        for (File file : allFiles) {
            if (file.isFile() && file.lastModified() > latestModified) {
                latestModified = file.lastModified();
                latestFile = file;
            }
            if (latestFile != null) {
                LogsManager.info("latest file found in " + latestFile.getAbsolutePath());
            } else {
                LogsManager.warn("no valid files were found");
            }

        }
        return latestFile;
    }
}
