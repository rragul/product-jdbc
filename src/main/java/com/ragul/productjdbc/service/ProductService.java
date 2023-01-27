package com.ragul.productjdbc.service;

import com.ragul.productjdbc.dao.ProductDao;
import com.ragul.productjdbc.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts(){
        return productDao.selectProducts();
    }

    public String addProduct(Product product){
        int result = productDao.insertProduct(product);
        if(result == 1){
            return "Product add Successfully";
        }else {
            return "Product add Failed";
        }
    }

    public void deleteProduct(Long id){
        Optional<Product> product = productDao.selectProductById(id);
        product.ifPresentOrElse(p -> {
            int result = productDao.deleteProduct(id);
            if (result != 1){
                throw new IllegalStateException("could not delete product");
            }
        }, () -> {
            throw new RuntimeException();
                }
        );
    }

    public Optional<Product> getProductById(Long id) {
        return productDao.selectProductById(id);
    }

    public void updateProduct(Long id, Product product){
        Optional<Product> existingProduct = productDao.selectProductById(id);
        existingProduct.ifPresentOrElse(p -> {
                    int result = productDao.updateProduct(id, product);
                    if (result != 1){
                        throw new IllegalStateException("could not found product");
                    }
                }, () -> {
                    throw new RuntimeException();
                }
        );
    }

}
