package com.helena.ruiz.products.microserviceproducts.model.dto;

public class ProductDto {
  private Long id;
  private String name;
  private String description;
  private int quantity;
  private float price;
  private TypeProductDto type;

  public ProductDto() {
  }

  public ProductDto(Long id, String name, String description, int quantity, float price, TypeProductDto type) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
    this.type = type;
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

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public TypeProductDto getType() {
    return type;
  }

  public void setType(TypeProductDto type) {
    this.type = type;
  }
}
