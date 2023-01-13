package task2;

import com.google.gson.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import utils.FileUtils;

import java.io.*;

public class JsonWriter implements JsonFileWriter {
    private String path;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public JsonWriter setPath(String path) {
        this.path = path;
        return this;
    }

    @Override
    public void writeToFile(@NotNull Object obj) {
        String json = gson.toJson(obj);
        File file = FileUtils.createAndGetFile(path);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(json, 0, json.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
