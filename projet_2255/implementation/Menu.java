import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public boolean displayWelcomePage() {

        boolean haveAccount = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("               Welcome to                ");
        System.out.println("                 BINECO                  ");
        System.out.println("=========================================");

        String answer;

        do {
            System.out.println("Did you already have an account? Y/N");
            while (!scanner.hasNext()) {
                System.out.println("Not a valid choice. Please enter Y or N!");
                scanner.next();
            }
            answer = scanner.next();
        } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));
        scanner.close();

        if (answer.equalsIgnoreCase("Y")) {
            haveAccount = true;
        } else if (answer.equalsIgnoreCase("N")) {
            haveAccount = false;
        }

        return haveAccount;
    }

    public int displayLoginPage() {

        int loginOption;
        do {
            System.out.println("Please select your login option: ");
            System.out.println("1 - As a resident");
            System.out.println("2 - As a consumer");
            while (!scanner.hasNextInt()) {
                System.out.println("Not a valid choide. Please enter either 1 or 2");
                scanner.next();
            }
            loginOption = scanner.nextInt();
        } while (loginOption != 1 && loginOption != 2);

        return loginOption;

    }

    // public User displayCreateUserPage() {

    // Scanner scanner = new Scanner(System.in);
    // System.out.println("Please choose your user ID: ");
    // String newId = scanner.next();
    // System.out.println("Please choose your password");
    // String newPassword = scanner.next();

    // int signinOption;
    // do {
    // System.out.println("What will you sign in as? ");
    // System.out.println("1 - As a resident");
    // System.out.println("2 - As a consumer");
    // while (!scanner.hasNextInt()) {
    // System.out.println("Not a valid choide. Please enter either 1 or 2");
    // scanner.next();
    // }
    // signinOption = scanner.nextInt();
    // } while (signinOption != 1 && signinOption != 2);
    // scanner.close();

    // }

}
