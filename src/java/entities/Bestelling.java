/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "bestelling")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bestelling.findAll", query = "SELECT b FROM Bestelling b"),
    @NamedQuery(name = "Bestelling.findById", query = "SELECT b FROM Bestelling b WHERE b.id = :id"),
    @NamedQuery(name = "Bestelling.findByTotaal", query = "SELECT b FROM Bestelling b WHERE b.totaal = :totaal"),
    @NamedQuery(name = "Bestelling.findByDatumcreatie", query = "SELECT b FROM Bestelling b WHERE b.datumcreatie = :datumcreatie"),
    @NamedQuery(name = "Bestelling.findByConfirmatienummer", query = "SELECT b FROM Bestelling b WHERE b.confirmatienummer = :confirmatienummer")})
public class Bestelling implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totaal")
    private float totaal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumcreatie")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumcreatie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmatienummer")
    private int confirmatienummer;
    @JoinColumn(name = "klant_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Klant klantId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bestelling")
    private List<BesteldeReis> besteldeReisList;

    public Bestelling() {
    }

    public Bestelling(Integer id) {
        this.id = id;
    }

    public Bestelling(Integer id, float totaal, Date datumcreatie, int confirmatienummer) {
        this.id = id;
        this.totaal = totaal;
        this.datumcreatie = datumcreatie;
        this.confirmatienummer = confirmatienummer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getTotaal() {
        return totaal;
    }

    public void setTotaal(float totaal) {
        this.totaal = totaal;
    }

    public Date getDatumcreatie() {
        return datumcreatie;
    }

    public void setDatumcreatie(Date datumcreatie) {
        this.datumcreatie = datumcreatie;
    }

    public int getConfirmatienummer() {
        return confirmatienummer;
    }

    public void setConfirmatienummer(int confirmatienummer) {
        this.confirmatienummer = confirmatienummer;
    }

    public Klant getKlantId() {
        return klantId;
    }

    public void setKlantId(Klant klantId) {
        this.klantId = klantId;
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
        if (!(object instanceof Bestelling)) {
            return false;
        }
        Bestelling other = (Bestelling) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bestelling[ id=" + id + " ]";
    }
    
}
