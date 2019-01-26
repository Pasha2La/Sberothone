package sbt.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import sbt.dao.model.AccountReceipt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountReceiptMapper implements RowMapper<AccountReceipt> {
    @Override
    public AccountReceipt mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AccountReceipt(
                rs.getLong(1),
                rs.getLong(2)
        );
    }
}
