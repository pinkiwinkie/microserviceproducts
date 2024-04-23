package com.helena.ruiz.products.microserviceproducts.model.dto;

public class TypeProductDto {
  private Long id;
  private String description;

  public TypeProductDto() {
  }

  public TypeProductDto(Long id, String description) {
    this.id = id;
    this.description = description;
  }

  public Long getId() {
    return id;
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
