package task1;

import utils.FileUtils;

import java.io.*;

public class PhoneReader {
    private String path;

    public PhoneReader setPath(String path) {
        this.path = path;
        return this;
    }

    public void run(Validator validator) throws FileNotFoundException {
        File file = FileUtils.getFile(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                validator.printIfValid(line);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
