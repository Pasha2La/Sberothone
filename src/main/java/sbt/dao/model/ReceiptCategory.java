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
}
