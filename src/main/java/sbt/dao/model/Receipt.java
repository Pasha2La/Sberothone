package sbt.dao.model;

import javax.persistence.*;

@Entity
@Table(name="sberfood_receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="n_id")
    private Long id;
    @Column(name="c_name")
    private String name;
    @Column(name="c_description")
    private String description;
    @Column(name="c_coocking_time")
    private String coockingTime;
    @Column(name="n_calories")
    private Long calories;
    @Column(name="n_category")
    private Long category;
    @Column(name="c_healthy")
    private String healthy;

    public Receipt() {
    }

    public Receipt(Long id, String name, String description, String coockingTime, Long calories, Long category, String healthy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.coockingTime = coockingTime;
        this.calories = calories;
        this.category = category;
        this.healthy = healthy;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coockingTime='" + coockingTime + '\'' +
                ", calories=" + calories +
                ", category=" + category +
                ", healthy=" + healthy +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoockingTime() {
        return coockingTime;
    }

    public void setCoockingTime(String coockingTime) {
        this.coockingTime = coockingTime;
    }

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getHealthy() {
        return healthy;
    }

    public void setHealthy(String healthy) {
        this.healthy = healthy;
    }
}
