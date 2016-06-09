/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author michael
 */
@Entity
@Table(name = "bestelde_reis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BesteldeReis.findAll", query = "SELECT b FROM BesteldeReis b"),
    @NamedQuery(name = "BesteldeReis.findByBestellingId", query = "SELECT b FROM BesteldeReis b WHERE b.besteldeReisPK.bestellingId = :bestellingId"),
    @NamedQuery(name = "BesteldeReis.findByReisId", query = "SELECT b FROM BesteldeReis b WHERE b.besteldeReisPK.reisId = :reisId"),
    @NamedQuery(name = "BesteldeReis.findByAantalPersonen", query = "SELECT b FROM BesteldeReis b WHERE b.aantalPersonen = :aantalPersonen")})
public class BesteldeReis implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BesteldeReisPK besteldeReisPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aantal_personen")
    private int aantalPersonen;
    @JoinColumn(name = "bestelling_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bestelling bestelling;
    @JoinColumn(name = "reis_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reis reis;

    public BesteldeReis() {
    }

    public BesteldeReis(BesteldeReisPK besteldeReisPK) {
        this.besteldeReisPK = besteldeReisPK;
    }

    public BesteldeReis(BesteldeReisPK besteldeReisPK, int aantalPersonen) {
        this.besteldeReisPK = besteldeReisPK;
        this.aantalPersonen = aantalPersonen;
    }

    public BesteldeReis(int bestellingId, int reisId) {
        this.besteldeReisPK = new BesteldeReisPK(bestellingId, reisId);
    }

    public BesteldeReisPK getBesteldeReisPK() {
        return besteldeReisPK;
    }

    public void setBesteldeReisPK(BesteldeReisPK besteldeReisPK) {
        this.besteldeReisPK = besteldeReisPK;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (besteldeReisPK != null ? besteldeReisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BesteldeReis)) {
            return false;
        }
        BesteldeReis other = (BesteldeReis) object;
        if ((this.besteldeReisPK == null && other.besteldeReisPK != null) || (this.besteldeReisPK != null && !this.besteldeReisPK.equals(other.besteldeReisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BesteldeReis[ besteldeReisPK=" + besteldeReisPK + " ]";
    }
    
}
