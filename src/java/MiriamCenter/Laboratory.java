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
@Table(name = "laboratory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laboratory.findAll", query = "SELECT l FROM Laboratory l")
    , @NamedQuery(name = "Laboratory.findByIdLaboratory", query = "SELECT l FROM Laboratory l WHERE l.idLaboratory = :idLaboratory")
    , @NamedQuery(name = "Laboratory.findByLaboratoryName", query = "SELECT l FROM Laboratory l WHERE l.laboratoryName = :laboratoryName")})
public class Laboratory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLaboratory")
    private Integer idLaboratory;
    @Size(max = 45)
    @Column(name = "laboratoryName")
    private String laboratoryName;
    @OneToMany(mappedBy = "idLaboratory")
    private Collection<Testlab> testlabCollection;

    public Laboratory() {
    }

    public Laboratory(Integer idLaboratory) {
        this.idLaboratory = idLaboratory;
    }

    public Integer getIdLaboratory() {
        return idLaboratory;
    }

    public void setIdLaboratory(Integer idLaboratory) {
        this.idLaboratory = idLaboratory;
    }

    public String getLaboratoryName() {
        return laboratoryName;
    }

    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    @XmlTransient
    public Collection<Testlab> getTestlabCollection() {
        return testlabCollection;
    }

    public void setTestlabCollection(Collection<Testlab> testlabCollection) {
        this.testlabCollection = testlabCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLaboratory != null ? idLaboratory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratory)) {
            return false;
        }
        Laboratory other = (Laboratory) object;
        if ((this.idLaboratory == null && other.idLaboratory != null) || (this.idLaboratory != null && !this.idLaboratory.equals(other.idLaboratory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Laboratory[ idLaboratory=" + idLaboratory + " ]";
    }
    
}
