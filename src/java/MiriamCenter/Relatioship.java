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
@Table(name = "relatioship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatioship.findAll", query = "SELECT r FROM Relatioship r")
    , @NamedQuery(name = "Relatioship.findByIdrelation", query = "SELECT r FROM Relatioship r WHERE r.idrelation = :idrelation")
    , @NamedQuery(name = "Relatioship.findByRelationName", query = "SELECT r FROM Relatioship r WHERE r.relationName = :relationName")})
public class Relatioship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrelation")
    private Integer idrelation;
    @Size(max = 15)
    @Column(name = "relationName")
    private String relationName;
    @OneToMany(mappedBy = "idRelation")
    private Collection<Dependents> dependentsCollection;

    public Relatioship() {
    }

    public Relatioship(Integer idrelation) {
        this.idrelation = idrelation;
    }

    public Integer getIdrelation() {
        return idrelation;
    }

    public void setIdrelation(Integer idrelation) {
        this.idrelation = idrelation;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    @XmlTransient
    public Collection<Dependents> getDependentsCollection() {
        return dependentsCollection;
    }

    public void setDependentsCollection(Collection<Dependents> dependentsCollection) {
        this.dependentsCollection = dependentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelation != null ? idrelation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatioship)) {
            return false;
        }
        Relatioship other = (Relatioship) object;
        if ((this.idrelation == null && other.idrelation != null) || (this.idrelation != null && !this.idrelation.equals(other.idrelation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Relatioship[ idrelation=" + idrelation + " ]";
    }
    
}
