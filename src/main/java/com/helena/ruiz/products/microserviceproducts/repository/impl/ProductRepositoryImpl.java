package com.helena.ruiz.products.microserviceproducts.repository.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.helena.ruiz.products.microserviceproducts.model.ProductModel;
import com.helena.ruiz.products.microserviceproducts.model.dto.ProductDto;
import com.helena.ruiz.products.microserviceproducts.repository.IProductRepository;
import com.helena.ruiz.products.microserviceproducts.repository.dao.IProductDao;
import com.helena.ruiz.products.microserviceproducts.utils.ModelMapper;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
  @Autowired
  public
  IProductDao iProductDao;

  @Override
  public ProductDto getById(Long id) {
    ProductModel product = iProductDao.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Product does not exist"));
    return ModelMapper.convertToProductDto(product);
  }

  @Override
  public boolean deleteById(Long id) {
    if (iProductDao.existsById(id)) {
      iProductDao.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public ProductDto createProduct(ProductDto productDto) {
    ProductModel productModel = ModelMapper.convertToProductModel(productDto);
    productModel = iProductDao.save(productModel);
    ProductDto productDto2 = ModelMapper.convertToProductDto(productModel);
    return productDto2;
  }

  @Override
  public ProductDto updateProduct(ProductDto productDto) {
    if (!iProductDao.existsById(productDto.getId())) {
      throw new NoSuchElementException("Product does not exist");
    }

    ProductModel productModel = ModelMapper.convertToProductModel(productDto);
    productModel = iProductDao.save(productModel);
    return ModelMapper.convertToProductDto(productModel);
  }

}
