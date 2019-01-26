package sbt.dao.repository;

import org.springframework.data.repository.CrudRepository;
import sbt.dao.model.Receipt;

public interface ReceiptRepository extends CrudRepository<Receipt, Long> {
}
