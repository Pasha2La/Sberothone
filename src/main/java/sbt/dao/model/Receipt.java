package sbt.dao.model;

public class Receipt {

    private Long id;
    private String name;
    private String description;
    private String coockingTime;
    private Long calories;
    private Long category;

    public Receipt(Long id, String name, String description, String coockingTime, Long calories, Long category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.coockingTime = coockingTime;
        this.calories = calories;
        this.category = category;
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
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCoockingTime() {
        return coockingTime;
    }

    public Long getCalories() {
        return calories;
    }

    public Long getCategory() {
        return category;
    }
}
