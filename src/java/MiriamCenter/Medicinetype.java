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
@Table(name = "medicinetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicinetype.findAll", query = "SELECT m FROM Medicinetype m")
    , @NamedQuery(name = "Medicinetype.findByIdMedicineType", query = "SELECT m FROM Medicinetype m WHERE m.idMedicineType = :idMedicineType")
    , @NamedQuery(name = "Medicinetype.findByMedicineTypeDesc", query = "SELECT m FROM Medicinetype m WHERE m.medicineTypeDesc = :medicineTypeDesc")})
public class Medicinetype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedicineType")
    private Integer idMedicineType;
    @Size(max = 15)
    @Column(name = "medicineTypeDesc")
    private String medicineTypeDesc;
    @OneToMany(mappedBy = "idMedicineType")
    private Collection<Submedicine> submedicineCollection;

    public Medicinetype() {
    }

    public Medicinetype(Integer idMedicineType) {
        this.idMedicineType = idMedicineType;
    }

    public Integer getIdMedicineType() {
        return idMedicineType;
    }

    public void setIdMedicineType(Integer idMedicineType) {
        this.idMedicineType = idMedicineType;
    }

    public String getMedicineTypeDesc() {
        return medicineTypeDesc;
    }

    public void setMedicineTypeDesc(String medicineTypeDesc) {
        this.medicineTypeDesc = medicineTypeDesc;
    }

    @XmlTransient
    public Collection<Submedicine> getSubmedicineCollection() {
        return submedicineCollection;
    }

    public void setSubmedicineCollection(Collection<Submedicine> submedicineCollection) {
        this.submedicineCollection = submedicineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicineType != null ? idMedicineType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicinetype)) {
            return false;
        }
        Medicinetype other = (Medicinetype) object;
        if ((this.idMedicineType == null && other.idMedicineType != null) || (this.idMedicineType != null && !this.idMedicineType.equals(other.idMedicineType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Medicinetype[ idMedicineType=" + idMedicineType + " ]";
    }
    
}
