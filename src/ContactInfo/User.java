package ContacInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class User {
    private String name;
    private String surname;
    private String number;
    private String mail;
    private String address;
    private int id;
    File path = new File("info.txt");
    private Scanner sc = new Scanner(System.in);
    public User() {}

    public User(String tmpName, String tmpSurName, String tmpNumber, String tmpMail, String tmpAddress, int tmpId) {
        this.name = tmpName;
        this.surname = tmpSurName;
        this.number = tmpNumber;
        this.mail = tmpMail;
        this.address = tmpAddress;
        this.id = tmpId;
        String uniqueUser = (" " + "name:" + " " + this.name + " " + "surname:" + " " + this.surname + " " + "/" + " " + "phonenumber:" + " " + this.number + " " + "mail:" + " " + this.mail + " " + "address:" + " " + this.address);
        int idForStatus = idForUpdate((uniqueUser + " //status: deleted"), this.id);
        String deletedUser = ("id: " + idForStatus  + " /" + " name:" + " " + this.name + " " + "surname:" + " " + this.surname + " " + "/" + " " + "phonenumber:" + " " + this.number + " " + "mail:" + " " + this.mail + " " + "address:" + " " + this.address + " //status: deleted");
       if (checkIfDeletedOrNot(deletedUser)) {
           System.out.println("");
           System.out.println("This is about user");
           System.out.println("This is username: " + this.name);
           System.out.println("This is surname: " + this.surname);
           System.out.println("This is phone number: " + this.number);
           System.out.println("This is e-mail: " + this.mail);
           System.out.println("This is address: " + this.address);
           System.out.print("Do you want to save this info, enter yes or no? ");
           String inst = sc.nextLine();
           inst = inst.toLowerCase();
           if (inst.equals("yes")) {
               new updateDeleted(deletedUser, idForUpdate(deletedUser, this.id));
               return;
           }
           else return;
       }
        if (checkUniqueUser(uniqueUser)) {
            printing();
        } else {
            int tempId = idForUpdate(uniqueUser, this.id);
            System.out.print("User is already existed. Do you want to update or delete. Enter the operation: ");
            String operation = sc.nextLine();
            if (operation.equals("update")) {
                System.out.print("Enter the field which you want to change: ");
                String field = sc.nextLine();
                new Update(field, tempId);
            }
            else if (operation.equals("delete")) {
                new Delete(tempId);
            }
        }
    }

    public void search() {
        new Search(this.id, this.name, this.surname, this.number, this.mail, this.address);
    }

    private boolean checkUniqueUser(String uniqueUser) {
        String currentLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((currentLine = br.readLine()) != null) {
                String[] tmp = currentLine.split("/", 2);
                if (tmp[1].equals(uniqueUser)) {
                    System.out.println(currentLine);
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return true;
    }
    private boolean checkIfDeletedOrNot(String deletedUser) {
        String currentLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.equals(deletedUser)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

    private int idForUpdate(String uniqueUser, int id) {
        String currentLine = "";
        int tempId = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((currentLine = br.readLine()) != null) {
                String[] tmp = currentLine.split("/", 2);
                String[] tmp1 = tmp[0].split(":");
                String[] tmp2 = tmp1[1].split(" ");
                if (tmp[1].equals(uniqueUser)) {
                    tempId = Integer.parseInt(tmp2[1]);
                    return tempId;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return id;
    }

    private void printing() {
        System.out.println("");
        System.out.println("This is about user");
        System.out.println("This is username: " + this.name);
        System.out.println("This is surname: " + this.surname);
        System.out.println("This is phone number: " + this.number);
        System.out.println("This is e-mail: " + this.mail);
        System.out.println("This is address: " + this.address);
        System.out.println("Do you want to save this info, enter yes or no?");
        String saveOrNot = sc.nextLine();
        infoToFile(saveOrNot);
    }

    private void infoToFile(String yesOrNo) {
        yesOrNo = yesOrNo.toLowerCase();
        if (yesOrNo.equals("yes")) {
            WriteInFile write = new WriteInFile(this.name, this.surname, this.number, this.mail, this.address, this.id);
        } else if (yesOrNo.equals("no")) {
            return;
        }
    }
}
