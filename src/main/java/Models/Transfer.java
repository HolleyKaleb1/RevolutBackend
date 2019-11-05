package Models;

import java.math.BigDecimal;
import java.util.UUID;

public class Transfer {
    private UUID  transferToAccount;
    private UUID transferFromAccount;
    private BigDecimal transferAmount;


    public Transfer(){}

    public Transfer(UUID toAccount, UUID fromAccount, BigDecimal amount){
        this.transferToAccount = toAccount;
        this.transferFromAccount = fromAccount;
        this.transferAmount = amount;

    }

    public UUID getTransferToAccount() {
        return transferToAccount;
    }

    public void setTransferToAccount(UUID transferToAccount) {
        this.transferToAccount = transferToAccount;
    }

    public UUID getTransferFromAccount() {
        return transferFromAccount;
    }

    public void setTransferFromAccount(UUID transferFromAccount) {
        this.transferFromAccount = transferFromAccount;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }
}
