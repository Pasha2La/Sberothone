package sbt.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sberfood_product_receipt")
public class ProductReceipt {

    @Id
    @Column(name="n_receipt_id")
    private Long idReceipt;
    @Column(name="n_product_id")
    private Long idProduct;
    @Column(name="n_product_count")
    private Long productCount;

    public ProductReceipt() {
    }

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
