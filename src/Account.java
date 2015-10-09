import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by alhanger on 10/9/15.
 */
public class Account {
    String name;
    String option;
    double balance;
    HashMap<String, Double> accounts = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    void accountName() throws Exception {
        System.out.println("Please enter your name.");
        name = scanner.nextLine();
        System.out.println("Hello, " + name);
        if (name.equals("")) {
            throw new Exception("Please enter a name to access your account or to create a new account.");
        }
    }

    void verifyAccount() throws Exception {
        if (!accounts.containsKey(name)){ //If name is found in accounts, runs chooseOption
            System.out.println("Your name was not found in our system. Would you like to create a new account? [y/n]");
            String s = scanner.nextLine();
            if (s.equals("y")) {
                System.out.println("Creating new account...");
                System.out.println("How much would you like to deposit?");
                String deposit = scanner.nextLine(); //takes user input and stores it in deposit variable
                double depositNum = Double.valueOf(deposit); //converts deposit into a double
                balance = depositNum;
                accounts.put(name, balance); //adds new account to accounts hashmap
            } else if (s.equals("n")) {
                System.out.println("Thank you. Please come again.");
            } else throw new Exception("I'm sorry, that is not a valid option");
        }
    }

    void chooseOption() throws Exception {
        System.out.println("What would you like to do?");
        System.out.println("[1] Check My Balance");
        System.out.println("[2] Withdraw Funds");
        System.out.println("[3] Remove Account");
        System.out.println("[4] Cancel");
        option = scanner.nextLine();
        int optionNum = Integer.valueOf(option);
        if (optionNum == 1) {
            System.out.println("Your balance is $" + balance + ".");
        } else if (optionNum == 2) {
            System.out.println("How much would you like to withdraw?");
            String amount = scanner.nextLine();
            int amountNum = Integer.valueOf(amount);
            if (amountNum > balance) {
                throw new Exception("I'm sorry, you do not have adequate funds.");
            } else if (amountNum <= balance && amountNum != 0) {
                System.out.println("Please withdraw your cash below.");
                balance = balance - amountNum;
                System.out.println("Your new balance is $" + balance + ".");
                accounts.put(name, balance);
            }
            else if (optionNum == 3) {
                System.out.println("Removing account..." + name);
                accounts.remove(name);
            }
        } else if (optionNum == 4) {
            System.out.println("Thank you and please come again.");
            System.exit(0);
        }
    }

}
