package ContacInfo;

import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.io.*;

public class Name extends GeneralMethods {
    private String name;
    private String path = "name.txt";
    public Name() {

    }
    public Name(String name) {
        set_name(name);
    }

    public void set_name(String name) {
        if (check_input(name)) {
            this.name = correctUserInputForFile(caseSensitive(name));
        } else return;
    }

    public String get_name() {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println("Print a function");
    }
}
