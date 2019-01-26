package sbt.data;

import sbt.dao.model.Category;
import sbt.dao.model.Product;

public class BaseInfo {
    Iterable<Category> categories;

    Iterable<Product> products;

    public Iterable<Category> getCategories() {
        return categories;
    }

    public void setCategories(Iterable<Category> categories) {
        this.categories = categories;
    }

    public Iterable<Product> getProducts() {
        return products;
    }

    public void setProducts(Iterable<Product> products) {
        this.products = products;
    }

    public BaseInfo(Iterable<Category> categories, Iterable<Product> products) {
        this.categories = categories;
        this.products = products;
    }

}
