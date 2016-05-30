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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "klant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klant.findAll", query = "SELECT k FROM Klant k"),
    @NamedQuery(name = "Klant.findById", query = "SELECT k FROM Klant k WHERE k.id = :id"),
    @NamedQuery(name = "Klant.findByNaam", query = "SELECT k FROM Klant k WHERE k.naam = :naam"),
    @NamedQuery(name = "Klant.findByEmail", query = "SELECT k FROM Klant k WHERE k.email = :email"),
    @NamedQuery(name = "Klant.findByPaswoord", query = "SELECT k FROM Klant k WHERE k.paswoord = :paswoord"),
    @NamedQuery(name = "Klant.findByTelefoonnr", query = "SELECT k FROM Klant k WHERE k.telefoonnr = :telefoonnr"),
    @NamedQuery(name = "Klant.findByAdres", query = "SELECT k FROM Klant k WHERE k.adres = :adres"),
    @NamedQuery(name = "Klant.findByStad", query = "SELECT k FROM Klant k WHERE k.stad = :stad"),
    @NamedQuery(name = "Klant.findByPostcode", query = "SELECT k FROM Klant k WHERE k.postcode = :postcode")})
public class Klant implements Serializable {

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
    
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "paswoord")
    private String paswoord;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefoonnr")
    private long telefoonnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "adres")
    private String adres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "stad")
    private String stad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postcode")
    private long postcode;
    @JoinTable(name = "bestelde_reis", joinColumns = {
        @JoinColumn(name = "klant_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "reis_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Reis> reisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klant")
    private List<Bestelling> bestellingList;

    public Klant() {
    }

    public Klant(Integer id) {
        this.id = id;
    }

    public Klant(Integer id, String naam, String email, String paswoord, long telefoonnr, String adres, String stad, long postcode) {
        this.id = id;
        this.naam = naam;
        this.email = email;
        this.paswoord = paswoord;
        this.telefoonnr = telefoonnr;
        this.adres = adres;
        this.stad = stad;
        this.postcode = postcode;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    public long getTelefoonnr() {
        return telefoonnr;
    }

    public void setTelefoonnr(long telefoonnr) {
        this.telefoonnr = telefoonnr;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public long getPostcode() {
        return postcode;
    }

    public void setPostcode(long postcode) {
        this.postcode = postcode;
    }

    @XmlTransient
    public List<Reis> getReisList() {
        return reisList;
    }

    public void setReisList(List<Reis> reisList) {
        this.reisList = reisList;
    }

    @XmlTransient
    public List<Bestelling> getBestellingList() {
        return bestellingList;
    }

    public void setBestellingList(List<Bestelling> bestellingList) {
        this.bestellingList = bestellingList;
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
        if (!(object instanceof Klant)) {
            return false;
        }
        Klant other = (Klant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Klant[ id=" + id + " ]";
    }
    
}
