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
public class BestellingPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "klant_id")
    private int klantId;

    public BestellingPK() {
    }

    public BestellingPK(int id, int klantId) {
        this.id = id;
        this.klantId = klantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKlantId() {
        return klantId;
    }

    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) klantId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BestellingPK)) {
            return false;
        }
        BestellingPK other = (BestellingPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.klantId != other.klantId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BestellingPK[ id=" + id + ", klantId=" + klantId + " ]";
    }
    
}
