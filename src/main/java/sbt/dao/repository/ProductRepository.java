package sbt.dao.repository;

import org.springframework.data.repository.CrudRepository;
import sbt.dao.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
