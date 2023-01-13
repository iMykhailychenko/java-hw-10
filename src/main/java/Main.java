import task1.*;
import task2.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final String basePath = "src/main/resources";

        new PhoneReader()
                .setPath(basePath + "/task-1/file.txt")
                .run(new PhoneValidator());

        var users = new UserBuilder()
                .setPath(basePath + "/task-2/file.txt")
                .build();

        new JsonWriter()
                .setPath(basePath + "/task-2/user.json")
                .writeToFile(users);
    }
}
