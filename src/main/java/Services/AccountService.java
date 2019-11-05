package Services;

import Models.Account;
import Storage.BankDatabase;
import Utils.Utils;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountService {

    public AccountService(){}

    public UUID addAccount(BigDecimal amount){
        if (amount == null){
            amount = BigDecimal.ZERO;
        }
        Account account = new Account(Utils.generateId(), amount);
        BankDatabase.addAccount(account);

        return account.getAccountID();
    }
    public Account getAccount(UUID accountId){
        return BankDatabase.getAccount(accountId);
    }
}
