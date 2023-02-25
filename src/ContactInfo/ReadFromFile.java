package ContacInfo;

import java.io.*;
import java.io.File;

public class ReadFromFile {
    File path = new File("info.txt");

    public ReadFromFile() {
        readFromFile();
    }

    private void readFromFile() {
        try {
            FileReader read = new FileReader(path);
            BufferedReader br = new BufferedReader(read);
            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);
        } catch (IOException e) {
            System.out.println("Invalid path!");
        }
    }
}
