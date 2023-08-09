import java.util.ArrayList;
import java.util.Random;

public class Bank {
    /**
     *
     */
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    /**
     *
     * @return
     */
    public String getNewUserUUID(){

        //inits
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique = false;

        // continue looping until we get a unique ID
        do {

            // generate the number
            uuid = "";
            for(int c = 0; c < len; c++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            // check if it´s unique
                nonUnique = false;
                for(User u : users){
                    if(uuid.compareTo(u.getUuid()) == 0){
                        nonUnique = true;
                        break;
                    }
                }
            }
        }while (nonUnique);

return uuid;
    }

    /**
     * Create a
     * @return
     */
    public String getNewAccountUUID(){

        //inits
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique = false;

        // continue looping until we get a unique ID
        do {

            // generate the number
            uuid = "";
            for(int c = 0; c < len; c++){
                uuid += ((Integer)rng.nextInt(10)).toString();
                // check if it´s unique
                nonUnique = false;
                for(Account a : accounts){
                    if(uuid.compareTo(a.getUuid()) == 0){
                        nonUnique = true;
                        break;
                    }
                }
            }
        }while (nonUnique);

        return uuid;
    }


    public User addUser(String firstName, String lastName,String pin) {

        //Create a new user and add it to the list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        //Create a savings account for the user and to User and Bank accounts list
        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;
    }
}
