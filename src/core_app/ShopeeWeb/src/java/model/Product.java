package model;

public class Product {

    private int id;
    private int shopId; // Khớp với cột shop_id trong Database
    private String name;
    private String description;
    private double price;
    private String imageUrl; // Khớp với hàm setImageUrl bị lỗi

    // Constructor rỗng (Bắt buộc phải có để DAO dùng)
    public Product() {
    }

    // Constructor đầy đủ
    public Product(int id, int shopId, String name, String description, double price, String imageUrl) {
        this.id = id;
        this.shopId = shopId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // --- CÁC HÀM GETTER & SETTER ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
