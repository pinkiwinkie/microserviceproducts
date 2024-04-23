package com.helena.ruiz.products.microserviceproducts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, name = "name")
  private String name;
  @Column(nullable = false, name = "description")
  private String description;
  @Column(name = "quantity")
  private int quantity;
  @Column(nullable = false, name = "price")
  private float price;
  @ManyToOne
  @JoinColumn(name = "type_id")
  private TypeProductModel idTypeProduct;

  public ProductModel() {

  }

  public ProductModel(String name, String description, int quantity, float price, TypeProductModel idTypeProduct) {
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
    this.idTypeProduct = idTypeProduct;
  }

  public ProductModel(Long id, String name, String description, int quantity, float price, TypeProductModel idTypeProduct) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
    this.idTypeProduct = idTypeProduct;
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

  public TypeProductModel getType() {
    return this.idTypeProduct;
  }

  public void setType(TypeProductModel idTypeProduct) {
    this.idTypeProduct = idTypeProduct;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
        + ", price=" + price + ", type=" + idTypeProduct + "]";
  }
}
