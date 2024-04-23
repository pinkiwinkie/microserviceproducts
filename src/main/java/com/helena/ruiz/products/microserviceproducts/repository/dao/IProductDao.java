package com.helena.ruiz.products.microserviceproducts.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helena.ruiz.products.microserviceproducts.model.ProductModel;

public interface IProductDao extends JpaRepository<ProductModel, Long>{
  
}
