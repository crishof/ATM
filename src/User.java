import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private String uuid;
    private byte pinhash[];
    private ArrayList<Account> accounts;

    /**
     *
     * @param firstName
     * @param lastName
     * @param pin
     * @param theBank
     */
    public User(String firstName, String lastName, String pin,Bank theBank){
        this.firstName = firstName;
        this.lastName = lastName;

//        store the pin MD5 hash rather than the original value

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinhash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("error, caught no such algorithmException");
            e.printStackTrace();
            System.exit(1);
        }
//        Get a new uuid
        this.uuid = theBank.getNewUserUUID();

//        create empty list of accounts
        this.accounts = new ArrayList<Account>();

//        print log messages

        System.out.printf("New user %s, %s with uuid %s created.\n",lastName,firstName,this.uuid);


    }

    /**
     *
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

}
