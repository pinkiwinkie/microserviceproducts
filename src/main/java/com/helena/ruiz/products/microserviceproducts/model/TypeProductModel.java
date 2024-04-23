package com.helena.ruiz.products.microserviceproducts.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TYPE_PRODUCT")
public class TypeProductModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  @OneToMany(mappedBy = "idTypeProduct")
  private List<ProductModel> listProducts;

  public TypeProductModel() {
  }

  public TypeProductModel(String description) {
    this.description = description;
  }

  
  public TypeProductModel(Long id,String description) {
    this.id = id;
    this.description = description;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}