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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "medicine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicine.findAll", query = "SELECT m FROM Medicine m")
    , @NamedQuery(name = "Medicine.findByIdMedicine", query = "SELECT m FROM Medicine m WHERE m.idMedicine = :idMedicine")
    , @NamedQuery(name = "Medicine.findByMedicineName", query = "SELECT m FROM Medicine m WHERE m.medicineName = :medicineName")})
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedicine")
    private Integer idMedicine;
    @Size(max = 30)
    @Column(name = "medicineName")
    private String medicineName;
    @OneToMany(mappedBy = "idMedicine")
    private Collection<Submedicine> submedicineCollection;
    @JoinColumn(name = "idFamily", referencedColumnName = "idFamily")
    @ManyToOne
    private Family idFamily;

    public Medicine() {
    }

    public Medicine(Integer idMedicine) {
        this.idMedicine = idMedicine;
    }

    public Integer getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(Integer idMedicine) {
        this.idMedicine = idMedicine;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @XmlTransient
    public Collection<Submedicine> getSubmedicineCollection() {
        return submedicineCollection;
    }

    public void setSubmedicineCollection(Collection<Submedicine> submedicineCollection) {
        this.submedicineCollection = submedicineCollection;
    }

    public Family getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(Family idFamily) {
        this.idFamily = idFamily;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicine != null ? idMedicine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicine)) {
            return false;
        }
        Medicine other = (Medicine) object;
        if ((this.idMedicine == null && other.idMedicine != null) || (this.idMedicine != null && !this.idMedicine.equals(other.idMedicine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Medicine[ idMedicine=" + idMedicine + " ]";
    }
    
}
