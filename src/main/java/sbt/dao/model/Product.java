package sbt.dao.model;

import javax.persistence.*;

@Entity
@Table(name="sberfood_product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="n_id")
    private Long id;
    @Column(name="c_name")
    private String name;
    @Column(name="c_measure_type")
    private String measureType;

    public Product() {
    }

    public Product(Long id, String name, String measureType) {
        this.id = id;
        this.name = name;
        this.measureType = measureType;
    }

    public Product(String name, String measureType) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }
}
