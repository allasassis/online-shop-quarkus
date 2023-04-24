package com.online.repository;

import com.online.model.Order;
import com.online.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

    public List<Order> findByPaid(boolean paid) {
        return list("paid", paid);
    }
}
