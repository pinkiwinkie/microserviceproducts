package com.helena.ruiz.products.microserviceproducts.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helena.ruiz.products.microserviceproducts.model.TypeProductModel;

public interface IProductTypeDao extends JpaRepository<TypeProductModel, Long>{
  
}
