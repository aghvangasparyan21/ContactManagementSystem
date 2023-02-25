package ContacInfo;

public class PhoneNumber {
    private String phonenumber;
    private String path = "phonenumber.txt";
    public PhoneNumber() {}
    public PhoneNumber(String number) {
        set_number(number);
    }

    public void set_number(String number) {
        if (checkNumber(number)) {
            this.phonenumber = validPhoneNumber(number);
        } else return;
    }

    public boolean checkNumber(String number) {
        char[] contact = number.toCharArray();
        for (int i = 0; i < contact.length; ++i) {
            if ((contact[i] >= 0 && contact[i] < 48) || (contact[i] > 57)) {
                return false;
            }
        }
        return true;
    }

    public String validPhoneNumber(String number) {
        char[] tmp = number.toCharArray();
        if (tmp.length < 11) {
            return null;
        }
        if (tmp[3] == 0) {
            return null;
        }
        if ((tmp.length != 11) && ((tmp[0] != '3') || (tmp[1] != '7') || (tmp[2] != '4'))) {
            return null;
        } else {
            number = String.valueOf(tmp);
            return number;
        }
    }

    public String get_number() {
        if (this.phonenumber == null) {
            return null;
        } else {
            return "+" + this.phonenumber;
        }
    }
}
