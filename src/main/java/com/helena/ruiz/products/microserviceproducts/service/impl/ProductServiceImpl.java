package com.helena.ruiz.products.microserviceproducts.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helena.ruiz.products.microserviceproducts.model.dto.ProductDto;
import com.helena.ruiz.products.microserviceproducts.model.dto.TypeProductDto;
import com.helena.ruiz.products.microserviceproducts.repository.IProductRepository;
import com.helena.ruiz.products.microserviceproducts.repository.ITypeProductRepository;
import com.helena.ruiz.products.microserviceproducts.service.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

  @Autowired
  private final IProductRepository iRepository;
  @Autowired
  private final ITypeProductRepository typeProductRepository;

  @Override
  public ProductDto createProduct(ProductDto productDto) {
    TypeProductDto typeProductDto = typeProductRepository.getById(productDto.getType().getId());
    if (typeProductDto == null) {
      throw new NoSuchElementException("Type product does not exist");
    }

    return iRepository.createProduct(productDto);
  }

  @Override
  public ProductDto getProductById(Long id) {
    return iRepository.getById(id);
  }

  @Override
  public ProductDto updateProduct(Long id, ProductDto productDtoUpdate) {
    ProductDto productSearch = iRepository.getById(id);
    if (productSearch != null) {
      productSearch.setName(productDtoUpdate.getName());
      productSearch.setDescription(productDtoUpdate.getDescription());
      productSearch.setPrice(productDtoUpdate.getPrice());
      productSearch.setQuantity(productDtoUpdate.getQuantity());
      productSearch.setType(productDtoUpdate.getType());

      return iRepository.updateProduct(productSearch);
    } else {
      return null;
    }
  }

  @Override
  public boolean deleteProduct(Long id) {
    try {
      iRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
