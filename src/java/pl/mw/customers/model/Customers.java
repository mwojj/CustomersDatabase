/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mw.customers.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maciek
 */
@Entity
@Table(name = "CUSTOMERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
    , @NamedQuery(name = "Customers.findById", query = "SELECT c FROM Customers c WHERE c.id = :id")
    , @NamedQuery(name = "Customers.findByJoinDate", query = "SELECT c FROM Customers c WHERE c.joinDate = :joinDate")
    , @NamedQuery(name = "Customers.findByName", query = "SELECT c FROM Customers c WHERE c.name = :name")
    , @NamedQuery(name = "Customers.findBySurname", query = "SELECT c FROM Customers c WHERE c.surname = :surname")
    , @NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customers.findByCommentary", query = "SELECT c FROM Customers c WHERE c.commentary = :commentary")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ")
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOIN_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME", nullable = false, length = 20)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SURNAME", nullable = false, length = 30)
    private String surname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "PHONE", nullable = false, length = 14)
    private String phone;
    @Size(max = 50)
    @Column(name = "COMMENTARY", length = 50)
    private String commentary;

    
    
    
    
    public Customers() {
    }

    public Customers(Integer id) {
        this.id = id;
    }

    public Customers(Integer id, Date joinDate, String name, String surname, String phone) {
        this.id = id;
        this.joinDate = joinDate;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public Customers(Integer id, Date joinDate, String name, String surname, String phone, String commentary) {
        this.id = id;
        this.joinDate = joinDate;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.commentary = commentary;
    }
    

    
    public Customers(Date joinDate, String name, String surname, String phone, String commentary) {
        this.joinDate = joinDate;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.commentary = commentary;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.mw.customers.model.Customers[ id=" + id + " ]";
    }
    
}
