package com.helena.ruiz.products.microserviceproducts.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helena.ruiz.products.microserviceproducts.model.ProductModel;
import com.helena.ruiz.products.microserviceproducts.model.TypeProductModel;
import com.helena.ruiz.products.microserviceproducts.model.dto.ProductDto;
import com.helena.ruiz.products.microserviceproducts.model.dto.TypeProductDto;

public class ModelMapper {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static TypeProductDto convertToTypeProductDto(TypeProductModel typeProductModel) {
    return objectMapper.convertValue(typeProductModel, TypeProductDto.class);
  }

  public static ProductDto convertToProductDto(ProductModel productModel) {
    return objectMapper.convertValue(productModel, ProductDto.class);
  }

  public static TypeProductModel convertToTypeProductModel(TypeProductDto typeProductDto) {
    return objectMapper.convertValue(typeProductDto, TypeProductModel.class);
  }

  public static ProductModel convertToProductModel(ProductDto productDto) {
    return objectMapper.convertValue(productDto, ProductModel.class);
  }
}
