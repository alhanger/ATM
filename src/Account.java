import java.util.Scanner;

/**
 * Created by alhanger on 10/9/15.
 */
public class Account {
    String name;
    double balance;
    Scanner scanner = new Scanner(System.in);

    void accountName() throws Exception {
        System.out.println("Welcome to the ATM.");
        System.out.println("Please enter your name.");
        name = scanner.nextLine();
        System.out.println("Hello, " + name);
        if (name.equals("")) {
            throw new Exception("Please enter a name to access your account or create a new account.");
        }
    }

    void verifyAccount() throws Exception {
        if (!ATM.accounts.containsKey(name)){ //If name is not found in accounts, runs initiates account creation
            System.out.println("Your name was not found in our system. Would you like to create a new account? [y/n]"); //Prompts user to create new account
            String s = scanner.nextLine();
            if (s.equals("y")) { //Initiates create new account
                System.out.println("Creating new account...");
                System.out.println("How much would you like to deposit?");
                String deposit = scanner.nextLine(); //takes user input and stores it in deposit variable
                double depositNum = Double.valueOf(deposit); //converts deposit into a double
                balance = depositNum; //WTF??
                ATM.accounts.put(name, depositNum); //adds new account to hashmap
            }
            else if (s.equals("n")) { //Exits system if user chooses not to create account
                System.out.println("Thank you. Please come again.");
                System.exit(0);
            }
            else throw new Exception("I'm sorry, that is not a valid option");
        }
        else if (ATM.accounts.containsKey(name)) { //if name is found, runs chooseOption
            chooseOption();
        }
    }

    void chooseOption() throws Exception {
        System.out.println("What would you like to do?");
        System.out.println("[1] Check My Balance");
        System.out.println("[2] Withdraw Funds");
        System.out.println("[3] Remove Account");
        System.out.println("[4] Logout");
        System.out.println("[5] Cancel");
        String option = scanner.nextLine();
        int optionNum = Integer.valueOf(option);
        double balance = ATM.accounts.get(name);
        if (optionNum == 1) { //returns balance
            System.out.println("Your balance is $" + balance + ".");
        }
        else if (optionNum == 2) { //withdraws money and returns new balance
            System.out.println("How much would you like to withdraw?");
            String amount = scanner.nextLine();
            int amountNum = Integer.valueOf(amount);
            if (amountNum > balance) { //error message for inadequate funds
                System.out.println("I'm sorry, you do not have adequate funds.");
            }
            else if (amountNum <= balance && amountNum > 0) { //withdraws funds and returns new balance
                System.out.println("Please withdraw your cash below.");
                balance = balance - amountNum;
                System.out.println("Your new balance is $" + balance + ".");
                ATM.accounts.put(name, balance);
            }
        }
        else if (optionNum == 3) { //removes account
            System.out.println("Removing account: " + name);
            ATM.accounts.remove(name);
            System.out.println("Thanks for using Bank of Iron Yard. Please come again.");
            System.exit(0);

        }
        else if (optionNum == 4) { //logs out the user and restarts the program
            System.out.println("Logging out...");
            accountName();
        }
        else if (optionNum == 5) { //exits system
            System.out.println("Thank you. Please come again.");
            System.exit(0);
            }
        }
    }
