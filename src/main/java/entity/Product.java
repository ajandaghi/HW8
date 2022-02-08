package entity;

public class Product {
    private Integer id;
    private Integer adminId;
    private Integer categoryId;
    private String name;

    public Product() {
    }

    public Product(Integer id, Integer adminId, Integer categoryId, String name) {
        this.id = id;
        this.adminId = adminId;
        this.categoryId = categoryId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
