package sbt.dao.model;

import javax.persistence.*;

@Entity
@Table(name="sberfood_account_receipt")
public class AccountReceipt {

    @Id
    @Column(name="n_account_id")
    private Long idAccount;
    @Column(name="n_receipt_id")
    private Long idReceipt;

    public AccountReceipt() {
    }

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
