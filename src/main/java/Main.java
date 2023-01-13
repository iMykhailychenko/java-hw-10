import task1.PhoneReader;
import task1.PhoneValidator;
import task2.UserBuilder;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final String basePath = "src/main/resources";

        new PhoneReader().setPath(basePath + "/task-1/file.txt").run(new PhoneValidator());

        new UserBuilder().setFilePath(basePath + "/task-2/file.txt").setJsonPath(basePath + "/task-2/user.json").run();
    }
}
