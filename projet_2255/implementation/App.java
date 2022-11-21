import java.util.Scanner;

public class App {

    Scanner scanner = new Scanner(System.in);

    UserController uc = new UserController();
    BinController bc = new BinController();
    MetricController mc = new MetricController();
    Resident loggedResident;
    boolean exit = false;

    public static void main(String[] args) {
        App menu = new App();
        menu.loggedResident = new Resident("nash", "123");
        menu.displayMenu();

    }

    public void displayMenu() {
        displayHeader();
        // displayLoginPage();
        bc.setResident(loggedResident);

        while (!exit) {
            displaySelectionPage();
            int userChoice = getUserInput(7);
            performAction(userChoice);
        }

    }

    public void performAction(int userChoice) {
        switch (userChoice) {
            case 0:
                exit = true;
                System.out.println("\nTHANK YOU FOR USING BINECO!");
                break;

            case 1:
                bc.addNewBin();
                break;

            case 2:
                if (loggedResident.getBinList().isEmpty()) {
                    System.out.println("\nYOU DON'T HAVE ANY BIN REGISTERED RIGHT NOW!");
                } else {
                    loggedResident.printBins();
                    System.out.println("\nChoose the bin you want to remove");
                    int choice = getUserInput(loggedResident.getBinList().size());
                    loggedResident.removeBin(choice - 1);
                    System.out.println("\nYOU HAVE REMOVED BIN NUMBER " + choice);
                    loggedResident.printBins();
                }
                break;

            case 3:
                if (loggedResident.getBinList().isEmpty()) {
                    System.out.println("YOU DON'T HAVE ANY BIN REGISTERED RIGHT NOW!");
                } else {
                    loggedResident.printBins();
                }
                break;

            case 4:
                mc.showMetrics();
                break;

            case 6:
                uc.getConsommateurs();
                System.out.print("Enter the consumer's code you want to find: ");
                int choice = getUserInput(uc.consommateursList.size());
                System.out.println(uc.consommateursList.get(choice));
                break;

            case 7:
                System.out.println("\nWhat seems to be the problem?");
                String answer = scanner.next();
                loggedResident.updateRequest(answer);
                System.out.println("\nYOUR REQUEST HAS BEEN SENT!");
                break;

            default:
                break;
        }
    }

    public void displayHeader() {
        System.out.println("=========================================");
        System.out.println("               Welcome to                ");
        System.out.println("                 BINECO                  ");
        System.out.println("=========================================");

    }

    public void displayLoginPage() {
        System.out.print("\nAlready have an account? Y/N: ");
        String userChoice = getUserInput();

        if (userChoice.equalsIgnoreCase("Y")) { // User already have account
            boolean validUser = false;

            while (!validUser) {
                System.out.print("\nPlease enter your valid user ID: ");
                String id = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next();
                validUser = uc.verifyUser(id, password);
            }
            System.out.println("LOGGED IN SUCCESSFULLY");

        } else { // If don't have an account, user must register a new one
            System.out.print("\nPlease choose your user ID: ");
            String newId = scanner.next();
            System.out.print("Plese enter your password: ");
            String newPassword = scanner.next();

            loggedResident = uc.createResident(newId, newPassword);
            System.out.println("CONGRATULATIONS! YOU HAVE CREATED YOUR ACCOUNT!");

            displayLoginPage();
        }

    }

    public void displaySelectionPage() {
        System.out.println("\nYou are a resident! Select what you want to do: ");
        System.out.println("1. Enregistrer un bac.");
        System.out.println("2. Supprimer un bac");
        System.out.println("3. Afficher l'états des bacs");
        System.out.println("4. Consulter les métriques");
        System.out.println("5. Voir l'état du traitement de déchets");
        System.out.println("6. Trouver un consommateur");
        System.out.println("7. Signaler un problème");
        System.out.println("0. Exit");
    }

    /**
     * Method to get user input as an Integer
     * 
     * @param choiceRange the maximum number of choice
     * @return userChoice as an integer
     */
    public int getUserInput(int choiceRange) {
        int userChoice = -1;
        do {
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Not a valid choide. Please try again!");
                scanner.next();
            }
            userChoice = scanner.nextInt();

            if (userChoice < 0 || userChoice > choiceRange) {
                System.out.println("Not a valid choice. Please try again!");
            }

        } while (userChoice < 0 || userChoice > choiceRange);

        return userChoice;
    }

    /**
     * Overloaded method to get user input as a String
     * 
     * @return userChoice as a string
     */
    public String getUserInput() {
        String userChoice;
        do {
            System.out.print("Enter your choice: ");
            while (!scanner.hasNext()) {
                System.out.println("Not a valid choide. Please try again!");
                scanner.next();
            }
            userChoice = scanner.next();

        } while (!userChoice.equalsIgnoreCase("Y") && !userChoice.equalsIgnoreCase("N"));

        return userChoice;
    }

}
