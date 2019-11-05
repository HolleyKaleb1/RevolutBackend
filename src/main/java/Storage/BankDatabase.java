package Storage;

import Models.Account;
import Models.Transfer;
import Utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BankDatabase {
    /**
     * Declaring accounts and transfers arraylists as databases basically are the same as tables in a SQL System
     * */
    private static List<Account> accounts = new ArrayList<Account>();// Maybe use hashmap
    private static List<Transfer> transfers = new ArrayList<Transfer>();// Maybe use hashmap

    public static void addAccount(Account account){
        System.out.println(account.getAccountID());
        accounts.add(account);
    }

    public static Account getAccount(UUID id){
        if (!(Utils.isAccountValid(id)))
            throw new IllegalArgumentException("Account Doesnt Exist");
        return accounts.stream().parallel().filter(account -> account.getAccountID().equals(id)).findFirst().orElse(null);
    }

    public static List<Account> getAccounts(){
        return accounts;
    }
    public static void addAccount(Transfer transfer){
        transfers.add(transfer);
    }

    public static int getDBSIZE(){
        return accounts.size();
    }

}
