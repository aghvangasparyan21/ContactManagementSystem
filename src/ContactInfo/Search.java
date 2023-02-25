package ContacInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Search {
    File path = new File("info.txt");
    private Scanner sc = new Scanner(System.in);
    public Search(int id, String name, String surname, String number, String mail, String address) {
        doSearching(id, name, surname, number, mail, address);
    }

    private void doSearching(int id, String name, String surname, String number, String mail, String address) {
        int count = 0;
        System.out.print("Enter fullname: ");
        String info = sc.nextLine();
        String[] temporary = info.split(" ");
        temporary[0] = temporary[0].substring(0, 1).toUpperCase() + temporary[0].substring(1).toLowerCase();
        temporary[1] = temporary[1].substring(0, 1).toUpperCase() + temporary[1].substring(1).toLowerCase();
        String tmpInfo = (" " + "name:" + " " + temporary[0] + " " + "surname:" + " " + temporary[1] + " ");
        String currentLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((currentLine = br.readLine()) != null) {
                String[] infoForDeleted = currentLine.split("//");
                if (infoForDeleted.length > 1) {
                    System.out.println("There is no such a user!");
                    return;
                }
                String[] tmp = currentLine.split("/");
                if (tmp[1].equals(tmpInfo)) {
                    System.out.println(currentLine);
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        if (count == 0) {
            System.out.println("There is no such a user!");
        }
    }
}
