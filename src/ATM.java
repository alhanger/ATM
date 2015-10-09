import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by alhanger on 10/8/15.
 */
public class ATM {
    public static void run() throws Exception {

        System.out.println("Welcome to the ATM.");
        Account account = new Account();

        account.accountName();

        while(true) {
            account.verifyAccount();
            account.chooseOption();
        }
    }
}
