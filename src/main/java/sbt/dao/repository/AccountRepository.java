package sbt.dao.repository;

import org.springframework.data.repository.CrudRepository;
import sbt.dao.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
