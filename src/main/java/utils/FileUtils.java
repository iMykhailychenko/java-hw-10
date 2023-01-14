package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils {
    private static final String basePath = "src/main/resources";

    public static File getFile(String path) throws FileNotFoundException {
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.getName() + " does not exist! Check if your path is correct");
        }

        return file;
    }

    public static File createAndGetFile(String path) {
        File file = new File(path);

        try {
            String message = file.createNewFile() ? "File " + file.getName() + " created" : "File " + file.getName() + " updated";
            System.out.println(message);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return file;
    }

    public static String getFullPath(String sub) {
        return basePath + sub;
    }
}
