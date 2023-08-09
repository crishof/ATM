import java.util.Date;

public class Transaction {

    private double amount;
    private Date timestamp;
    private String memo;
    private Account inAccount;

    /**
     * Constructs a new Transaction
     * @param amount
     * @param inAccount
     */
    public Transaction(double amount, Account inAccount){
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";
    }

    /**
     * Constructs a new Transaction
     * @param amount the ammount transacted
     * @param memo the memo for the transaction
     * @param inAccount th account the transaction belongs to
     */
    public Transaction(double amount,String memo, Account inAccount){

        // call the two-arg first
        this(amount,inAccount);

        this.memo = memo;
    }
}
