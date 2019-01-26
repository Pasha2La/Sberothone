package sbt.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import sbt.dao.model.Receipt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptMapper implements RowMapper<Receipt> {
    @Override
    public Receipt mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Receipt(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getLong(5),
                rs.getLong(6),
                rs.getString(7),
                rs.getLong(8)
        );
    }
}
