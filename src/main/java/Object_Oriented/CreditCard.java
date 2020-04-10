package Object_Oriented;

/**
 * A simple model for a consumer credit card.
 *
 * @author Daniele Di Salvo
 * @version 10/04/2020
 */
public class CreditCard {
    // Instance variables:
    private String customer;      // nome del proprietario (e.g., "John Bowman")
    private String bank;          // nome della banca (e.g., "California Savings")
    private String account;       // numero della carta (e.g., "5391 0375 9387 5309")
    private int limit;            // limite di credito (in euro)
    protected double balance;     // saldo attuale (in euro)

    // Constructors:

    /**
     * Constructs a new credit card instance.
     *
     * @param cust       il nome del proprietario (e.g., "John Bowman")
     * @param bk         il nome della banca (e.g., "California Savings")
     * @param acnt       il numero della carta (e.g., "5391 0375 9387 5309")
     * @param lim        il limite di credito (in euro)
     * @param initialBal il saldo attuale (in euro)
     */
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        this.customer = cust;
        this.bank     = bk;
        this.account  = acnt;
        this.limit    = lim;
        this.balance  = initialBal;
    }

    /**
     * Constructs a new credit card instance with default balance of zero.
     *
     * @param cust il nome del proprietario (e.g., "John Bowman")
     * @param bk   il nome della banca (e.g., "California Savings")
     * @param acnt il numero della carta (e.g., "5391 0375 9387 5309")
     * @param lim  il limite di credito (in euro)
     */
    public CreditCard(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0); // use a balance of zero as default
    }

    // Metodi d'accesso

    /**
     * @return the name of the customer.
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @return the name of the bank.
     */
    public String getBank() {
        return bank;
    }

    /**
     * @return the account identifier.
     */
    public String getAccount() {
        return account;
    }

    /**
     * @return the credit limit.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @return the current balance.
     */
    public double getBalance() {
        return balance;
    }

    // Metodi di aggiornamento

    /**
     * Charges the given price to the card, assuming sufficient credit limit.
     *
     * @param price l'importo da addebitare
     * @return true se l' addebito è stato accettato; false se l'addebito è stato negato
     */
    public boolean charge(double price) {
        if (price + balance > limit) {
            return false;
        }

        // a questo punto l'addebito è ammissibile
        balance += price; // aggiorna il saldo
        return true; // comunica la buona notizia
    }

    /**
     * Processes customer payment that reduces balance.
     *
     * @param amount l'importo del pagamento effettuato
     */
    public void makePayment(double amount) {
        balance -= amount;
    }

    // Utility method to print a card's information
    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Limit = " + card.limit);
        System.out.println("Balance = " + card.balance);
    }
} // CreditCard


