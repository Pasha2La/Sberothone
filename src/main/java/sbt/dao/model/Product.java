package sbt.dao.model;

public class Product {

    private Long id;
    private String name;
    private String measureType;

    public Product(Long id, String name, String measureType) {
        this.id = id;
        this.name = name;
        this.measureType = measureType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measureType='" + measureType + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMeasureType() {
        return measureType;
    }
}