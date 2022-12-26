import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AppMenu {
    //class principal

    Scanner scanner = new Scanner(System.in);

    // MetricController metricController = new MetricController(); Not used yet
    UserController userController = new UserController();
    BinController binController = new BinController();
    ArrayList<String> notifications = new ArrayList<>();
    ArrayList<String> feedback = new ArrayList<String>();
    MetricController metricController = new MetricController(userController,binController);
    
    User loggedUser;
    boolean exit = false;
    

    public static void main(String[] args) {
        
        AppMenu menu = new AppMenu();
        menu.displayMenu();
    }

    public void displayMenu() {
        initialUsers();

        while (!exit) {
            System.out.println("\n=========================================");
            System.out.println("               Welcome to                ");
            System.out.println("                 BINECO                  ");
            System.out.println("=========================================");

            System.out.println("Please select an option: ");
            System.out.println("1. Login");
            System.out.println("2. Create a new Resident account");
            System.out.println("3. Create a new Consumer account");
            System.out.println("0. Exit application ");

            int userChoice = getUserInput(3);
            performFirstPageAction(userChoice);

            if (loggedUser != null) {
                if (loggedUser instanceof Resident) {
                    displayResidentMenu();
                } else if (loggedUser instanceof Consumer) {
                    displayConsumerMenu();
                }
            }

        }
        scanner.close();

    }

    public void initialUsers(){
        

        Resident resident1 = new Resident("res1", "123", "res1", "phone", "adr");
        userController.getResidents().add(resident1);
        userController.getUsers().put("res1", "123");

        Bin bin1 = new Bin(BinType.ORDURE,"qr","bin1","null");
        bin1.setFillLevel(45);
        Bin bin2 = new Bin(BinType.RECYCLAGE,"qr","bin2","null");
        bin2.setFillLevel(30);

        this.binController.getBins().add(bin1);
        this.binController.getBins().add(bin2);

        Resident resident2 = new Resident("res2", "123", "res2", "phone", "adr");
        userController.getResidents().add(resident2);
        userController.getUsers().put("res2", "123");

        this.binController.getBins().add(bin1);
        this.binController.getBins().add(bin2);


        Resident resident3 = new Resident("res3", "123", "res3", "phone", "adr");
        userController.getResidents().add(resident3);
        userController.getUsers().put("res3", "123");
        this.binController.getBins().add(bin1);
        this.binController.getBins().add(bin2);


        Consumer cons1 = new Consumer("cons1","123","cons1","code1","phone","adr","COMPOSTAGE");
        this.userController.getConsumers().add(cons1);
        this.userController.getUsers().put("cons1","123");
        

        Consumer cons2 = new Consumer("cons2","123","cons2","code2","phone","adr","COMPOSTAGE");
        this.userController.getConsumers().add(cons2);
        this.userController.getUsers().put("cons2","123");

        Consumer cons3 = new Consumer("cons3","123","cons3","code3","phone","adr","COMPOSTAGE");
        this.userController.getConsumers().add(cons3);
        this.userController.getUsers().put("cons3","123");

        Consumer cons4 = new Consumer("cons4","123","cons4","code4","phone","adr","COMPOSTAGE");
        this.userController.getConsumers().add(cons4);
        this.userController.getUsers().put("cons4","123");

        Consumer cons5 = new Consumer("cons1","123","cons5","code5","phone","adr","COMPOSTAGE");
        this.userController.getConsumers().add(cons5);
        this.userController.getUsers().put("cons1","123");

        Consumer cons6 = new Consumer("cons6","123","cons6","code6","phone","adr","COMPOSTAGE");
        this.userController.getConsumers().add(cons6);
        this.userController.getUsers().put("cons6","123");

        Consumer cons7 = new Consumer("cons7","123","cons7","code7","phone","adr","COMPOSTAGE");
        this.userController.getConsumers().add(cons7);
        this.userController.getUsers().put("cons7","123");

        Consumer cons8 = new Consumer("cons8","123","cons8","code8","phone","adr","COMPOSTAGE");
        this.userController.getConsumers().add(cons8);
        this.userController.getUsers().put("cons8","123");

        Consumer cons9 = new Consumer("cons9","123","cons9","code9","phone","adr","COMPOSTAGE");
        this.userController.getConsumers().add(cons9);
        this.userController.getUsers().put("cons9","123");

        Consumer cons10 = new Consumer("cons10","123","cons10","code10","phone","adr","COMPOSTAGE");
        this.userController.getConsumers().add(cons10);
        this.userController.getUsers().put("cons10","123");
        //initial users
    }

    public void performFirstPageAction(int userChoice) {
        switch (userChoice) {
            case 0: // Exit application
                exit = true;
                System.out.println("\nTHANK YOU FOR USING BINECO!");
                break;

            case 1: // login
                displayLoginPage();
                break;

            case 2: // create resident account
                createResidentAccount();
                break;

            case 3: // create consumer account
                createConsumerAccount();
                break;

            default:
                System.out.println("Sorry, an unknown error has occurred :(");
                break;

        }
    }

    public void displayLoginPage() {
        System.out.println("\n==========LOGIN PAGE=========");

        int userChoice;
        System.out.println("SELECT WHAT YOU WANT TO DO");
        System.out.println("1. Login to your account");
        System.out.println("0. Go back");

        userChoice = getUserInput(1);

        switch (userChoice) {
            case 0: // Go back to menu
                break;

            case 1: // Logging process
                boolean validUser = false, exit = false;

                while (!validUser && !exit) {
                    System.out.print("\nEnter your ID (your ID is your Email adress): ");
                    
                    String id = scanner.next();
                    System.out.print("Enter your password: ");
                    String password = scanner.next();

                    validUser = userController.verifyUser(id, password);

                    if (validUser) {

                        // If user is a resident
                        for (Resident resident : userController.getResidents()) {
                            if (id.equalsIgnoreCase(resident.getId())) {
                                loggedUser = (User) resident;
                                System.out.println("\nLOGGED IN SUCCESSFULLY AS " + ((Resident) loggedUser).getName());
                                break;
                            }
                        }

                        // If user is a consumer
                        for (Consumer consumer : userController.getConsumers()) {
                            if (id.equalsIgnoreCase(consumer.getId())) {
                                loggedUser = (User) consumer;
                                System.out.println("\nLOGGED IN SUCCESSFULLY AS " + ((Consumer) loggedUser).getName());
                                break;
                            }
                        }

                    } else {
                        System.out.println("\nID or password incorrect, or account does not exist!");
                        
                        displayLoginPage();
                        exit = true;
                    }
                }
                break;

            default:
                System.out.println("Sorry an unknown error has occured :(");
                break;
        }

    }

    // ======================================================================================================
    // ===========================================RESIDENT===================================================
    // ======================================================================================================

    /**
     * Create a resident account
     * 
     */
    public void createResidentAccount() {
        System.out.println("\n==========CREATE RESIDENT ACCOUNT==========");

        String name, phoneNum, address, email, password;

        System.out.print("Enter your name: ");
        name = scanner.next();

        System.out.print("Enter your phone number: ");
        phoneNum = scanner.next();

        System.out.print("Enter your address: ");
        address = scanner.next();

        boolean valid = false;
        while (!valid) {
            System.out.print("\nEnter your e-mail address: ");
            email = scanner.next();

            System.out.print("Enter a password: ");
            password = scanner.next();

            if (!(userController.verifyUser(email, password))) {

                Resident newResident = new Resident(email, password, name, phoneNum, address);

                userController.getResidents().add(newResident);
                userController.getUsers().put(email, password);

                System.out.println("\nYOU HAVE SUCCESSFULLY CREATED YOUR ACCOUNT!");
                System.out.println(
                        "A confirmation link has been sent to your email address. Please verify it within 3 days.");
                valid = true;

            } else {
                System.out.println("\nEmail already existed. Please try again!");
            }
        }
    }

    public void displayResidentMenu() {
        boolean loggedOut = false;
        while (!loggedOut) {

            System.out.println("\n========== NOTIFICATIONS (new to old) ==========");

            if (notifications.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(notifications.get(i));
                }
            } else {
                for (String notification : notifications) {
                    System.out.println(notification);
                }
            }

            System.out.println("\n=========================================");
            System.out.println("               RESIDENT MENU              ");
            System.out.println("=========================================");
            System.out.println("Welcome " + ((Resident) loggedUser).getName() + "! Select what you want to do: ");

            System.out.println("1. Register a bin.");
            System.out.println("2. Remove a bin");
            System.out.println("3. Display your bins");
            System.out.println("4. Display your ecological metrics");
            System.out.println("5. Display bac status");
            System.out.println("6. Find a consumer");
            System.out.println("7. Report a problem");
            System.out.println("8. Edit your profile");
            System.out.println("0. Log out");

            int userChoice = getUserInput(8);

            if (userChoice == 0) { // logout option
                loggedOut = true;
                loggedUser = null;
                System.out.println("\nLOGGED OUT!");
                return;
            }
            performResidentAction(userChoice);
        }
    }

    public void performResidentAction(int userChoice) {
        switch (userChoice) {

            case 1: // Registering new bin
                System.out.println("\n==========REGISTERING NEW BIN==========");

                Bin newBin = this.binController.addNewBin();
                this.binController.getBins().add(newBin);
                ((Resident) loggedUser).addBin(newBin);

                System.out.println("\nBIN REGISTERED SUCCESSFULLY!");

                break;

            case 2: // Removing a bin
                System.out.println("\n==========REMOVING A BIN==========");
                ArrayList<Bin> residentBinsList = ((Resident) loggedUser).getBinsList();

                if (residentBinsList.isEmpty()) {
                    System.out.println("\nYou don't have any bin registered right now!");

                } else {
                    ((Resident) loggedUser).printResidentBins();
                    System.out.println("0. Cancel");
                    System.out.println("\nChoose the bin you want to remove");

                    int binChoice = getUserInput(residentBinsList.size());
                    

                    if (binChoice == 0) {
                        break;
                    }
                    String name = residentBinsList.get(binChoice - 1).getName();

                    residentBinsList.remove(binChoice - 1);
                    

                    System.out.println("\nYou have removed bin " + name);
                    System.out.println("\nYour updated bins list: ");
                    if (residentBinsList.isEmpty()) {
                        System.out.println("\nYou don't have any bin registered right now!");
    
                    } else{
                    ((Resident) loggedUser).printResidentBins();
                }
                }
                break;

            case 3: // Show bins list
                System.out.println("==========YOUR BINS LIST==========");
                ArrayList<Bin> residentsBins = ((Resident) loggedUser).getBinsList();

                if (residentsBins.isEmpty()) {
                    System.out.println("You don't have any bin registered right now!");

                } else {
                    for (int i = 0; i < ((Resident) loggedUser).getBinsList().size(); i++) {
                        Bin bin = residentsBins.get(i);
                        System.out.println("[Bin " + (i + 1) + " " + "Bin QR Code: " + bin.getCodeQr() + " | "
                                + "Bin name: " + bin.getName() + " | " + "Bin type: " + bin.getType() + " | "
                                + "Current fill level: " + bin.getFillLevel() + " | Composition: "
                                + bin.getComposition() + "]" + "\n");
                    }
                }
                break;

            case 4: // Show metrics
                
                this.metricController = new MetricController(this.userController, this.binController);
                this.metricController.showMetrics();
                System.out.println("\n");
                Metric metric = new Metric(this.metricController, ((Resident)loggedUser));
                metric.showMetricRes();
                break;

            case 5: // Show processing state
                
                System.out.println("==========Processing state==========");
                ArrayList<Bin> residentBins = ((Resident) loggedUser).getBinsList();
                
                if (residentBins.isEmpty()) {
                    System.out.println("You don't have any bin registered right now!");
                } else {
                    System.out.println("please choose a bin:");
                    for (int i = 0; i < ((Resident) loggedUser).getBinsList().size(); i++){
                        Bin bin = residentBins.get(i);
                        System.out.println("[Bin "+ (i+1) + "] Bin name: " + bin.getName());
                    }

                    int binChoix = getUserInput(residentBins.size());
                    System.out.println(residentBins.size());
                    Bin theBin = residentBins.get(binChoix-1);

                    long start = theBin.getStartTime().getTime();
                    long now = System.currentTimeMillis( );
                    long diff = now - start;
                    long diffSec = diff / 1000;
                    long days, hours, mins;

                    days = diffSec / (60*60*24);
                    hours = (diffSec - days * 86400)  / (60*60);
                    mins = (diffSec - days * 86400 - hours * 3600) / 60;
                    
                    String time = days + " days, " + hours + " hours and " + mins + " minutes";

                    String state="null";
                    if(theBin.getBinStateType()==BinStateType.AVAILABLE){
                        state = "AVAILABLE";
                    }else if(theBin.getBinStateType()==BinStateType.TRANSITING){
                        state = "TRANSITING";
                    }else if(theBin.getBinStateType() == BinStateType.TREATING){
                        state = "TREATING";
                    }

                    System.out.println("Your bin is now " + state + " for " + time + " and the fill level is " + theBin.getFillLevel());
                }

                break;

            case 6: // Find and rate a consumer, and mark an activity.
                System.out.println("\n==========FIND A CONSUMER==========");

                ArrayList<Consumer> consumersList = userController.getConsumers();
                int consumerChoice = -1;

                while (consumerChoice != 0) {
                    System.out.println("==========Consumers List==========");

                    // If there is no consumer
                    if (consumersList.size() == 0) {
                        System.out.println("We can't find any consumer right now. Please try again later!");
                        break;
                    }

                    // Printing the choices
                    for (int i = 0; i < consumersList.size(); i++) {
                        System.out.println("[" + (i + 1) + "]: " + consumersList.get(i).getName());
                    }
                    System.out.println("[0]: Cancel");
                    System.out.print("Enter the number you want to select: ");

                    // Choose a consumer
                    consumerChoice = getUserInput(consumersList.size() + 1);

                    if (consumerChoice == 0) {
                        break;

                    } else if (consumerChoice <= consumersList.size()) {
                        Consumer consumer = consumersList.get(consumerChoice - 1);

                        System.out.println("[Consumer's name: " + consumer.getName() + " | "
                                + "Code: " + consumer.getCode() + " | "
                                + "Address: " + consumer.getAddress() + " | "
                                + "Phone number: " + consumer.getPhoneNum() + "|"
                                + "Trash type:  " + consumer.getTrashType() + "|"
                                + "Rating: " + consumer.getOverallRating() + "]" + "\n");

                        
                        System.out.println("\n1. Rate an activity");
                        System.out.println("0. Go back");

                        consumerChoice = getUserInput(1);

                        switch (consumerChoice) {
                            case 0: // Go back to menu
                                break;
                            case 1: // Rating an activity of a consumer
                                ArrayList<ConsumerActivity> chosenConsumerActivities = consumer.getActivities();

                                for (int i = 0; i < chosenConsumerActivities.size(); i++) {
                                    System.out
                                            .println("[" + (i + 1) + "] "
                                                    + chosenConsumerActivities.get(i).getActivityName());
                                }

                                int activityChoice = getUserInput(chosenConsumerActivities.size());
                                ConsumerActivity chosenActivity = chosenConsumerActivities.get(activityChoice - 1);

                                double rating = -1;
                                do {
                                    System.out.println("Enter a rating out of 5 for this activity: "
                                            + chosenActivity.getActivityName());
                                    while (!scanner.hasNext()) {
                                        System.out.println("Please enter a valid number");
                                    }
                                    rating = Double.valueOf(scanner.nextInt());
                                    chosenActivity.addRating(rating);
                                } while (rating < 0 || rating > 5);
                                
                                ((Resident) loggedUser).getActivities().add(chosenActivity);

                                System.out.println("\nThis activity is marked successfully");
                                

                                System.out.println("\nThank you for your feedback!");
                                break;
                        }
                    }
                }
                break;

            case 7: // Reporting a problem
                System.out.println("\nWhat seems to be the problem?");
                String answer = scanner.next();
                feedback.add(answer);

                System.out.println("\nTHANK YOU FOR YOUR FEEDBACK!");
                break;

            case 8: // Edit your profile
                System.out.println("\n==========EDIT YOUR PROFILE==========");

                int editChoice = -1;

                System.out.println("Your current information: ");

                System.out.println("1. Name: " + loggedUser.getName());
                System.out.println("2. ID: " + loggedUser.getId());
                System.out.println("3. Password: " + loggedUser.getPassword());
                System.out.println("4. Address: " + loggedUser.getAddress());
                System.out.println("5. Phone number: " + loggedUser.getPhoneNum());

                System.out.println("\n Select what you want to change: ");

                System.out.println("1. Change your name");
                System.out.println("2. Change your ID");
                System.out.println("3. Change your password");
                System.out.println("4. Change your address");
                System.out.println("5. Change your phone number");
                System.out.println("0. Go back to menu");

                editChoice = getUserInput(5);

                switch (editChoice) {
                    // Go back to menu
                    case 0:
                        break;

                    // Changing name
                    case 1:
                        System.out.print("Changing your name to: ");
                        String newName = scanner.next();
                        ((Resident) loggedUser).setName(newName);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + loggedUser.getName());
                        System.out.println("2. ID: " + loggedUser.getId());
                        System.out.println("3. Password: " + loggedUser.getPassword());
                        System.out.println("4. Address: " + loggedUser.getAddress());
                        System.out.println("5. Phone number: " + loggedUser.getPhoneNum());

                        break;

                    // Changing ID
                    case 2:
                        System.out.print("Changing your ID to: ");
                        String newId = scanner.next();
                        ((Resident) loggedUser).setId(newId);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + loggedUser.getName());
                        System.out.println("2. ID: " + loggedUser.getId());
                        System.out.println("3. Password: " + loggedUser.getPassword());
                        System.out.println("4. Address: " + loggedUser.getAddress());
                        System.out.println("5. Phone number: " + loggedUser.getPhoneNum());
                        break;

                    // Changing password
                    case 3:
                        System.out.print("Changing your password to: ");
                        String newPassword = scanner.next();
                        ((Resident) loggedUser).setPassword(newPassword);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + loggedUser.getName());
                        System.out.println("2. ID: " + loggedUser.getId());
                        System.out.println("3. Password: " + loggedUser.getPassword());
                        System.out.println("4. Address: " + loggedUser.getAddress());
                        System.out.println("5. Phone number: " + loggedUser.getPhoneNum());
                        break;

                    // Changing address
                    case 4:
                        System.out.print("Changing your address to: ");
                        String newAddress = scanner.next();
                        ((Resident) loggedUser).setAddress(newAddress);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + loggedUser.getName());
                        System.out.println("2. ID: " + loggedUser.getId());
                        System.out.println("3. Password: " + loggedUser.getPassword());
                        System.out.println("4. Address: " + loggedUser.getAddress());
                        System.out.println("5. Phone number: " + loggedUser.getPhoneNum());
                        break;

                    // Changing phone number
                    case 5:
                        System.out.print("Changing your phone number to: ");
                        String newPhoneNum = scanner.next();
                        ((Resident) loggedUser).setPhoneNum(newPhoneNum);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + loggedUser.getName());
                        System.out.println("2. ID: " + loggedUser.getId());
                        System.out.println("3. Password: " + loggedUser.getPassword());
                        System.out.println("4. Address: " + loggedUser.getAddress());
                        System.out.println("5. Phone number: " + loggedUser.getPhoneNum());
                        break;

                    default:
                        System.out.println("Sorry, an unknown error has occurred :(");
                        break;
                }

                break;

            default:
                System.out.println("Sorry, an unknown error has occurred :(");
                break;
        }
    }

    // ======================================================================================================
    // ===========================================CONSUMER===================================================
    // ======================================================================================================

    /**
     * Create a consumer account
     * 
     */
    public void createConsumerAccount() {
        System.out.println("\n==========CREATE CONSUMER ACCOUNT==========");

        String code, name, phoneNum, address, email, password, trashType;

        System.out.print("Enter your name: ");
        name = scanner.next();

        System.out.print("Enter your code: ");
        code = scanner.next();

        System.out.print("Enter your phone number: ");
        phoneNum = scanner.next();

        System.out.print("Enter your address: ");
        address = scanner.next();

        System.out.print("Enter your type of garbage processing: ");
        trashType = scanner.next();

        boolean valid = false;
        while (!valid) {
            System.out.print("\nEnter your e-mail address: ");
            email = scanner.next();

            System.out.print("Enter a password: ");
            password = scanner.next();

            if (!(userController.verifyUser(email, password))) {

                Consumer newConsumer = new Consumer(email, password, name, code, phoneNum, address, trashType);

                userController.getConsumers().add(newConsumer);
                userController.getUsers().put(email, password);

                System.out.println("\nYOU HAVE SUCCESSFULLY CREATED YOUR ACCOUNT!");
                System.out.println(
                        "A confirmation link has been sent to your email address. Please verify it within 3 days.");
                valid = true;

            } else {
                System.out.println("\nID already existed. Please try again!");
            }
        }
    }

    public void displayConsumerMenu() {
        boolean loggedOut = false;
        while (!loggedOut) {

            System.out.println("\n=========================================");
            System.out.println("               CONSUMER MENU              ");
            System.out.println("=========================================");
            System.out.println("Welcome " + ((Consumer) loggedUser).getName() + "! Select what you want to do: ");

            System.out.println("1. Add an activity");
            System.out.println("2. Modify an activity");
            System.out.println("3. Delele an activity");
            System.out.println("4. Notify residents");
            System.out.println("5. Edit your profile");
            System.out.println("6. Confirme to receive bins");
            System.out.println("7. Confirme to finish processing bins");
            System.out.println("0. Log out");

            int userChoice = getUserInput(7);

            if (userChoice == 0) { // logout option
                loggedOut = true;
                loggedUser = null;

                System.out.println("\nLOGGED OUT");
                return;
            }
            performConsumerAction(userChoice);
        }
    }

    public void performConsumerAction(int userChoice) {
        ArrayList<ConsumerActivity> myActivities;

        switch (userChoice) {

            case 1: // Add an activity
                System.out.println("\n==========ADD AN ACTIVITY==========");

                System.out.print("Your activities list: ");
                System.out.println(((Consumer) loggedUser).printActivities());

                int choice;
                System.out.println("\n1. Add new activity");
                System.out.println("0. Go back");

                choice = getUserInput(1);

                switch (choice) {
                    case 0: // Go back to menu
                        break;

                    case 1: // Adding activity
                        String activityName = "";

                        do {
                            System.out.print("Enter your activity name: ");
                            while (!scanner.hasNext()) {
                                System.out.println("Please enter an activity name!");
                                scanner.next();
                            }
                            activityName = scanner.next();
                        } while (activityName == "");

                        ConsumerActivity newActivity = new ConsumerActivity(activityName);
                        ((Consumer) loggedUser).getActivities().add(newActivity);

                        System.out.println("\nActivity added. Here is your updated list");
                        System.out.println(((Consumer) loggedUser).printActivities());

                        notifications.add(((Consumer) loggedUser).getName() + " added new activity: " + activityName);

                        break;

                    default:
                        System.out.println("Sorry an unknown error has occured");
                        break;
                }
                break;

            case 2: // Modity an activity
                System.out.println("\n==========MODIFY AN ACTIVITY==========");

                myActivities = ((Consumer) loggedUser).getActivities();
                System.out.println("Your activities list: ");

                for (int i = 0; i < myActivities.size(); i++) {
                    System.out.println("[" + (i + 1) + "]: " + myActivities.get(i).getActivityName());
                }

                System.out.println("\n[0]: Cancel");

                int activityChoice = getUserInput(myActivities.size() + 1);

                if (activityChoice == 0) {
                    break;

                } else {
                    String oldName = myActivities.get(activityChoice - 1).getActivityName();
                    String newName = "";
                    do {
                        System.out.print("\nRenaming to: ");
                        while (!scanner.hasNext()) {
                            System.out.println("Please enter your new activity name!");
                            scanner.next();
                        }
                        newName = scanner.next();
                    } while (newName == "");

                    myActivities.get(activityChoice - 1).setActivityName(newName);
                    System.out.println("\nRenaming completed! Here is your updated list: ");
                    System.out.println(((Consumer) loggedUser).printActivities());

                    notifications.add(
                            ((Consumer) loggedUser).getName() + "has renamed activity " + oldName + " to " + newName);
                }
                break;

            case 3: // Delete an activity
                System.out.println("\n==========DELETE AN ACTIVITY==========");

                myActivities = ((Consumer) loggedUser).getActivities();
                System.out.println("Your activities list: ");

                for (int i = 0; i < myActivities.size(); i++) {
                    System.out.println("[" + (i + 1) + "]: " + myActivities.get(i).getActivityName());
                }

                System.out.println("\n[0]: Cancel");

                int deleteActivityChoice = getUserInput(myActivities.size());

                if (deleteActivityChoice == 0) {
                    break;
                } else {
                    String removedActivityName = myActivities.get(deleteActivityChoice - 1).getActivityName();
                    myActivities.remove(deleteActivityChoice - 1);

                    System.out.println("\nRemoving completed! Here is your updated list: ");
                    System.out.println(((Consumer) loggedUser).printActivities());

                    notifications
                            .add(((Consumer) loggedUser).getName() + " has removed activity " + removedActivityName);
                }
                break;

            case 4: // Notify residents
                System.out.println("\n==========NOTIFY RESIDENTS==========");
                String notif = "";

                do {
                    System.out.println("What would like to notify the residents?");
                    while (!scanner.hasNext()) {
                        System.out.println("Please enter your notification!");
                        scanner.next();
                    }
                    notif = scanner.next();
                    notifications.add("New notification from " + ((Consumer) loggedUser).getName() + ": " + notif);
                } while (notif == "");

                System.out.println("\nNotification added!");
                break;

            case 5: // Edit your profile
                System.out.println("\n==========EDIT YOUR PROFILE==========");

                int editChoice = -1;

                System.out.println("Your current informations: ");

                System.out.println("1. Name: " + ((Consumer) loggedUser).getName());
                System.out.println("2. ID: " + ((Consumer) loggedUser).getId());
                System.out.println("3. Password: " + ((Consumer) loggedUser).getPassword());
                System.out.println("4. Address: " + ((Consumer) loggedUser).getAddress());
                System.out.println("5. Phone number: " + ((Consumer) loggedUser).getPhoneNum());
                System.out.println("6. Processing type: " + ((Consumer) loggedUser).getTrashType());

                System.out.println("\n Select what you want to change: ");

                System.out.println("1. Change your name");
                System.out.println("2. Change your ID");
                System.out.println("3. Change your password");
                System.out.println("4. Change your address");
                System.out.println("5. Change your phone number");
                System.out.println("6. Change your type of garbage processing");
                System.out.println("0. Go back to menu");

                editChoice = getUserInput(5);

                switch (editChoice) {
                    case 0: // Go back to menu
                        break;

                    case 1: // Changing nameConsumer
                        System.out.print("Changing your name to: ");
                        String newName = scanner.next();
                        ((Consumer) loggedUser).setName(newName);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + ((Consumer) loggedUser).getName());
                        System.out.println("2. ID: " + ((Consumer) loggedUser).getId());
                        System.out.println("3. Password: " + ((Consumer) loggedUser).getPassword());
                        System.out.println("4. Address: " + ((Consumer) loggedUser).getAddress());
                        System.out.println("5. Phone number: " + ((Consumer) loggedUser).getPhoneNum());
                        System.out.println("6. Processing type: " + ((Consumer) loggedUser).getTrashType());

                        break;

                    case 2: // Changing ID
                        System.out.print("Changing your ID to: ");
                        String newId = scanner.next();
                        ((Consumer) loggedUser).setId(newId);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + ((Consumer) loggedUser).getName());
                        System.out.println("2. ID: " + ((Consumer) loggedUser).getId());
                        System.out.println("3. Password: " + ((Consumer) loggedUser).getPassword());
                        System.out.println("4. Address: " + ((Consumer) loggedUser).getAddress());
                        System.out.println("5. Phone number: " + ((Consumer) loggedUser).getPhoneNum());
                        System.out.println("6. Processing type: " + ((Consumer) loggedUser).getTrashType());
                        break;

                    case 3: // Changing password
                        System.out.print("Changing your password to: ");
                        String newPassword = scanner.next();
                        ((Consumer) loggedUser).setPassword(newPassword);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + ((Consumer) loggedUser).getName());
                        System.out.println("2. ID: " + ((Consumer) loggedUser).getId());
                        System.out.println("3. Password: " + ((Consumer) loggedUser).getPassword());
                        System.out.println("4. Address: " + ((Consumer) loggedUser).getAddress());
                        System.out.println("5. Phone number: " + ((Consumer) loggedUser).getPhoneNum());
                        System.out.println("6. Processing type: " + ((Consumer) loggedUser).getTrashType());
                        break;

                    case 4: // Changing address
                        System.out.print("Changing your address to: ");
                        String newAddress = scanner.next();
                        ((Resident) loggedUser).setAddress(newAddress);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + ((Consumer) loggedUser).getName());
                        System.out.println("2. ID: " + ((Consumer) loggedUser).getId());
                        System.out.println("3. Password: " + ((Consumer) loggedUser).getPassword());
                        System.out.println("4. Address: " + ((Consumer) loggedUser).getAddress());
                        System.out.println("5. Phone number: " + ((Consumer) loggedUser).getPhoneNum());
                        System.out.println("6. Processing type: " + ((Consumer) loggedUser).getTrashType());
                        break;

                    case 5: // Changing phone number
                        System.out.print("Changing your phone number to: ");
                        String newPhoneNum = scanner.next();
                        ((Consumer) loggedUser).setPhoneNum(newPhoneNum);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + ((Consumer) loggedUser).getName());
                        System.out.println("2. ID: " + ((Consumer) loggedUser).getId());
                        System.out.println("3. Password: " + ((Consumer) loggedUser).getPassword());
                        System.out.println("4. Address: " + ((Consumer) loggedUser).getAddress());
                        System.out.println("5. Phone number: " + ((Consumer) loggedUser).getPhoneNum());
                        System.out.println("6. Processing type: " + ((Consumer) loggedUser).getTrashType());
                        break;

                    case 6: // Changing type of garbage processing
                        System.out.print("Changing your processing type: ");
                        String newTrashType = scanner.next();
                        ((Consumer) loggedUser).setTrashType(newTrashType);

                        System.out.println("\nChanges have been made!");
                        System.out.println("1. Name: " + ((Consumer) loggedUser).getName());
                        System.out.println("2. ID: " + ((Consumer) loggedUser).getId());
                        System.out.println("3. Password: " + ((Consumer) loggedUser).getPassword());
                        System.out.println("4. Address: " + ((Consumer) loggedUser).getAddress());
                        System.out.println("5. Phone number: " + ((Consumer) loggedUser).getPhoneNum());
                        System.out.println("6. Processing type: " + ((Consumer) loggedUser).getTrashType());
                        break;
                    default:
                        System.out.println("Sorry, an unknown error has occurred :(");
                        break;
                }break;
                
            
                case 6: //confirming to receive bins
                    boolean finished = false;
                
                    
                    System.out.println("\n==========CONFIRME TO RECEIVE BINS==========");

                    while(finished == false){
                         System.out.println("Enter the QR code of the bin you received");
                         System.out.println("Enter 0 to quit");
                         String newQR = scanner.next();
   
                         if(newQR == "0"){
                            finished = true;
                         }

                         ArrayList<String> qRcodes = new ArrayList<String>();
    
                         for( int i= 0; i < this.binController.getBins().size(); i++){
                             qRcodes.add(this.binController.getBins().get(i).getCodeQr());
                         }//get arrayList of QRcodes according to index of ArrayList<bin>
                
                         int indexBin = -1;
                         
   
                         for(int i = 0; i < qRcodes.size() ; i++){
                             if( qRcodes.get(i) == newQR){
                                System.out.println(qRcodes.get(i));
                                System.out.println(newQR);
                                 indexBin = i;
                                 break;
                             }
                         }
                         

                         if(indexBin == -1){
                             System.out.println("The QR code you gave is invalid");
                             break;

                         }else{
                             Bin binRecu = this.binController.getBins().get(indexBin);
                             binRecu.setBinStateType(BinStateType.TREATING);
                             binRecu.setStartTime();
                             System.out.println("The bin is marked as TREATING!");
                         }
                        }
                
                        case 7: //confirming to receive bins
                        boolean fin = false;
                    
                        
                        System.out.println("\n==========CONFIRME TO FINISH PROCESSING BINS==========");
    
                        while(fin == false){
                             System.out.println("Enter the QR code of the bin you finished");
                             System.out.println("Enter 0 to quit");
                             String newQR = scanner.next();
       
                             if(newQR == "0"){
                                fin = true;
                             }
        
                             ArrayList<String> qRcodes = new ArrayList<String>();
    
                         for( int i= 0; i < this.binController.getBins().size(); i++){
                             qRcodes.add(this.binController.getBins().get(i).getCodeQr());
                         }//get arrayList of QRcodes according to index of ArrayList<bin>
                
                         int indexBin = -1;
   
                         for(int i = 0; i < qRcodes.size() ; i++){
                             if( qRcodes.get(i) == newQR){
                                 indexBin = i;
                                 break;
                             }
                            }


                             if(indexBin == -1){
                                 System.out.println("The QR code you gave is invalid");
                                 break;
    
                             }else{
                                 Bin binRecu = this.binController.getBins().get(indexBin);
                                 binRecu.setBinStateType(BinStateType.AVAILABLE);
                                 binRecu.setStartTime();
                                 System.out.println("The bin is marked as AVAILABLE!");
                             }
                            }                        

            

                default:
                    System.out.println("Sorry, an unknown error has occurred :(");
                    break;

        }
    }

    // ======================================================================================================
    // ======================================================================================================
    // ======================================================================================================

    /**
     * Method to get user input as an Integer
     * 
     * @param numOfChoices the maximum number of choice
     * @return userChoice as an integer
     */
    public int getUserInput(int numOfChoices) {
        int userChoice = -1;
        do {
            System.out.print("\nEnter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Not a valid choice. Please try again!");
                scanner.next();
            }
            userChoice = scanner.nextInt();

            if (userChoice < 0 || userChoice > numOfChoices) {
                System.out.println("Not a valid choice. Please try again!");
            }

        } while (userChoice < 0 || userChoice > numOfChoices);

        return userChoice;
    }
}
