package ContacInfo;

import java.io.*;

public class Delete {
    File path = new File("info.txt");
    File tmpPath = new File("tmpinfo.txt");
    public Delete(int id) {
        setStatus(id);
    }
    private void setStatus(int id) {
        String currentLine = "";
        try {
            FileWriter wr = new FileWriter(tmpPath, true);
            BufferedWriter out = new BufferedWriter(wr);
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((currentLine = br.readLine()) != null) {
                int tempid1 = idOfUser(currentLine);
                if (tempid1 == id) {
                    currentLine += (" //status: deleted");
                    setUpdate(path, tmpPath, currentLine, id);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
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
    private int idOfUser(String currentLine) {
        String[] tmp = currentLine.split("/", 2);
        String[] tmp1 = tmp[0].split(":");
        String[] tmp2 = tmp1[1].split(" ");
        return Integer.parseInt(tmp2[1]);
    }
}
