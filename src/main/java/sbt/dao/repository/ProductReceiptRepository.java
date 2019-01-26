package sbt.dao.repository;

import org.springframework.data.repository.CrudRepository;
import sbt.dao.model.ProductReceipt;

public interface ProductReceiptRepository extends CrudRepository<ProductReceipt, Long> {
}
