package com.helena.ruiz.products.microserviceproducts.repository;

import com.helena.ruiz.products.microserviceproducts.model.dto.TypeProductDto;

public interface ITypeProductRepository {
  public TypeProductDto getById(Long id);

  public boolean deleteById(Long id);

  public TypeProductDto createProduct(TypeProductDto productDto);

  public TypeProductDto updateProduct(TypeProductDto productDto);
}
