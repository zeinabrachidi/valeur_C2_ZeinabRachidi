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
public class HospsubmedPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedicalAct")
    private int idMedicalAct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSubMedicine")
    private int idSubMedicine;

    public HospsubmedPK() {
    }

    public HospsubmedPK(int idMedicalAct, int idSubMedicine) {
        this.idMedicalAct = idMedicalAct;
        this.idSubMedicine = idSubMedicine;
    }

    public int getIdMedicalAct() {
        return idMedicalAct;
    }

    public void setIdMedicalAct(int idMedicalAct) {
        this.idMedicalAct = idMedicalAct;
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
        hash += (int) idMedicalAct;
        hash += (int) idSubMedicine;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HospsubmedPK)) {
            return false;
        }
        HospsubmedPK other = (HospsubmedPK) object;
        if (this.idMedicalAct != other.idMedicalAct) {
            return false;
        }
        if (this.idSubMedicine != other.idSubMedicine) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.HospsubmedPK[ idMedicalAct=" + idMedicalAct + ", idSubMedicine=" + idSubMedicine + " ]";
    }
    
}
