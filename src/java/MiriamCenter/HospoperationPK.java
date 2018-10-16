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
public class HospoperationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedicalAct")
    private int idMedicalAct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOperation")
    private int idOperation;

    public HospoperationPK() {
    }

    public HospoperationPK(int idMedicalAct, int idOperation) {
        this.idMedicalAct = idMedicalAct;
        this.idOperation = idOperation;
    }

    public int getIdMedicalAct() {
        return idMedicalAct;
    }

    public void setIdMedicalAct(int idMedicalAct) {
        this.idMedicalAct = idMedicalAct;
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMedicalAct;
        hash += (int) idOperation;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HospoperationPK)) {
            return false;
        }
        HospoperationPK other = (HospoperationPK) object;
        if (this.idMedicalAct != other.idMedicalAct) {
            return false;
        }
        if (this.idOperation != other.idOperation) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.HospoperationPK[ idMedicalAct=" + idMedicalAct + ", idOperation=" + idOperation + " ]";
    }
    
}
