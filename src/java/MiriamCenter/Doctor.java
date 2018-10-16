/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d")
    , @NamedQuery(name = "Doctor.findByIdPerson", query = "SELECT d FROM Doctor d WHERE d.idPerson = :idPerson")
    , @NamedQuery(name = "Doctor.findByEstablisTel", query = "SELECT d FROM Doctor d WHERE d.establisTel = :establisTel")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "IdPerson")
    private String idPerson;
    @Size(max = 11)
    @Column(name = "establisTel")
    private String establisTel;
    @OneToMany(mappedBy = "idPersonDoc")
    private Collection<Consultation> consultationCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Chefservice chefservice;
    @JoinColumn(name = "IdPerson", referencedColumnName = "idPerson", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;
    @JoinColumn(name = "idSpeciality", referencedColumnName = "idSpeciality")
    @ManyToOne
    private Speciality idSpeciality;
    @OneToMany(mappedBy = "idPersonDoc")
    private Collection<Hospoperation> hospoperationCollection;

    public Doctor() {
    }

    public Doctor(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getEstablisTel() {
        return establisTel;
    }

    public void setEstablisTel(String establisTel) {
        this.establisTel = establisTel;
    }

    @XmlTransient
    public Collection<Consultation> getConsultationCollection() {
        return consultationCollection;
    }

    public void setConsultationCollection(Collection<Consultation> consultationCollection) {
        this.consultationCollection = consultationCollection;
    }

    public Chefservice getChefservice() {
        return chefservice;
    }

    public void setChefservice(Chefservice chefservice) {
        this.chefservice = chefservice;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Speciality getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Speciality idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    @XmlTransient
    public Collection<Hospoperation> getHospoperationCollection() {
        return hospoperationCollection;
    }

    public void setHospoperationCollection(Collection<Hospoperation> hospoperationCollection) {
        this.hospoperationCollection = hospoperationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Doctor[ idPerson=" + idPerson + " ]";
    }
    
}
