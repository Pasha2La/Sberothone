package sbt.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import sbt.dao.model.ReceiptCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptCategoryMapper implements RowMapper<ReceiptCategory> {
    @Override
    public ReceiptCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ReceiptCategory(
                rs.getLong(1),
                rs.getLong(2)
        );
    }
}
