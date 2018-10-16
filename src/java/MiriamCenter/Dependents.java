/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "dependents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependents.findAll", query = "SELECT d FROM Dependents d")
    , @NamedQuery(name = "Dependents.findByIIdPersonPers", query = "SELECT d FROM Dependents d WHERE d.dependentsPK.iIdPersonPers = :iIdPersonPers")
    , @NamedQuery(name = "Dependents.findByIdPersonPat", query = "SELECT d FROM Dependents d WHERE d.dependentsPK.idPersonPat = :idPersonPat")})
public class Dependents implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DependentsPK dependentsPK;
    @JoinColumn(name = "iIdPersonPers", referencedColumnName = "idPerson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "IdPersonPat", referencedColumnName = "IdPerson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Patient patient;
    @JoinColumn(name = "idRelation", referencedColumnName = "idrelation")
    @ManyToOne
    private Relatioship idRelation;

    public Dependents() {
    }

    public Dependents(DependentsPK dependentsPK) {
        this.dependentsPK = dependentsPK;
    }

    public Dependents(String iIdPersonPers, String idPersonPat) {
        this.dependentsPK = new DependentsPK(iIdPersonPers, idPersonPat);
    }

    public DependentsPK getDependentsPK() {
        return dependentsPK;
    }

    public void setDependentsPK(DependentsPK dependentsPK) {
        this.dependentsPK = dependentsPK;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Relatioship getIdRelation() {
        return idRelation;
    }

    public void setIdRelation(Relatioship idRelation) {
        this.idRelation = idRelation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dependentsPK != null ? dependentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependents)) {
            return false;
        }
        Dependents other = (Dependents) object;
        if ((this.dependentsPK == null && other.dependentsPK != null) || (this.dependentsPK != null && !this.dependentsPK.equals(other.dependentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Dependents[ dependentsPK=" + dependentsPK + " ]";
    }
    
}
