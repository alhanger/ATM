import java.util.HashMap;

/**
 * Created by alhanger on 10/8/15.
 */
public class ATM {
    public static HashMap<String, Double> accounts = new HashMap<>();
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
