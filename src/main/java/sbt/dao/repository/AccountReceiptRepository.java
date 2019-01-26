package sbt.dao.repository;

import org.springframework.data.repository.CrudRepository;
import sbt.dao.model.AccountReceipt;

public interface AccountReceiptRepository extends CrudRepository<AccountReceipt, Long> {
}
