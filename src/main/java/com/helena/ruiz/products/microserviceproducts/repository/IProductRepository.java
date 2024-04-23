package com.helena.ruiz.products.microserviceproducts.repository;

import com.helena.ruiz.products.microserviceproducts.model.dto.ProductDto;

public interface IProductRepository {
  public ProductDto getById(Long id);

  public boolean deleteById(Long id);

  public ProductDto createProduct(ProductDto productDto);

  public ProductDto updateProduct(ProductDto productDto);
}
