package Models;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {

    /**
     * Declaring Values for Account Class
     * Using UUID for accountId because of its unique identifier capabilities
     * Using big decimal because it can account for any amount of money
     * */
    private UUID accountID;
    private BigDecimal balance;

    /**
     * No Arg constructor
     * */
    public Account () {}
    /**
     * Initialize class variables when new instance of this class is created
     * */
    public Account(UUID accountId, BigDecimal balance){
        this.accountID = accountId;
        this.balance = balance;
    }

    /**
     * accessor and methods to help control changes to the variables
     * */

    public UUID getAccountID() {
        return accountID;
    }

    public void setAccountID(UUID accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
