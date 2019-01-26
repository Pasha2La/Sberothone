package sbt.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import sbt.dao.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
          rs.getLong(1),
          rs.getString(2),
          rs.getString(3)
        );
    }
}
