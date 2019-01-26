package sbt.dao;

import sbt.dao.model.Account;
import sbt.dao.model.Receipt;
import sbt.data.LoginInfo;

import java.util.List;

public interface Dao {
    /*public List<Receipt> filteredSearch(List<String> products,
                                        List<String> categories,
                                        String healthy);
*/
    List<Account> example();
}
