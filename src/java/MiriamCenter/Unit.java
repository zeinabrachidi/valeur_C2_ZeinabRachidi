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
@Table(name = "unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u")
    , @NamedQuery(name = "Unit.findByIdUnit", query = "SELECT u FROM Unit u WHERE u.idUnit = :idUnit")
    , @NamedQuery(name = "Unit.findByUnitDesc", query = "SELECT u FROM Unit u WHERE u.unitDesc = :unitDesc")})
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUnit")
    private Integer idUnit;
    @Size(max = 5)
    @Column(name = "unitDesc")
    private String unitDesc;
    @OneToMany(mappedBy = "idUnit")
    private Collection<Submedicine> submedicineCollection;

    public Unit() {
    }

    public Unit(Integer idUnit) {
        this.idUnit = idUnit;
    }

    public Integer getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(Integer idUnit) {
        this.idUnit = idUnit;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
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
        hash += (idUnit != null ? idUnit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.idUnit == null && other.idUnit != null) || (this.idUnit != null && !this.idUnit.equals(other.idUnit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Unit[ idUnit=" + idUnit + " ]";
    }
    
}
