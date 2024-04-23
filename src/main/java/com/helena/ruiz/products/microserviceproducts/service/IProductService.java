package com.helena.ruiz.products.microserviceproducts.service;

import com.helena.ruiz.products.microserviceproducts.model.dto.ProductDto;

public interface IProductService {
  ProductDto createProduct(ProductDto productDto);

  ProductDto getProductById(Long id);

  ProductDto updateProduct(Long id, ProductDto productDto);

  boolean deleteProduct(Long id);
}
