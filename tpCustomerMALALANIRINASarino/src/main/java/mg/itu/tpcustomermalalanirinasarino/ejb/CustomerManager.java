/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpcustomermalalanirinasarino.ejb;

import jakarta.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mg.itu.tpcustomermalalanirinasarino.entities.Customer;

/**
 *
 * @author Sarino
 */
@Stateless
public class CustomerManager {
    @PersistenceContext
    private EntityManager em;

    public void persist(Customer customer) {
        em.persist(customer);
    }
    
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();  
    }  
        
    public Customer update(Customer customer) {
        return em.merge(customer);  
    }         
}
