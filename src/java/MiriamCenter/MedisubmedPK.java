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
public class MedisubmedPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idmedication")
    private int idmedication;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSubMedicine")
    private int idSubMedicine;

    public MedisubmedPK() {
    }

    public MedisubmedPK(int idmedication, int idSubMedicine) {
        this.idmedication = idmedication;
        this.idSubMedicine = idSubMedicine;
    }

    public int getIdmedication() {
        return idmedication;
    }

    public void setIdmedication(int idmedication) {
        this.idmedication = idmedication;
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
        hash += (int) idmedication;
        hash += (int) idSubMedicine;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedisubmedPK)) {
            return false;
        }
        MedisubmedPK other = (MedisubmedPK) object;
        if (this.idmedication != other.idmedication) {
            return false;
        }
        if (this.idSubMedicine != other.idSubMedicine) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.MedisubmedPK[ idmedication=" + idmedication + ", idSubMedicine=" + idSubMedicine + " ]";
    }
    
}
