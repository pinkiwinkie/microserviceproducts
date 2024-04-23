package com.helena.ruiz.products.microserviceproducts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helena.ruiz.products.microserviceproducts.model.dto.ProductDto;
import com.helena.ruiz.products.microserviceproducts.service.impl.ProductServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Tag(name = "Products resource")
public class ProductController {
  @Autowired
  private final ProductServiceImpl productService;

  @PostMapping("/products")
  @Operation(summary = "post in DB a product in the database from body")
  public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product) {
    ProductDto productDto = productService.createProduct(product);
    return new ResponseEntity<>(productDto, HttpStatus.CREATED);
  }

  @GetMapping("/products/{id}")
  @Operation(summary = "get a product with his id")
  public ResponseEntity<ProductDto> getById(@PathVariable("id") Long id) {
    try {
      ProductDto productDto = productService.getProductById(id);
      return new ResponseEntity<>(productDto, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
  
  @PutMapping("/products/{id}")
  @Operation(summary = "update in DB a product from body")
  public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id,
  @RequestBody ProductDto updatedProduct) {
    try {
      ProductDto productDto = productService.updateProduct(id, updatedProduct);
      if (productDto != null) {
        return ResponseEntity.ok(productDto);
      } else {
        return ResponseEntity.notFound().build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
  
  @DeleteMapping("/products/{id}")
  @Operation(summary = "delete in DB a product")
  public ResponseEntity<ProductDto> deleteById(@PathVariable("id") Long id) {
    try {
      productService.deleteProduct(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
