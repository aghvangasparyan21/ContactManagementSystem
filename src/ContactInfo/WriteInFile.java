package ContacInfo;

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInFile {
    File path = new File("info.txt");

    public WriteInFile(String name, String surname, String number, String mail, String address, int id) {
        writeToFile(name, surname, number, mail, address, id);
    }

    private void writeToFile(String name, String surname, String number, String mail, String address, int id) {
        try {
            FileWriter wr = new FileWriter(path, true);
            BufferedWriter out = new BufferedWriter(wr);
            out.write("id: " + id + " " + "/" + " " + "name:" + " " + name + " " + "surname:" + " " + surname + " " + "/" + " " + "phonenumber:" + " " + number + " " + "mail:" + " " + mail + " " + "address:" + " " + address + "\n");
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
