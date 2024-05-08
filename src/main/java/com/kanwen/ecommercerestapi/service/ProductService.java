package com.kanwen.ecommercerestapi.service;

import com.kanwen.ecommercerestapi.model.Product;
import com.kanwen.ecommercerestapi.model.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }
}
