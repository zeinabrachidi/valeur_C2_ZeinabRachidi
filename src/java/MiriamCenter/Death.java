/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "death")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Death.findAll", query = "SELECT d FROM Death d")
    , @NamedQuery(name = "Death.findByIddeath", query = "SELECT d FROM Death d WHERE d.iddeath = :iddeath")
    , @NamedQuery(name = "Death.findByDeathDate", query = "SELECT d FROM Death d WHERE d.deathDate = :deathDate")})
public class Death implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddeath")
    private Integer iddeath;
    @Column(name = "deathDate")
    @Temporal(TemporalType.DATE)
    private Date deathDate;
    @ManyToMany(mappedBy = "deathCollection")
    private Collection<Reasons> reasonsCollection;
    @JoinColumn(name = "IdPerson", referencedColumnName = "idPerson")
    @ManyToOne
    private Person idPerson;

    public Death() {
    }

    public Death(Integer iddeath) {
        this.iddeath = iddeath;
    }

    public Integer getIddeath() {
        return iddeath;
    }

    public void setIddeath(Integer iddeath) {
        this.iddeath = iddeath;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    @XmlTransient
    public Collection<Reasons> getReasonsCollection() {
        return reasonsCollection;
    }

    public void setReasonsCollection(Collection<Reasons> reasonsCollection) {
        this.reasonsCollection = reasonsCollection;
    }

    public Person getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddeath != null ? iddeath.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Death)) {
            return false;
        }
        Death other = (Death) object;
        if ((this.iddeath == null && other.iddeath != null) || (this.iddeath != null && !this.iddeath.equals(other.iddeath))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Death[ iddeath=" + iddeath + " ]";
    }
    
}
