/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mw.customers.model;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maciek
 */
@Stateless
@LocalBean
public class CustomersDAO extends AbstractDAO<Customers> {
    

    @PersistenceContext(unitName = "CustomersProjectPU")
    private EntityManager em;
    
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public CustomersDAO() {
        super(Customers.class);
    }
    
    public List<Customers> getAllCustomers() {
        return em.createNamedQuery("Customers.findAll").getResultList();
    }
    
    public Customers update(Customers customer) {
        return em.merge(customer);
    }
    
    public void persist(Customers customer) {
        em.persist(customer);
    }
    
    public void delete(Customers customer) {
        em.remove(em.merge(customer));
    }

  
    
   
}
