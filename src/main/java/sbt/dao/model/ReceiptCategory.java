package sbt.dao.model;

public class ReceiptCategory {

    private Long idReceipt;
    private Long idCategory;

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
