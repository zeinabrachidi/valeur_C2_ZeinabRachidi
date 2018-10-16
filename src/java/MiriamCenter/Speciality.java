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
@Table(name = "speciality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Speciality.findAll", query = "SELECT s FROM Speciality s")
    , @NamedQuery(name = "Speciality.findByIdSpeciality", query = "SELECT s FROM Speciality s WHERE s.idSpeciality = :idSpeciality")
    , @NamedQuery(name = "Speciality.findBySpecialityDesc", query = "SELECT s FROM Speciality s WHERE s.specialityDesc = :specialityDesc")})
public class Speciality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSpeciality")
    private Integer idSpeciality;
    @Size(max = 15)
    @Column(name = "specialityDesc")
    private String specialityDesc;
    @OneToMany(mappedBy = "idSpeciality")
    private Collection<Doctor> doctorCollection;

    public Speciality() {
    }

    public Speciality(Integer idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public Integer getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Integer idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getSpecialityDesc() {
        return specialityDesc;
    }

    public void setSpecialityDesc(String specialityDesc) {
        this.specialityDesc = specialityDesc;
    }

    @XmlTransient
    public Collection<Doctor> getDoctorCollection() {
        return doctorCollection;
    }

    public void setDoctorCollection(Collection<Doctor> doctorCollection) {
        this.doctorCollection = doctorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpeciality != null ? idSpeciality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Speciality)) {
            return false;
        }
        Speciality other = (Speciality) object;
        if ((this.idSpeciality == null && other.idSpeciality != null) || (this.idSpeciality != null && !this.idSpeciality.equals(other.idSpeciality))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Speciality[ idSpeciality=" + idSpeciality + " ]";
    }
    
}
