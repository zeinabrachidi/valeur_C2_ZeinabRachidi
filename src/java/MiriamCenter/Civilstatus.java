/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "civilstatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Civilstatus.findAll", query = "SELECT c FROM Civilstatus c")
    , @NamedQuery(name = "Civilstatus.findByIdcivilstatus", query = "SELECT c FROM Civilstatus c WHERE c.idcivilstatus = :idcivilstatus")
    , @NamedQuery(name = "Civilstatus.findByCivilstatusDesc", query = "SELECT c FROM Civilstatus c WHERE c.civilstatusDesc = :civilstatusDesc")})
public class Civilstatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcivilstatus")
    private Integer idcivilstatus;
    @Size(max = 7)
    @Column(name = "civilstatusDesc")
    private String civilstatusDesc;
    @OneToMany(mappedBy = "idCivilStatus")
    private Collection<Patientcivil> patientcivilCollection;

    public Civilstatus() {
    }

    public Civilstatus(Integer idcivilstatus) {
        this.idcivilstatus = idcivilstatus;
    }

    public Integer getIdcivilstatus() {
        return idcivilstatus;
    }

    public void setIdcivilstatus(Integer idcivilstatus) {
        this.idcivilstatus = idcivilstatus;
    }

    public String getCivilstatusDesc() {
        return civilstatusDesc;
    }

    public void setCivilstatusDesc(String civilstatusDesc) {
        this.civilstatusDesc = civilstatusDesc;
    }

    @XmlTransient
    public Collection<Patientcivil> getPatientcivilCollection() {
        return patientcivilCollection;
    }

    public void setPatientcivilCollection(Collection<Patientcivil> patientcivilCollection) {
        this.patientcivilCollection = patientcivilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcivilstatus != null ? idcivilstatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Civilstatus)) {
            return false;
        }
        Civilstatus other = (Civilstatus) object;
        if ((this.idcivilstatus == null && other.idcivilstatus != null) || (this.idcivilstatus != null && !this.idcivilstatus.equals(other.idcivilstatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Civilstatus[ idcivilstatus=" + idcivilstatus + " ]";
    }
    
}
