package com.online.repository;

import com.online.model.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    private static final Logger LOG = Logger.getLogger(CustomerRepository.class);

    public Customer findByEmail(String email) {
        Session session = getEntityManager().unwrap(Session.class);
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("email", email));
        return (Customer) criteria.uniqueResult();
    }
}
