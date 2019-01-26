package sbt.dao.repository;

import org.springframework.data.repository.CrudRepository;
import sbt.dao.model.Receipt;
import sbt.data.LoginInfo;

public interface ReceiptRepository extends CrudRepository<Receipt, Integer> {
}
