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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "vaccines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vaccines.findAll", query = "SELECT v FROM Vaccines v")
    , @NamedQuery(name = "Vaccines.findByIdvaccines", query = "SELECT v FROM Vaccines v WHERE v.idvaccines = :idvaccines")
    , @NamedQuery(name = "Vaccines.findByVaccinesName", query = "SELECT v FROM Vaccines v WHERE v.vaccinesName = :vaccinesName")})
public class Vaccines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvaccines")
    private Integer idvaccines;
    @Size(max = 30)
    @Column(name = "vaccinesName")
    private String vaccinesName;
    @ManyToMany(mappedBy = "vaccinesCollection")
    private Collection<Consultation> consultationCollection;

    public Vaccines() {
    }

    public Vaccines(Integer idvaccines) {
        this.idvaccines = idvaccines;
    }

    public Integer getIdvaccines() {
        return idvaccines;
    }

    public void setIdvaccines(Integer idvaccines) {
        this.idvaccines = idvaccines;
    }

    public String getVaccinesName() {
        return vaccinesName;
    }

    public void setVaccinesName(String vaccinesName) {
        this.vaccinesName = vaccinesName;
    }

    @XmlTransient
    public Collection<Consultation> getConsultationCollection() {
        return consultationCollection;
    }

    public void setConsultationCollection(Collection<Consultation> consultationCollection) {
        this.consultationCollection = consultationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvaccines != null ? idvaccines.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vaccines)) {
            return false;
        }
        Vaccines other = (Vaccines) object;
        if ((this.idvaccines == null && other.idvaccines != null) || (this.idvaccines != null && !this.idvaccines.equals(other.idvaccines))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Vaccines[ idvaccines=" + idvaccines + " ]";
    }
    
}
