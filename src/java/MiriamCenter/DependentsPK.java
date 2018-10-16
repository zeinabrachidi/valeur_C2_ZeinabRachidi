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
import javax.validation.constraints.Size;

/**
 *
 * @author zeina
 */
@Embeddable
public class DependentsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "iIdPersonPers")
    private String iIdPersonPers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "IdPersonPat")
    private String idPersonPat;

    public DependentsPK() {
    }

    public DependentsPK(String iIdPersonPers, String idPersonPat) {
        this.iIdPersonPers = iIdPersonPers;
        this.idPersonPat = idPersonPat;
    }

    public String getIIdPersonPers() {
        return iIdPersonPers;
    }

    public void setIIdPersonPers(String iIdPersonPers) {
        this.iIdPersonPers = iIdPersonPers;
    }

    public String getIdPersonPat() {
        return idPersonPat;
    }

    public void setIdPersonPat(String idPersonPat) {
        this.idPersonPat = idPersonPat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iIdPersonPers != null ? iIdPersonPers.hashCode() : 0);
        hash += (idPersonPat != null ? idPersonPat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DependentsPK)) {
            return false;
        }
        DependentsPK other = (DependentsPK) object;
        if ((this.iIdPersonPers == null && other.iIdPersonPers != null) || (this.iIdPersonPers != null && !this.iIdPersonPers.equals(other.iIdPersonPers))) {
            return false;
        }
        if ((this.idPersonPat == null && other.idPersonPat != null) || (this.idPersonPat != null && !this.idPersonPat.equals(other.idPersonPat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.DependentsPK[ iIdPersonPers=" + iIdPersonPers + ", idPersonPat=" + idPersonPat + " ]";
    }
    
}
