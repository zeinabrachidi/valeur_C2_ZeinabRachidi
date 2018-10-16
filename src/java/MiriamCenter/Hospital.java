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
@Table(name = "hospital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h")
    , @NamedQuery(name = "Hospital.findByIdHospital", query = "SELECT h FROM Hospital h WHERE h.idHospital = :idHospital")
    , @NamedQuery(name = "Hospital.findByHospitalName", query = "SELECT h FROM Hospital h WHERE h.hospitalName = :hospitalName")})
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHospital")
    private Integer idHospital;
    @Size(max = 30)
    @Column(name = "hospitalName")
    private String hospitalName;
    @OneToMany(mappedBy = "idHhospital")
    private Collection<Hospitalization> hospitalizationCollection;

    public Hospital() {
    }

    public Hospital(Integer idHospital) {
        this.idHospital = idHospital;
    }

    public Integer getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(Integer idHospital) {
        this.idHospital = idHospital;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @XmlTransient
    public Collection<Hospitalization> getHospitalizationCollection() {
        return hospitalizationCollection;
    }

    public void setHospitalizationCollection(Collection<Hospitalization> hospitalizationCollection) {
        this.hospitalizationCollection = hospitalizationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHospital != null ? idHospital.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.idHospital == null && other.idHospital != null) || (this.idHospital != null && !this.idHospital.equals(other.idHospital))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Hospital[ idHospital=" + idHospital + " ]";
    }
    
}
