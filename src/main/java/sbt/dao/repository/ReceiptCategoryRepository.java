package sbt.dao.repository;

import org.springframework.data.repository.CrudRepository;
import sbt.dao.model.ReceiptCategory;

public interface ReceiptCategoryRepository extends CrudRepository<ReceiptCategory, Long> {
}
