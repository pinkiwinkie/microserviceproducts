package com.helena.ruiz.products.microserviceproducts.repository.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.helena.ruiz.products.microserviceproducts.model.TypeProductModel;
import com.helena.ruiz.products.microserviceproducts.model.dto.TypeProductDto;
import com.helena.ruiz.products.microserviceproducts.repository.ITypeProductRepository;
import com.helena.ruiz.products.microserviceproducts.repository.dao.IProductTypeDao;
import com.helena.ruiz.products.microserviceproducts.utils.ModelMapper;

@Repository
public class TypeProductRepositoryImpl implements ITypeProductRepository {

  @Autowired
  public IProductTypeDao iProductTypeDao;

  @Override
  public TypeProductDto getById(Long id) {
    TypeProductModel typeProduct = iProductTypeDao.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Type product does not exist"));
    return ModelMapper.convertToTypeProductDto(typeProduct);
  }

  @Override
  public boolean deleteById(Long id) {
    if (iProductTypeDao.existsById(id)) {
      iProductTypeDao.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public TypeProductDto createProduct(TypeProductDto productDto) {
    TypeProductModel typeProduct = ModelMapper.convertToTypeProductModel(productDto);
    typeProduct = iProductTypeDao.save(typeProduct);
    TypeProductDto typeProductDto = ModelMapper.convertToTypeProductDto(typeProduct);
    return typeProductDto;
  }

  @Override
  public TypeProductDto updateProduct(TypeProductDto productDto) {
    if(!iProductTypeDao.existsById(productDto.getId())) {
      throw new NoSuchElementException("Type product does not exist");
    }

    TypeProductModel typeProduct = ModelMapper.convertToTypeProductModel(productDto);
    typeProduct = iProductTypeDao.save(typeProduct);
    return ModelMapper.convertToTypeProductDto(typeProduct);
  }

}

