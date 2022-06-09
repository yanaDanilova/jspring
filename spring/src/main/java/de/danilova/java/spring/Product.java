package de.danilova.java.spring;

public class Product {
    private Integer id;
    private String title;

    public Product(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
