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
@Table(name = "nationality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nationality.findAll", query = "SELECT n FROM Nationality n")
    , @NamedQuery(name = "Nationality.findByIdNationality", query = "SELECT n FROM Nationality n WHERE n.idNationality = :idNationality")
    , @NamedQuery(name = "Nationality.findByNationalityName", query = "SELECT n FROM Nationality n WHERE n.nationalityName = :nationalityName")})
public class Nationality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNationality")
    private Integer idNationality;
    @Size(max = 15)
    @Column(name = "nationalityName")
    private String nationalityName;
    @OneToMany(mappedBy = "idNationality")
    private Collection<Patient> patientCollection;

    public Nationality() {
    }

    public Nationality(Integer idNationality) {
        this.idNationality = idNationality;
    }

    public Integer getIdNationality() {
        return idNationality;
    }

    public void setIdNationality(Integer idNationality) {
        this.idNationality = idNationality;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNationality != null ? idNationality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nationality)) {
            return false;
        }
        Nationality other = (Nationality) object;
        if ((this.idNationality == null && other.idNationality != null) || (this.idNationality != null && !this.idNationality.equals(other.idNationality))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Nationality[ idNationality=" + idNationality + " ]";
    }
    
}
