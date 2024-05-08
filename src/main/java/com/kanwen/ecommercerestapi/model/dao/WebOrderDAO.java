package com.kanwen.ecommercerestapi.model.dao;

import com.kanwen.ecommercerestapi.model.LocalUser;
import com.kanwen.ecommercerestapi.model.WebOrder;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebOrderDAO extends ListCrudRepository<WebOrder, Long> {

    List<WebOrder> findByUser(LocalUser user);
}
