package sbt.dao.model;

public class AccountReceipt {

    private Long idAccount;
    private Long idReceipt;

    public AccountReceipt(Long idAccount, Long idReceipt) {
        this.idAccount = idAccount;
        this.idReceipt = idReceipt;
    }

    @Override
    public String toString() {
        return "AccountReceipt{" +
                "idAccount=" + idAccount +
                ", idReceipt=" + idReceipt +
                '}';
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public Long getIdReceipt() {
        return idReceipt;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public void setIdReceipt(Long idReceipt) {
        this.idReceipt = idReceipt;
    }
}
