import task1.*;
import task2.*;
import task3.*;
import utils.FileUtils;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new PhoneReader(FileUtils.getFullPath("/task-1/file.txt"))
                .run(new PhoneValidator());

        var users = new UserBuilder(FileUtils.getFullPath("/task-2/file.txt"))
                .build();

        new JsonWriter(FileUtils.getFullPath("/task-2/user.json"))
                .writeToFile(users);

        var words = WordsOrderUtils.sort(
                new WordsFrequency(FileUtils.getFullPath("/task-3/words.txt")).count()
        );

        System.out.println(words);
    }
}
