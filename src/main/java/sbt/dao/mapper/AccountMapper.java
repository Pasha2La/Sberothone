package sbt.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import sbt.dao.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Account(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getBoolean(4),
                rs.getTimestamp(5));
    }
}
