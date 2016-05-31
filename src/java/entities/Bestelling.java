/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Bestelling.findById", query = "SELECT b FROM Bestelling b WHERE b.bestellingPK.id = :id"),
    @NamedQuery(name = "Bestelling.findByTotaal", query = "SELECT b FROM Bestelling b WHERE b.totaal = :totaal"),
    @NamedQuery(name = "Bestelling.findByDatumcreatie", query = "SELECT b FROM Bestelling b WHERE b.datumcreatie = :datumcreatie"),
    @NamedQuery(name = "Bestelling.findByConfirmatienummer", query = "SELECT b FROM Bestelling b WHERE b.confirmatienummer = :confirmatienummer"),
    @NamedQuery(name = "Bestelling.findByKlantId", query = "SELECT b FROM Bestelling b WHERE b.bestellingPK.klantId = :klantId")})
public class Bestelling implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BestellingPK bestellingPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "totaal")
    private BigDecimal totaal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumcreatie")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumcreatie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmatienummer")
    private int confirmatienummer;
    @JoinTable(name = "bestelde_reis", joinColumns = {
        @JoinColumn(name = "bestelling_id", referencedColumnName = "id"),
        @JoinColumn(name = "reis_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Reis> reisList;
    @JoinColumn(name = "klant_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Klant klant;

    public Bestelling() {
    }

    public Bestelling(BestellingPK bestellingPK) {
        this.bestellingPK = bestellingPK;
    }

    public Bestelling(BestellingPK bestellingPK, BigDecimal totaal, Date datumcreatie, int confirmatienummer) {
        this.bestellingPK = bestellingPK;
        this.totaal = totaal;
        this.datumcreatie = datumcreatie;
        this.confirmatienummer = confirmatienummer;
    }

    public Bestelling(int id, int klantId) {
        this.bestellingPK = new BestellingPK(id, klantId);
    }

    public BestellingPK getBestellingPK() {
        return bestellingPK;
    }

    public void setBestellingPK(BestellingPK bestellingPK) {
        this.bestellingPK = bestellingPK;
    }

    public BigDecimal getTotaal() {
        return totaal;
    }

    public void setTotaal(BigDecimal totaal) {
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

    @XmlTransient
    public List<Reis> getReisList() {
        return reisList;
    }

    public void setReisList(List<Reis> reisList) {
        this.reisList = reisList;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bestellingPK != null ? bestellingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bestelling)) {
            return false;
        }
        Bestelling other = (Bestelling) object;
        if ((this.bestellingPK == null && other.bestellingPK != null) || (this.bestellingPK != null && !this.bestellingPK.equals(other.bestellingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bestelling[ bestellingPK=" + bestellingPK + " ]";
    }
    
}
