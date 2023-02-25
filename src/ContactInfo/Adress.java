package ContacInfo;

public class Adress {
    private String adress;
    private String path = "adress.txt";
    public Adress() {}
    public Adress(String userAddress) {
        setAdress(userAddress);
    }
    public void setAdress(String userAddress) {
        this.adress = validAddress(userAddress);
    }
    public String validAddress(String userAddress) {
        char[] tmp = userAddress.toCharArray();
        for (int i = 0; i < tmp.length; ++i) {
            if ((tmp[i] >= 65 && tmp[i] <= 90) || (tmp[i] >= 97 && tmp[i] <= 122) || tmp[i] == '/' || tmp[i] == '.' || tmp[i] == '-' || tmp[i] == ' ') {
                continue;
            } else return null;
        }
        int countOfMinus = 0;
        int countOfSlash = 0;
        int countOfDot = 0;
        int count = 0;
        for (int i = 0; i < tmp.length; ++i) {
            if (tmp[i] == ' ') {
                count++;
            }
        }
        for (int i = 0; i < tmp.length; ++i) {
            if (tmp[i] == '-') {
                countOfMinus++;
            }
        }
        for (int i = 0; i < tmp.length; ++i) {
            if (tmp[i] == '/') {
                countOfSlash++;
            }
        }
        for (int i = 0; i < tmp.length; ++i) {
            if (tmp[i] == '.') {
                countOfDot++;
            }
        }
        if (count == 0 && countOfDot == 0 && countOfMinus == 0 && countOfSlash == 0) {
            userAddress = userAddress.substring(0, 1).toUpperCase() + userAddress.substring(1).toLowerCase();
            return userAddress;
        }
        if (count >= 0 && countOfDot == 0 && countOfMinus == 0 && countOfSlash == 0) {
            if (count == 0) {
                return userAddress;
            } else {
                String[] str = userAddress.split(" ");
                String tmpAddress = "";
                for (int i = 0; i < str.length; ++i) {
                    str[i] = str[i].substring(0, 1).toUpperCase() + str[i].substring(1).toLowerCase();
                    tmpAddress += (str[i]);
                    if (tmpAddress.length() == userAddress.length()) {
                        break;
                    }
                    tmpAddress += " ";
                }
                return tmpAddress;
            }
        }
        if (count == 0 && countOfDot >= 0 && countOfMinus == 0 && countOfSlash == 0) {
            if (countOfDot == 0) {
                return userAddress;
            } else {
                String[] str = userAddress.split(".");
                String tmpAddress = "";
                for (int i = 0; i < str.length; ++i) {
                    str[i] = str[i].substring(0, 1).toUpperCase() + str[i].substring(1).toLowerCase();
                    tmpAddress += (str[i]);
                    if (tmpAddress.length() == userAddress.length()) {
                        break;
                    }
                    tmpAddress += ".";
                }
                return tmpAddress;
            }
        }
        if (count == 0 && countOfDot == 0 && countOfMinus >= 0 && countOfSlash == 0) {
            if (countOfMinus == 0) {
                return userAddress;
            } else {
                String[] str = userAddress.split("-");
                String tmpAddress = "";
                for (int i = 0; i < str.length; ++i) {
                    str[i] = str[i].substring(0, 1).toUpperCase() + str[i].substring(1).toLowerCase();
                    tmpAddress += (str[i]);
                    if (tmpAddress.length() == userAddress.length()) {
                        break;
                    }
                    tmpAddress += "-";
                }
                return tmpAddress;
            }
        }
        if (count == 0 && countOfDot == 0 && countOfMinus == 0 && countOfSlash >= 0) {
            if (countOfSlash == 0) {
                return userAddress;
            } else {
                String[] str = userAddress.split("/");
                String tmpAddress = "";
                for (int i = 0; i < str.length; ++i) {
                    str[i] = str[i].substring(0, 1).toUpperCase() + str[i].substring(1).toLowerCase();
                    tmpAddress += (str[i]);
                    if (tmpAddress.length() == userAddress.length()) {
                        break;
                    }
                    tmpAddress += "/";
                }
                return tmpAddress;
            }
        }
        return userAddress;
    }
    public String get_address() {
        return this.adress;
    }
}
