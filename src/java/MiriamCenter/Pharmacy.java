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
@Table(name = "pharmacy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pharmacy.findAll", query = "SELECT p FROM Pharmacy p")
    , @NamedQuery(name = "Pharmacy.findByIdpharmacy", query = "SELECT p FROM Pharmacy p WHERE p.idpharmacy = :idpharmacy")
    , @NamedQuery(name = "Pharmacy.findByPharmacyName", query = "SELECT p FROM Pharmacy p WHERE p.pharmacyName = :pharmacyName")})
public class Pharmacy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpharmacy")
    private Integer idpharmacy;
    @Size(max = 30)
    @Column(name = "pharmacyName")
    private String pharmacyName;
    @OneToMany(mappedBy = "idpharmacy")
    private Collection<Medication> medicationCollection;

    public Pharmacy() {
    }

    public Pharmacy(Integer idpharmacy) {
        this.idpharmacy = idpharmacy;
    }

    public Integer getIdpharmacy() {
        return idpharmacy;
    }

    public void setIdpharmacy(Integer idpharmacy) {
        this.idpharmacy = idpharmacy;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    @XmlTransient
    public Collection<Medication> getMedicationCollection() {
        return medicationCollection;
    }

    public void setMedicationCollection(Collection<Medication> medicationCollection) {
        this.medicationCollection = medicationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpharmacy != null ? idpharmacy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pharmacy)) {
            return false;
        }
        Pharmacy other = (Pharmacy) object;
        if ((this.idpharmacy == null && other.idpharmacy != null) || (this.idpharmacy != null && !this.idpharmacy.equals(other.idpharmacy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Pharmacy[ idpharmacy=" + idpharmacy + " ]";
    }
    
}
