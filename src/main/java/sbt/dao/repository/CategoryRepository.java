package sbt.dao.repository;

import org.springframework.data.repository.CrudRepository;
import sbt.dao.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
