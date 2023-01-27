package com.ragul.productjdbc.dao;

import com.ragul.productjdbc.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    List<Product> selectProducts();
    int insertProduct(Product product);
    int deleteProduct(Long id);
    Optional<Product> selectProductById(Long id);

    int updateProduct(Long id, Product product);
}
