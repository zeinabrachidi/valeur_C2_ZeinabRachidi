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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "auxiliary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auxiliary.findAll", query = "SELECT a FROM Auxiliary a")
    , @NamedQuery(name = "Auxiliary.findByIdPerson", query = "SELECT a FROM Auxiliary a WHERE a.idPerson = :idPerson")})
public class Auxiliary implements Serializable {

    @OneToMany(mappedBy = "idPersonAux")
    private Collection<Takingvital> takingvitalCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "IdPerson")
    private String idPerson;
    @JoinColumn(name = "IdPerson", referencedColumnName = "idPerson", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Auxiliary() {
    }

    public Auxiliary(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auxiliary)) {
            return false;
        }
        Auxiliary other = (Auxiliary) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Auxiliary[ idPerson=" + idPerson + " ]";
    }

    @XmlTransient
    public Collection<Takingvital> getTakingvitalCollection() {
        return takingvitalCollection;
    }

    public void setTakingvitalCollection(Collection<Takingvital> takingvitalCollection) {
        this.takingvitalCollection = takingvitalCollection;
    }
    
}
