package pl.mw.customers.mbeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import pl.mw.customers.model.Customers;
import pl.mw.customers.model.CustomersDAO;

/**
 *
 * @author Maciek
 */
@ManagedBean
@Named(value = "customerMBean")
@SessionScoped
public class CustomerMBean implements Serializable {

    @EJB
    private CustomersDAO customersDAO;
    private Customers customer;
    private List<Customers> customers;
    private Integer id;
    private Date joinDate;
    private String name;
    private String surname;
    private String phone;
    private String commentary;
    private List<Customers> listOfCustomersInSession = new ArrayList<Customers>();
    private int localId = 1;
    
    public CustomerMBean() {
    }

    public List<Customers> getAllCustomers() {
        customers = customersDAO.findAll();
        return customers;
    }
    
    public List<Customers> getAllSessionCustomers() {
         
        return listOfCustomersInSession;
    }
    
    public String createNewCustomer(){
        return "createCustomer";
    }
    
     public String createNewCustomerLocal(){
        return "createCustomerLocal";
    }

    public Customers getDetails() {
        return customer;
    }

    public String showDetails(Customers customer) {
        this.customer = customer;
        return "customerInfo";
    }

  

    public String update() {
        System.out.println("UPDATED");
        customer = customersDAO.update(customer);
        return "allCustomers";
    }

    public void delete(Customers customer) {
        System.out.println("DELETED " + customer.getId() + " " + customer.getName());
        customersDAO.remove(customer);
    }

    public void deleteInSession(Customers customer){
        listOfCustomersInSession.remove(customer);
    }
    
    public String create(Customers customer) {
        customer = new Customers(this.id, new Date(), this.name, this.surname, this.phone, this.commentary);
        System.out.println("CREATED");
        customersDAO.persist(customer);
        return "allCustomers";
    }
    
    
    public String createInSession(Customers customer){
        customer = new Customers(localId, new Date(), this.name, this.surname, this.phone, this.commentary);
        listOfCustomersInSession.add(customer);
        localId++;
        
        return "allCustomersLocal";
    }

    public String goLocalSession(){
        return "allCustomersLocal";
    }
    
     public String goSQLSession(){
        return "allCustomers";
    }
    
    public String list() {
        System.out.println("RETURN");
        return "allCustomers";
    }
    
    public boolean filterByFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        String cName = value.toString().toUpperCase();
        filterText = filterText.toUpperCase();

        if (cName.contains(filterText)) {
            return true;
        } else {
            return false;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

}
