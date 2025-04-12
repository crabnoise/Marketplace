package com.cboard.marketplace.marketplace_backend.model;

import jakarta.persistence.Entity;
import com.cboard.marketplace.marketplace_common.*;

import jakarta.persistence.*;

@Entity
@Table(name = "request")
//@DiscriminatorValue("request")
public class Request extends Item
{
    private String deadline;

    public Request() {
    }

    public Request(int itemId, String name, String description, double price, Category category, String releaseDate, boolean available, Location location, String itemType, String image_name, String image_type, byte[] image_date, String deadline)
    {
        super(itemId, name, description, price, category, releaseDate, available, location, itemType, image_name, image_type, image_date);
        this.deadline = deadline;
    }


    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}