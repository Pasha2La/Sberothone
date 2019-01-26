package sbt.dao.model;

public class ProductReceipt {
    private Long idReceipt;
    private Long idProduct;
    private Long productCount;

    public ProductReceipt(Long idReceipt, Long idProduct, Long productCount) {
        this.idReceipt = idReceipt;
        this.idProduct = idProduct;
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "ProductReceipt{" +
                "idReceipt=" + idReceipt +
                ", idProduct=" + idProduct +
                ", productCount=" + productCount +
                '}';
    }

    public Long getIdReceipt() {
        return idReceipt;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setIdReceipt(Long idReceipt) {
        this.idReceipt = idReceipt;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }
}
