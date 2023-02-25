package ContacInfo;

import java.io.*;
import java.util.Scanner;

public class Update {
    private Scanner sc = new Scanner(System.in);
    File path = new File("info.txt");
    File tmpPath = new File("tmpinfo.txt");
    public Update() {}

    public Update(String field, int id) {
        updateUserInfo(field, id);
    }

    private void updateUserInfo(String field, int id) {
        field = field.toLowerCase();
        field += ":";
        String currentLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((currentLine = br.readLine()) != null) {
                String[] tmp = currentLine.split("/", 2);
                String[] tmp1 = tmp[0].split(":");
                String[] tmp2 = tmp1[1].split(" ");
                if ((Integer.parseInt(tmp2[1])) == id) {
                    switch (field) {
                        case "name:" : {
                            currentName(currentLine, field, id);
                            break;
                        }
                        case "surname:" : {
                            currentSurName(currentLine, field, id);
                            break;
                        }
                        case "phonenumber:" : {
                            currentNumber(currentLine, field, id);
                            break;
                        }
                        case "mail:" : {
                            currentMail(currentLine, field, id);
                            break;
                        }
                        case "address:" : {
                            currentAddress(currentLine, field, id);
                            break;
                        }
                        default: {
                            System.out.println("there is no such a field:");
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void currentName(String currentLine, String field, int id) {
        String[] forUpdate = currentLine.split(field, 2);
        String[] forUpdate1 = forUpdate[1].split(" ");
        String[] tmpField = field.split(":");
        System.out.print("Enter new " + tmpField[0] + ": ");
        String tmpName = sc.nextLine();
        Name name = new Name();
        GeneralMethods general = new GeneralMethods() {
            @Override
            public void print() {}
        };

        if (name.check_input(tmpName)) {
            tmpName = general.correctUserInputForFile(general.caseSensitive(tmpName));
        } else return;
        forUpdate1[1] = tmpName;
        String tmp1 = " ";
        for (int i = 0; i < forUpdate1.length; ++i) {
            tmp1 += (forUpdate1[i]);
            if (i == forUpdate1.length - 1) {
                break;
            }
            tmp1 += " ";
        }
        String[] tmp4 = tmp1.split(" ");
        String validInfo = "";
        for (int i = 2; i < tmp4.length; ++i) {
            validInfo += tmp4[i];
            if (i == tmp4.length - 1)
                break;
            validInfo += " ";
        }
        String tmp2 = forUpdate[0] + "name: " + validInfo;
        setUpdate(path, tmpPath, tmp2, id);
    }

    private void currentSurName(String currentLine, String field, int id) {
        String[] forUpdate = currentLine.split(field, 2);
        String[] forUpdate1 = forUpdate[1].split(" ");
        String[] tmpField = field.split(":");
        System.out.print("Enter new " + tmpField[0] + ": ");
        String tmpSurName = sc.nextLine();
        Name name = new Name();
        GeneralMethods general = new GeneralMethods() {
            @Override
            public void print() {
            }
        };
        if (name.check_input(tmpSurName)) {
            tmpSurName = general.correctUserInputForFile(general.caseSensitive(tmpSurName));
        } else return;
        forUpdate1[1] = tmpSurName;
        String tmp1 = " ";
        for (int i = 0; i < forUpdate1.length; ++i) {
            tmp1 += (forUpdate1[i]);
            if (i == forUpdate1.length - 1)
                break;
            tmp1 += " ";
        }
        String[] tmp4 = tmp1.split(" ");
        String validInfo = "";
        for (int i = 2; i < tmp4.length; ++i) {
            validInfo += tmp4[i];
            if (i == tmp4.length - 1)
                break;
            validInfo += " ";
        }
        String tmp2 = forUpdate[0] + "surname: " + validInfo;
        setUpdate(path, tmpPath, tmp2, id);
    }

    private void currentMail(String currentLine, String field, int id) {
        String[] forUpdate = currentLine.split(field, 2);
        String[] forUpdate1 = forUpdate[1].split(" ");
        String[] tmpField = field.split(":");
        System.out.print("Enter new " + tmpField[0] + ": ");
        String tmpMail = sc.nextLine();
        EmailAdress mail = new EmailAdress();
        if (mail.checkMailInput(tmpMail).equals(null)) {
            return;
        }
        forUpdate1[1] = tmpMail;
        String tmp1 = " ";
        for (int i = 0; i < forUpdate1.length; ++i) {
            tmp1 += (forUpdate1[i]);
            if (i == forUpdate1.length - 1)
                break;
            tmp1 += " ";
        }
        String[] tmp4 = tmp1.split(" ");
        String validInfo = "";
        for (int i = 2; i < tmp4.length; ++i) {
            validInfo += tmp4[i];
            if (i == tmp4.length - 1)
                break;
            validInfo += " ";
        }
        String tmp2 = forUpdate[0] + "mail: " + validInfo;
        setUpdate(path, tmpPath, tmp2, id);
    }

    private void currentNumber(String currentLine, String field, int id) {
        String[] forUpdate = currentLine.split(field, 2);
        String[] forUpdate1 = forUpdate[1].split(" ");
        String[] tmpField = field.split(":");
        System.out.print("Enter new " + tmpField[0] + ": ");
        String tmpNumber = sc.nextLine();
        PhoneNumber number = new PhoneNumber();
        if (number.checkNumber(tmpNumber)) {
            tmpNumber = number.validPhoneNumber(tmpNumber);
        } else return;
        forUpdate1[1] = "+" + tmpNumber;
        String tmp1 = " ";
        for (int i = 0; i < forUpdate1.length; ++i) {
            tmp1 += (forUpdate1[i]);
            if (i == forUpdate1.length)
                break;
            tmp1 += " ";
        }
        String[] tmp4 = tmp1.split(" ");
        String validInfo = "";
        for (int i = 2; i < tmp4.length; ++i) {
            validInfo += tmp4[i];
            if (i == tmp4.length - 1)
                break;
            validInfo += " ";
        }
        String tmp2 = forUpdate[0] + "phonenumber: " + validInfo;
        setUpdate(path, tmpPath, tmp2, id);
    }

    private void currentAddress(String currentLine, String field, int id) {
        currentLine += " ";
        String[] forUpdate = currentLine.split(field);
        String[] forUpdate1 = forUpdate[1].split(" ", 2);
        System.out.print("Enter new " + field + " ");
        String tmpAdress = sc.nextLine();
        Adress address = new Adress();
        tmpAdress = address.validAddress(tmpAdress);
        forUpdate1[1] = tmpAdress;
        String tmp = "address: " + forUpdate1[1];
        forUpdate[1] = tmp;
        String tmp1 = forUpdate[0] + forUpdate[1];
        setUpdate(path, tmpPath, tmp1, id);
    }

    private void setUpdate(File path, File tmpPath, String updatedLine, int id) {
        String buffer = "";
        int count = 1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            FileWriter wr = new FileWriter(tmpPath, true);
            BufferedWriter out = new BufferedWriter(wr);
            while ((buffer = br.readLine()) != null) {
                if (id == count) {
                    out.write(updatedLine + "\n");
                    count++;
                } else {
                    out.write(buffer + "\n");
                    count++;
                }
                out.flush();
            }
            deletetmpInfo(path);
            writeCurrentFile(path, tmpPath);
            deletetmpInfo(tmpPath);
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void deletetmpInfo(File path) {
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.print("");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void writeCurrentFile(File path, File tmpPath) {
        String currentLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(tmpPath));
            FileWriter wr = new FileWriter(path, true);
            BufferedWriter out = new BufferedWriter(wr);
            while ((currentLine = br.readLine()) != null) {
                out.write(currentLine + "\n");
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
