package sbt.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sberfood_receipt_category")
public class ReceiptCategory {

    @Id
    @Column(name="n_receipt_id")
    private Long idReceipt;
    @Column(name="n_category_id")
    private Long idCategory;

    public ReceiptCategory() {
    }

    public ReceiptCategory(Long idReceipt, Long idCategory) {
        this.idReceipt = idReceipt;
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "ReceiptCategory{" +
                "idReceipt=" + idReceipt +
                ", idCategory=" + idCategory +
                '}';
    }

    public Long getIdReceipt() {
        return idReceipt;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdReceipt(Long idReceipt) {
        this.idReceipt = idReceipt;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }
}
