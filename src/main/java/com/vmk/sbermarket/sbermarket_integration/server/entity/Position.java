package com.vmk.sbermarket.sbermarket_integration.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
@Entity
@Table(name = "positions")
public class Position {
    @Id
    @Column(name = "id_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pk;
    @Column(name = "id")
    @JsonProperty("id")
    private String id;
    @Column(name = "original_quantity")
    @JsonProperty("originalQuantity")
    private int originalQuantity;
    @Column(name = "quantity")
    @JsonProperty("quantity")
    private int quantity;
    @Column(name = "price")
    @JsonProperty("price")
    private String price;
    @Column(name = "discount_price")
    @JsonProperty("discountPrice")
    private String discountPrice;
    @Column(name = "weight")
    @JsonProperty("weight")
    private String weight;
    @Column(name = "total_price")
    @JsonProperty("totalPrice")
    private String totalPrice;
    @Column(name = "total_discount_price")
    @JsonProperty("totalDiscountPrice")
    private String totalDiscountPrice;

    public Position() {
    }

    public Position(String id, int originalQuantity, int quantity, String price, String discountPrice, String weight, String totalPrice, String totalDiscountPrice) {
        this.id = id;
        this.originalQuantity = originalQuantity;
        this.quantity = quantity;
        this.price = price;
        this.discountPrice = discountPrice;
        this.weight = weight;
        this.totalPrice = totalPrice;
        this.totalDiscountPrice = totalDiscountPrice;
    }

    public int getId_pk() {
        return id_pk;
    }

    public void setId_pk(int id_pk) {
        this.id_pk = id_pk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public int getOriginalQuantity() {
        return originalQuantity;
    }

    public void setOriginalQuantity(int originalQuantity) {
        this.originalQuantity = originalQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public void setTotalDiscountPrice(String totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id_pk=" + id_pk +
                ", id='" + id + '\'' +
                ", originalQuantity=" + originalQuantity +
                ", quantity=" + quantity +
                ", price='" + price + '\'' +
                ", discountPrice='" + discountPrice + '\'' +
                ", weight='" + weight + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", totalDiscountPrice='" + totalDiscountPrice + '\'' +
                '}';
    }
}
