package utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils {
    @Contract("null -> fail")
    public static @NotNull File getFile(String path) throws FileNotFoundException {
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.getName() + " does not exist! Check if your path is correct");
        }

        return file;
    }

    @Contract("null -> fail")
    public static @NotNull File createAndGetFile(String path) {
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
}
