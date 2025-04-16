package com.cboard.marketplace.marketplace_common;

import jakarta.validation.constraints.NotNull;

public class ProductDto extends ItemDto
{
    @NotNull(message = "Quantity is required...")
    private Integer quantity;
    private String brand;

    public ProductDto() {
    }

    public ProductDto(int itemId, String name, String description, Double price, int userId, String category, String releaseDate, boolean available, String location, String itemType, String image_name, String image_type, byte[] image_date, Integer quantity, String brand)
    {
        super(itemId, name, description, price, userId, category, releaseDate, available, location, itemType, image_name, image_type, image_date);
        this.quantity = quantity;
        this.brand = brand;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
