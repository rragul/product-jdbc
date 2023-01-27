package com.ragul.productjdbc.repository;

import com.ragul.productjdbc.dao.ProductDao;
import com.ragul.productjdbc.entity.Product;
import com.ragul.productjdbc.mapper.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Product> selectProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public int insertProduct(Product product) {
        String sql = "INSERT INTO product( id, name, description, price, quantity) VALUES (?, ?, ?, ? , ?) ";
        return jdbcTemplate.update(sql,
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }

    @Override
    public int deleteProduct(Long id) {
        String sql = """
                DELETE FROM product   
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Product> selectProductById(Long id) {
        String sql = """
                SELECT *
                FROM product
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new ProductRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int updateProduct(Long id, Product product) {
        String sql = """
                UPDATE product
                SET name=?, description=?, price=? ,quantity=?
                WHERE id = ?
                 """;
        return jdbcTemplate.update(sql,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                id
                );
    }


}
