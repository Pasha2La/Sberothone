package sbt.dao.model;

public class Receipt {

    private Long id;
    private String name;
    private String description;
    private String coockingTime;
    private Long calories;
    private Long category;
    private Boolean isHealthy;

    public Receipt(Long id, String name, String description, String coockingTime, Long calories, Long category, Boolean isHealthy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.coockingTime = coockingTime;
        this.calories = calories;
        this.category = category;
        this.isHealthy = isHealthy;
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
                ", isHealthy=" + isHealthy +
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

    public Boolean getHealthy() {
        return isHealthy;
    }

    public void setHealthy(Boolean healthy) {
        isHealthy = healthy;
    }
}
