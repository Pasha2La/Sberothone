package sbt.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import sbt.dao.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Category(
                rs.getLong(1),
                rs.getString(2)
        );
    }
}
