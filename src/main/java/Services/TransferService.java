package Services;

import Models.Account;
import Storage.BankDatabase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransferService {

    public TransferService(){

    }
/**
 * transfering money from one account to the other
 * Handling null cases of accounts
 * Doesnt take in account if database doesnt have the account asked for
 * */
    public synchronized void transferMoney(UUID fromAccount, UUID toAccount, BigDecimal amount){
        if (fromAccount == null || toAccount == null){
            throw new IllegalArgumentException("Not Enough Args to make transfer");
        }
       Account from =  BankDatabase.getAccount(fromAccount);
       Account to = BankDatabase.getAccount(toAccount);
       from.setBalance(from.getBalance().subtract(amount));
       to.setBalance(to.getBalance().add(amount));

    }
}
