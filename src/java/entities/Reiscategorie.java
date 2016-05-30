/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "reiscategorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reiscategorie.findAll", query = "SELECT r FROM Reiscategorie r"),
    @NamedQuery(name = "Reiscategorie.findById", query = "SELECT r FROM Reiscategorie r WHERE r.id = :id"),
    @NamedQuery(name = "Reiscategorie.findByNaam", query = "SELECT r FROM Reiscategorie r WHERE r.naam = :naam")})
public class Reiscategorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naam")
    private String naam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reiscategorieId")
    private List<Reis> reisList;

    public Reiscategorie() {
    }

    public Reiscategorie(Integer id) {
        this.id = id;
    }

    public Reiscategorie(Integer id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @XmlTransient
    public List<Reis> getReisList() {
        return reisList;
    }

    public void setReisList(List<Reis> reisList) {
        this.reisList = reisList;
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
        if (!(object instanceof Reiscategorie)) {
            return false;
        }
        Reiscategorie other = (Reiscategorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reiscategorie[ id=" + id + " ]";
    }
    
}
