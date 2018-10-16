/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author zeina
 */
@Embeddable
public class ConssubmedPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedicalact")
    private int idMedicalact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSubMedicine")
    private int idSubMedicine;

    public ConssubmedPK() {
    }

    public ConssubmedPK(int idMedicalact, int idSubMedicine) {
        this.idMedicalact = idMedicalact;
        this.idSubMedicine = idSubMedicine;
    }

    public int getIdMedicalact() {
        return idMedicalact;
    }

    public void setIdMedicalact(int idMedicalact) {
        this.idMedicalact = idMedicalact;
    }

    public int getIdSubMedicine() {
        return idSubMedicine;
    }

    public void setIdSubMedicine(int idSubMedicine) {
        this.idSubMedicine = idSubMedicine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMedicalact;
        hash += (int) idSubMedicine;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConssubmedPK)) {
            return false;
        }
        ConssubmedPK other = (ConssubmedPK) object;
        if (this.idMedicalact != other.idMedicalact) {
            return false;
        }
        if (this.idSubMedicine != other.idSubMedicine) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.ConssubmedPK[ idMedicalact=" + idMedicalact + ", idSubMedicine=" + idSubMedicine + " ]";
    }
    
}
