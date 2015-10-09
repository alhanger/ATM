import java.util.Scanner;

/**
 * Created by alhanger on 10/8/15.
 */
public class ATM {
    public static void run() throws Exception {

        System.out.println("Welcome to the ATM.");
        System.out.println("What is your name?");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
        if (name.equals("")) {
            throw new Exception("You did not enter a name. Goodbye.");
        }

        System.out.println("What would you like to do?");
        System.out.println("[1] Check My Balance");
        System.out.println("[2] Withdraw Funds");
        System.out.println("[3] Cancel");
        String option = scanner.nextLine();
        int optionNum = Integer.valueOf(option);
        if (optionNum == 1) {
            System.out.println("Your balance is $100");
        } else if (optionNum == 2) {
            System.out.println("How much would you like to withdraw?");
            String amount = scanner.nextLine();
            int amountNum = Integer.valueOf(amount);
            if (amountNum > 100) {
                throw new Exception("I'm sorry, you do not have adequate funds.");
            } else if (amountNum <= 100 && amountNum != 0) {
                System.out.println("Please withdraw your cash below.");
                int newBalance = 100 - amountNum; //Subtracts withdrawal amount from balance ($100)
                String newBalStr = Integer.toString(newBalance); //Converts new balance to a string
                System.out.println("Your new balance is $" + newBalStr + ".");
            }
        } else if (optionNum == 3) {
            System.out.println("Thank you and please come again.");
        }
    }
}