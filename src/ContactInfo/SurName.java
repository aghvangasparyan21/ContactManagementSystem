package ContacInfo;

public class SurName extends GeneralMethods {
    private String user_name;
    private String path = "surname.txt";

    public SurName(String username) {
        set_surname(username);
    }

    public void set_surname(String username) {
        if (check_input(username)) {
            this.user_name = correctUserInputForFile(caseSensitive(username));
        } else return;

    }

    public String get_surname() {
        return this.user_name;
    }

    @Override
    public void print() {
        System.out.println("Print Function");
    }
}

