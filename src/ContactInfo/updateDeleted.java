package ContacInfo;

import java.io.*;

public class updateDeleted {
    File path = new File("info.txt");
    File tmpPath = new File("tmpinfo.txt");
    public updateDeleted(String info, int id) {
        deleteStatus(info, id);
    }
    public void deleteStatus(String info, int id) {
        setUpdate(path, tmpPath, info, id);
    }
    private void setUpdate(File path, File tmpPath, String info, int id) {
        String[] delete = info.split(" //");
        System.out.println(delete[0]);
        String information = delete[0];
        String buffer = "";
        int count = 1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            FileWriter wr = new FileWriter(tmpPath, true);
            BufferedWriter out = new BufferedWriter(wr);
            while ((buffer = br.readLine()) != null) {
                if (buffer.equals(info)) {
                    out.write(information + "\n");
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
