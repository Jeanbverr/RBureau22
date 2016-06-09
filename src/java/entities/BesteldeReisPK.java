/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author michael
 */
@Embeddable
public class BesteldeReisPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "bestelling_id")
    private int bestellingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reis_id")
    private int reisId;

    public BesteldeReisPK() {
    }

    public BesteldeReisPK(int bestellingId, int reisId) {
        this.bestellingId = bestellingId;
        this.reisId = reisId;
    }

    public int getBestellingId() {
        return bestellingId;
    }

    public void setBestellingId(int bestellingId) {
        this.bestellingId = bestellingId;
    }

    public int getReisId() {
        return reisId;
    }

    public void setReisId(int reisId) {
        this.reisId = reisId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) bestellingId;
        hash += (int) reisId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BesteldeReisPK)) {
            return false;
        }
        BesteldeReisPK other = (BesteldeReisPK) object;
        if (this.bestellingId != other.bestellingId) {
            return false;
        }
        if (this.reisId != other.reisId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BesteldeReisPK[ bestellingId=" + bestellingId + ", reisId=" + reisId + " ]";
    }
    
}
