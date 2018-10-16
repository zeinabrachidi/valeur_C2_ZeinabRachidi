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
@Table(name = "medicalacttype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicalacttype.findAll", query = "SELECT m FROM Medicalacttype m")
    , @NamedQuery(name = "Medicalacttype.findByIdmedicalacttype", query = "SELECT m FROM Medicalacttype m WHERE m.idmedicalacttype = :idmedicalacttype")
    , @NamedQuery(name = "Medicalacttype.findByMedicalacttypeDesc", query = "SELECT m FROM Medicalacttype m WHERE m.medicalacttypeDesc = :medicalacttypeDesc")})
public class Medicalacttype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmedicalacttype")
    private Integer idmedicalacttype;
    @Size(max = 15)
    @Column(name = "medicalacttypeDesc")
    private String medicalacttypeDesc;
    @OneToMany(mappedBy = "idmedicalacttype")
    private Collection<Medicalact> medicalactCollection;

    public Medicalacttype() {
    }

    public Medicalacttype(Integer idmedicalacttype) {
        this.idmedicalacttype = idmedicalacttype;
    }

    public Integer getIdmedicalacttype() {
        return idmedicalacttype;
    }

    public void setIdmedicalacttype(Integer idmedicalacttype) {
        this.idmedicalacttype = idmedicalacttype;
    }

    public String getMedicalacttypeDesc() {
        return medicalacttypeDesc;
    }

    public void setMedicalacttypeDesc(String medicalacttypeDesc) {
        this.medicalacttypeDesc = medicalacttypeDesc;
    }

    @XmlTransient
    public Collection<Medicalact> getMedicalactCollection() {
        return medicalactCollection;
    }

    public void setMedicalactCollection(Collection<Medicalact> medicalactCollection) {
        this.medicalactCollection = medicalactCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicalacttype != null ? idmedicalacttype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicalacttype)) {
            return false;
        }
        Medicalacttype other = (Medicalacttype) object;
        if ((this.idmedicalacttype == null && other.idmedicalacttype != null) || (this.idmedicalacttype != null && !this.idmedicalacttype.equals(other.idmedicalacttype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Medicalacttype[ idmedicalacttype=" + idmedicalacttype + " ]";
    }
    
}
