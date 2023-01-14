package utils;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils {
    private static final String basePath = "src/main/resources";

    public static File getFile(@NotNull String path) throws FileNotFoundException {
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.getName() + " does not exist! Check if your path is correct");
        }

        return file;
    }

    public static File createAndGetFile(@NotNull String path) {
        File file = new File(path);

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return file;
    }

    public static String getFullPath(String sub) {
        return basePath + sub;
    }
}
