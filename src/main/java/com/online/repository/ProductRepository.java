package com.online.repository;

import com.online.model.Category;
import com.online.model.OrderItem;
import com.online.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

    @Inject
    EntityManager entityManager;

    public boolean productExists(String name, String brand, Category category) {
        return find("name = ?1 and brand = ?2 and category = ?3", name, brand, category).firstResultOptional().isPresent();
    }

    public Product findByName(String name) {
        Session session = getEntityManager().unwrap(Session.class);
        Criteria criteria = session.createCriteria(Product.class);
        criteria.add(Restrictions.eq("name", name));
        return (Product) criteria.uniqueResult();
    }

}
