package ContacInfo;

public class EmailAdress {
    private String mail;
    public EmailAdress() {}
    public EmailAdress(String email) {
        setMail(email);
    }
    public void setMail(String email) {
        if (checkMailInput(email).equals(null)) {
            return;
        } else {
            this.mail = email;
        }
    }

    public String checkMailInput(String email) {
        char[] tmp = email.toCharArray();
        for (int i = 0; i < tmp.length; ++i) {
            if (tmp[i] == ' ') {
                return null;
            }
        }
        if ((email.substring(email.length() - 8, email.length())).equals("@mail.ru")) {
            return email;
        } else if ((email.substring(email.length() - 10, email.length())).equals("@gmail.com")) {
            return email;
        } else {
            return null;
        }
    }

    public String get_mail() {
        return this.mail;
    }
}
