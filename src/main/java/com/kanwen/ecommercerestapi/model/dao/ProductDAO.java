package com.kanwen.ecommercerestapi.model.dao;

import com.kanwen.ecommercerestapi.model.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends ListCrudRepository<Product, Long> {


}
