package com.kanwen.ecommercerestapi.service;

import com.kanwen.ecommercerestapi.model.LocalUser;
import com.kanwen.ecommercerestapi.model.WebOrder;
import com.kanwen.ecommercerestapi.model.dao.WebOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private WebOrderDAO webOrderDAO;

    public List<WebOrder> getOrders(LocalUser user) {
        return webOrderDAO.findByUser(user);

    }

}
