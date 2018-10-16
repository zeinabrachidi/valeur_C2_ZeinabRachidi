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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "hospitalization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospitalization.findAll", query = "SELECT h FROM Hospitalization h")
    , @NamedQuery(name = "Hospitalization.findByIdMedicalAct", query = "SELECT h FROM Hospitalization h WHERE h.idMedicalAct = :idMedicalAct")})
public class Hospitalization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedicalAct")
    private Integer idMedicalAct;
    @JoinTable(name = "hosptest", joinColumns = {
        @JoinColumn(name = "idHospitalization", referencedColumnName = "idMedicalAct")}, inverseJoinColumns = {
        @JoinColumn(name = "idTest", referencedColumnName = "idTest")})
    @ManyToMany
    private Collection<Test> testCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalization")
    private Collection<Hospsubmed> hospsubmedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedicalActHosp")
    private Collection<Hospmedication> hospmedicationCollection;
    @OneToMany(mappedBy = "idMedicalActHosp")
    private Collection<Hosptestlab> hosptestlabCollection;
    @OneToMany(mappedBy = "idMedicalActHosp")
    private Collection<Takingvital> takingvitalCollection;
    @JoinColumn(name = "idHhospital", referencedColumnName = "idHospital")
    @ManyToOne
    private Hospital idHhospital;
    @JoinColumn(name = "idMedicalAct", referencedColumnName = "idMedicalAct", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Medicalact medicalact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalization")
    private Collection<Hospoperation> hospoperationCollection;

    public Hospitalization() {
    }

    public Hospitalization(Integer idMedicalAct) {
        this.idMedicalAct = idMedicalAct;
    }

    public Integer getIdMedicalAct() {
        return idMedicalAct;
    }

    public void setIdMedicalAct(Integer idMedicalAct) {
        this.idMedicalAct = idMedicalAct;
    }

    @XmlTransient
    public Collection<Test> getTestCollection() {
        return testCollection;
    }

    public void setTestCollection(Collection<Test> testCollection) {
        this.testCollection = testCollection;
    }

    @XmlTransient
    public Collection<Hospsubmed> getHospsubmedCollection() {
        return hospsubmedCollection;
    }

    public void setHospsubmedCollection(Collection<Hospsubmed> hospsubmedCollection) {
        this.hospsubmedCollection = hospsubmedCollection;
    }

    @XmlTransient
    public Collection<Hospmedication> getHospmedicationCollection() {
        return hospmedicationCollection;
    }

    public void setHospmedicationCollection(Collection<Hospmedication> hospmedicationCollection) {
        this.hospmedicationCollection = hospmedicationCollection;
    }

    @XmlTransient
    public Collection<Hosptestlab> getHosptestlabCollection() {
        return hosptestlabCollection;
    }

    public void setHosptestlabCollection(Collection<Hosptestlab> hosptestlabCollection) {
        this.hosptestlabCollection = hosptestlabCollection;
    }

    @XmlTransient
    public Collection<Takingvital> getTakingvitalCollection() {
        return takingvitalCollection;
    }

    public void setTakingvitalCollection(Collection<Takingvital> takingvitalCollection) {
        this.takingvitalCollection = takingvitalCollection;
    }

    public Hospital getIdHhospital() {
        return idHhospital;
    }

    public void setIdHhospital(Hospital idHhospital) {
        this.idHhospital = idHhospital;
    }

    public Medicalact getMedicalact() {
        return medicalact;
    }

    public void setMedicalact(Medicalact medicalact) {
        this.medicalact = medicalact;
    }

    @XmlTransient
    public Collection<Hospoperation> getHospoperationCollection() {
        return hospoperationCollection;
    }

    public void setHospoperationCollection(Collection<Hospoperation> hospoperationCollection) {
        this.hospoperationCollection = hospoperationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicalAct != null ? idMedicalAct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospitalization)) {
            return false;
        }
        Hospitalization other = (Hospitalization) object;
        if ((this.idMedicalAct == null && other.idMedicalAct != null) || (this.idMedicalAct != null && !this.idMedicalAct.equals(other.idMedicalAct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Hospitalization[ idMedicalAct=" + idMedicalAct + " ]";
    }
    
}
