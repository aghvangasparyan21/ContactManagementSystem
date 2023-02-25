package ContacInfo;

import java.io.File;
import java.util.Scanner;

public class Controller {
    private String name;
    private String surname;
    private String contact;
    private String email;
    private String userAddress;
    GenerateId idOfUser = new GenerateId();
    File path = new File("info.txt");
    private Scanner sc = new Scanner(System.in);
    private void set_name_controller() {
        System.out.print("Enter user's name: ");
        this.name = sc.nextLine();
    }

    private void set_surname_controller() {
        System.out.print("Enter user's surname: ");
        this.surname = sc.nextLine();
    }

    private void input_number() {
        System.out.print("Enter user's phone number: ");
        this.contact = sc.nextLine();

    }

    private void input_email() {
        System.out.print("Enter user's e-mail: ");
        this.email = sc.nextLine();
    }

    private void input_adress() {
        System.out.print("Enter user's address: ");
        this.userAddress = sc.nextLine();
    }

    public void operation() {
        String oper = "";
        boolean iteration = true;
        while (iteration) {
            System.out.print("Read or write or search? ");
            oper = sc.nextLine().toLowerCase();
            if (oper.equals("write")) {
                doOperation();
            } else if (oper.equals("read")) {
                new ReadFromFile();
            } else if (oper.equals("search")) {
                User user = new User();
                user.search();
            } else {
                iteration = false;
            }
        }
    }

    public void doOperation() {
        boolean iteration = true;
        String yesOrNo = "";
        while (iteration) {
            System.out.print("Do you want to enter user? Enter yes or no: ");
            yesOrNo = sc.nextLine();
            yesOrNo = yesOrNo.toLowerCase();
            if (yesOrNo.equals("yes")) {
                mainProcess();
            } else {
                iteration = false;
            }
        }
    }

    private void mainProcess() {
        set_name_controller();
        Name user_name = new Name(this.name);
        set_surname_controller();
        SurName user_surname = new SurName(this.surname);
        input_number();
        PhoneNumber number = new PhoneNumber(this.contact);
        input_email();
        EmailAdress pochta = new EmailAdress(this.email);
        input_adress();
        Adress hasce = new Adress(this.userAddress);
        new User(user_name.get_name(), user_surname.get_surname(), number.get_number(), pochta.get_mail(), hasce.get_address(), idOfUser.theLastId(path));
    }
}
