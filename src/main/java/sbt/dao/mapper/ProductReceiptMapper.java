package sbt.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import sbt.dao.model.ProductReceipt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductReceiptMapper implements RowMapper<ProductReceipt> {
    @Override
    public ProductReceipt mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductReceipt(
                rs.getLong(1),
                rs.getLong(2),
                rs.getLong(3)
        );
    }
}
