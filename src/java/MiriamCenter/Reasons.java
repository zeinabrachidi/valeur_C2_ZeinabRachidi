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
import javax.persistence.JoinTable;
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
@Table(name = "reasons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reasons.findAll", query = "SELECT r FROM Reasons r")
    , @NamedQuery(name = "Reasons.findByIdreasons", query = "SELECT r FROM Reasons r WHERE r.idreasons = :idreasons")
    , @NamedQuery(name = "Reasons.findByReasonsDesc", query = "SELECT r FROM Reasons r WHERE r.reasonsDesc = :reasonsDesc")})
public class Reasons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idreasons")
    private Integer idreasons;
    @Size(max = 45)
    @Column(name = "reasonsDesc")
    private String reasonsDesc;
    @JoinTable(name = "deathreasons", joinColumns = {
        @JoinColumn(name = "idReasons", referencedColumnName = "idreasons")}, inverseJoinColumns = {
        @JoinColumn(name = "iddeath", referencedColumnName = "iddeath")})
    @ManyToMany
    private Collection<Death> deathCollection;

    public Reasons() {
    }

    public Reasons(Integer idreasons) {
        this.idreasons = idreasons;
    }

    public Integer getIdreasons() {
        return idreasons;
    }

    public void setIdreasons(Integer idreasons) {
        this.idreasons = idreasons;
    }

    public String getReasonsDesc() {
        return reasonsDesc;
    }

    public void setReasonsDesc(String reasonsDesc) {
        this.reasonsDesc = reasonsDesc;
    }

    @XmlTransient
    public Collection<Death> getDeathCollection() {
        return deathCollection;
    }

    public void setDeathCollection(Collection<Death> deathCollection) {
        this.deathCollection = deathCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreasons != null ? idreasons.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reasons)) {
            return false;
        }
        Reasons other = (Reasons) object;
        if ((this.idreasons == null && other.idreasons != null) || (this.idreasons != null && !this.idreasons.equals(other.idreasons))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Reasons[ idreasons=" + idreasons + " ]";
    }
    
}
