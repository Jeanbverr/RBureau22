/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "reis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reis.findAll", query = "SELECT r FROM Reis r"),
    @NamedQuery(name = "Reis.findById", query = "SELECT r FROM Reis r WHERE r.id = :id"),
    @NamedQuery(name = "Reis.findByLocatie", query = "SELECT r FROM Reis r WHERE r.locatie = :locatie"),
    @NamedQuery(name = "Reis.findByLand", query = "SELECT r FROM Reis r WHERE r.land = :land"),
    @NamedQuery(name = "Reis.findByPrijs", query = "SELECT r FROM Reis r WHERE r.prijs = :prijs"),
    @NamedQuery(name = "Reis.findByBeschrijving", query = "SELECT r FROM Reis r WHERE r.beschrijving = :beschrijving"),
    @NamedQuery(name = "Reis.findByVertrekdatum", query = "SELECT r FROM Reis r WHERE r.vertrekdatum = :vertrekdatum"),
    @NamedQuery(name = "Reis.findByTerugdatum", query = "SELECT r FROM Reis r WHERE r.terugdatum = :terugdatum")})
public class Reis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "locatie")
    private String locatie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "land")
    private String land;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prijs")
    private BigDecimal prijs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "beschrijving")
    private String beschrijving;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vertrekdatum")
    private String vertrekdatum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "terugdatum")
    private String terugdatum;
    @JoinColumn(name = "reiscategorie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Reiscategorie reiscategorieId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reis")
    private List<BesteldeReis> besteldeReisList;

    public Reis() {
    }

    public Reis(Integer id) {
        this.id = id;
    }

    public Reis(Integer id, String locatie, String land, BigDecimal prijs, String beschrijving, String vertrekdatum, String terugdatum) {
        this.id = id;
        this.locatie = locatie;
        this.land = land;
        this.prijs = prijs;
        this.beschrijving = beschrijving;
        this.vertrekdatum = vertrekdatum;
        this.terugdatum = terugdatum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getVertrekdatum() {
        return vertrekdatum;
    }

    public void setVertrekdatum(String vertrekdatum) {
        this.vertrekdatum = vertrekdatum;
    }

    public String getTerugdatum() {
        return terugdatum;
    }

    public void setTerugdatum(String terugdatum) {
        this.terugdatum = terugdatum;
    }

    public Reiscategorie getReiscategorieId() {
        return reiscategorieId;
    }

    public void setReiscategorieId(Reiscategorie reiscategorieId) {
        this.reiscategorieId = reiscategorieId;
    }

    @XmlTransient
    public List<BesteldeReis> getBesteldeReisList() {
        return besteldeReisList;
    }

    public void setBesteldeReisList(List<BesteldeReis> besteldeReisList) {
        this.besteldeReisList = besteldeReisList;
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
        if (!(object instanceof Reis)) {
            return false;
        }
        Reis other = (Reis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reis[ id=" + id + " ]";
    }
    
}
