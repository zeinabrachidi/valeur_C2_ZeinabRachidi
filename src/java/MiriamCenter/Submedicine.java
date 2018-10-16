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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "submedicine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submedicine.findAll", query = "SELECT s FROM Submedicine s")
    , @NamedQuery(name = "Submedicine.findByIdSubmedicine", query = "SELECT s FROM Submedicine s WHERE s.idSubmedicine = :idSubmedicine")
    , @NamedQuery(name = "Submedicine.findBySubmedicineDose", query = "SELECT s FROM Submedicine s WHERE s.submedicineDose = :submedicineDose")})
public class Submedicine implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "submedicine")
    private Collection<Conssubmed> conssubmedCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSubmedicine")
    private Integer idSubmedicine;
    @Column(name = "submedicineDose")
    private Integer submedicineDose;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "submedicine")
    private Collection<Hospsubmed> hospsubmedCollection;
    @JoinColumn(name = "idMedicineType", referencedColumnName = "idMedicineType")
    @ManyToOne
    private Medicinetype idMedicineType;
    @JoinColumn(name = "idMedicine", referencedColumnName = "idMedicine")
    @ManyToOne
    private Medicine idMedicine;
    @JoinColumn(name = "idUnit", referencedColumnName = "idUnit")
    @ManyToOne
    private Unit idUnit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "submedicine")
    private Collection<Medisubmed> medisubmedCollection;

    public Submedicine() {
    }

    public Submedicine(Integer idSubmedicine) {
        this.idSubmedicine = idSubmedicine;
    }

    public Integer getIdSubmedicine() {
        return idSubmedicine;
    }

    public void setIdSubmedicine(Integer idSubmedicine) {
        this.idSubmedicine = idSubmedicine;
    }

    public Integer getSubmedicineDose() {
        return submedicineDose;
    }

    public void setSubmedicineDose(Integer submedicineDose) {
        this.submedicineDose = submedicineDose;
    }

    @XmlTransient
    public Collection<Hospsubmed> getHospsubmedCollection() {
        return hospsubmedCollection;
    }

    public void setHospsubmedCollection(Collection<Hospsubmed> hospsubmedCollection) {
        this.hospsubmedCollection = hospsubmedCollection;
    }

    public Medicinetype getIdMedicineType() {
        return idMedicineType;
    }

    public void setIdMedicineType(Medicinetype idMedicineType) {
        this.idMedicineType = idMedicineType;
    }

    public Medicine getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(Medicine idMedicine) {
        this.idMedicine = idMedicine;
    }

    public Unit getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(Unit idUnit) {
        this.idUnit = idUnit;
    }

    @XmlTransient
    public Collection<Medisubmed> getMedisubmedCollection() {
        return medisubmedCollection;
    }

    public void setMedisubmedCollection(Collection<Medisubmed> medisubmedCollection) {
        this.medisubmedCollection = medisubmedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubmedicine != null ? idSubmedicine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submedicine)) {
            return false;
        }
        Submedicine other = (Submedicine) object;
        if ((this.idSubmedicine == null && other.idSubmedicine != null) || (this.idSubmedicine != null && !this.idSubmedicine.equals(other.idSubmedicine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Submedicine[ idSubmedicine=" + idSubmedicine + " ]";
    }

    @XmlTransient
    public Collection<Conssubmed> getConssubmedCollection() {
        return conssubmedCollection;
    }

    public void setConssubmedCollection(Collection<Conssubmed> conssubmedCollection) {
        this.conssubmedCollection = conssubmedCollection;
    }
    
}
