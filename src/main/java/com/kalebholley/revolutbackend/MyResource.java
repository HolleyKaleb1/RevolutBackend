package com.kalebholley.revolutbackend;

import Models.Account;
import Services.AccountService;
import Services.TransferService;
import Storage.BankDatabase;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/{accountId}/getAccount")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAccount(
            @PathParam("accountId") UUID accountId
                    ) {
        AccountService accountService = new AccountService();
        Account account = accountService.getAccount(accountId);

        JSONObject accountObject = new JSONObject();
        accountObject.put("accountId",account.getAccountID());
        accountObject.put("accountBalance",account.getBalance());
        return accountObject.toString();
    }

    @POST
    @Path("/{initialAmount}/createAccount")
    @Produces(MediaType.TEXT_PLAIN)
    public String addAccount(
            @PathParam("initialAmount") BigDecimal initialAmount
            ){

        AccountService newAccount = new AccountService();
        UUID id = newAccount.addAccount(initialAmount);
        JSONObject account = new JSONObject();
        account.put("Your Account number is ", id);
        return "Account Created! :"+ account.toString();
    }

    @POST
    @Path("/{fromAccount}/{toAccount}/{amount}/transfer")
    @Produces(MediaType.TEXT_PLAIN)
    public String transfer(
            @PathParam("amount") BigDecimal amount,
            @PathParam("toAccount") UUID toAccount,
            @PathParam("fromAccount") UUID fromAccount){

        TransferService transfer = new TransferService();
        transfer.transferMoney(fromAccount,toAccount,amount);
        System.out.println(BankDatabase.getDBSIZE());
        System.out.println(BankDatabase.getAccount(fromAccount).getBalance());
        System.out.println(BankDatabase.getAccount(toAccount).getBalance());
        JSONObject transferring = new JSONObject();
        transferring.put("status","transfer was successful");
        return transferring.toString();
    }
}
