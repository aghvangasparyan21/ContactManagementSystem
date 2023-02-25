package ContacInfo;

public abstract class GeneralMethods {
    public String correctUserInputForFile(String input) {
        char[] tmp = input.toCharArray();
        String validName = "";
        String validInput = String.valueOf(tmp);
        char[] tmp1 = validInput.toCharArray();
        if (tmp1[0] >= 97 && tmp1[0] <= 122) {
            tmp1[0] -= 32;
        }
        for (int j = 0; j < tmp1.length; ++j) {
            if (tmp1[j] == ' ') {
                String[] str = validInput.split(" ");
                for (int i = 0; i < str.length; ++i) {
                    str[i] = str[i].substring(0, 1).toUpperCase() + str[i].substring(1).toLowerCase();
                    validName += (str[i]);
                    if (validName.length() == validInput.length()) {
                        break;
                    }
                    validName += " ";
                }
                return validName;
            }
        }
        for (int i = 1; i < tmp1.length; ++i) {
            if (tmp1[i] == '-') {
                if (tmp1[i + 1] >= 97 && tmp1[i + 1] <= 122) {
                    tmp1[i + 1] -= 32;
                }
                i = i + 1;
                continue;
            }
            if (tmp1[i] >= 65 && tmp1[i] <= 90 && tmp1[i] != '-') {
                tmp1[i] += 32;
            }
        }
        validInput = String.valueOf(tmp1);
        return validInput;
    }

    public boolean check_input(String username) {
        char[] checking = username.toCharArray();
        if (checking[0] == '-') {
            return false;
        }
        return true;
    }

    public String caseSensitive(String input) {
        return input.toUpperCase();
    }

    public abstract void print();
}
