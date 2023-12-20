package model;

public class Product {

    private String itemID;
    private String productID;
    private String description;
    private String inStock;
    private String quantity;
    private String listPrice;
    private String totalCoast;

    public Product() {
    }

    public Product(String itemID, String productID, String description, String inStock, String quantity, String listPrice, String totalCoast) {
        this.itemID = itemID;
        this.productID = productID;
        this.description = description;
        this.inStock = inStock;
        this.quantity = quantity;
        this.listPrice = listPrice;
        this.totalCoast = totalCoast;
    }

    public String getItemID() {
        return itemID;
    }

    public String getProductID() {
        return productID;
    }

    public String getDescription() {
        return description;
    }

    public String getInStock() {
        return inStock;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getListPrice() {
        return listPrice;
    }

    public String getTotalCoast() {
        return totalCoast;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public void setTotalCoast(String totalCoast) {
        this.totalCoast = totalCoast;
    }
}
