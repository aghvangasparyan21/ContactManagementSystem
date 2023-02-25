package ContacInfo;

import java.io.*;
import java.io.File;

public class GenerateId {
    static int id;
    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }
    int theLastId(File path) {
        String sCurrentLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            if (isFileEmpty(path)) {
                this.id = 1;
                return this.id;
            } else {
                String lastLine = "";
                while ((sCurrentLine = br.readLine()) != null) {
                    lastLine = sCurrentLine;
                }
                String[] str = lastLine.split(" ");
                int x = Integer.parseInt(str[1]);
                return ++x;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return this.id;
    }
}
