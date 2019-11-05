package Utils;

import Models.Account;
import Storage.BankDatabase;

import java.util.List;
import java.util.UUID;

public class Utils {
    public static UUID generateId(){
        UUID newId = UUID.randomUUID();
        return newId;
    }

    public static boolean isAccountValid(UUID id){
        List<Account> accounts = BankDatabase.getAccounts();
        for (int i = 0;i<accounts.size();i++){
            if (accounts.get(i).getAccountID().equals(id)) {
                return true;

            }
        }
        return false;
    }
}
