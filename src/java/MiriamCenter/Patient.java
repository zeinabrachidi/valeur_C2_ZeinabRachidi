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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findByIdPerson", query = "SELECT p FROM Patient p WHERE p.idPerson = :idPerson")
    , @NamedQuery(name = "Patient.findBySsn", query = "SELECT p FROM Patient p WHERE p.ssn = :ssn")
    , @NamedQuery(name = "Patient.findByRegisterNo", query = "SELECT p FROM Patient p WHERE p.registerNo = :registerNo")
    , @NamedQuery(name = "Patient.findByDob", query = "SELECT p FROM Patient p WHERE p.dob = :dob")
    , @NamedQuery(name = "Patient.findByBloodGrp", query = "SELECT p FROM Patient p WHERE p.bloodGrp = :bloodGrp")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "IdPerson")
    private String idPerson;
    @Column(name = "ssn")
    private Integer ssn;
    @Size(max = 5)
    @Column(name = "registerNo")
    private String registerNo;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 3)
    @Column(name = "bloodGrp")
    private String bloodGrp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Collection<Patientcivil> patientcivilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Collection<Dependents> dependentsCollection;
    @OneToMany(mappedBy = "idPersonPat")
    private Collection<Medicalcard> medicalcardCollection;
    @OneToMany(mappedBy = "idPerson")
    private Collection<CardDemand> cardDemandCollection;
    @JoinColumn(name = "IdPerson", referencedColumnName = "idPerson", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;
    @JoinColumn(name = "idNationality", referencedColumnName = "idNationality")
    @ManyToOne
    private Nationality idNationality;
    @JoinColumn(name = "idRegion", referencedColumnName = "idRegion")
    @ManyToOne
    private Region idRegion;

    public Patient() {
    }

    public Patient(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getBloodGrp() {
        return bloodGrp;
    }

    public void setBloodGrp(String bloodGrp) {
        this.bloodGrp = bloodGrp;
    }

    @XmlTransient
    public Collection<Patientcivil> getPatientcivilCollection() {
        return patientcivilCollection;
    }

    public void setPatientcivilCollection(Collection<Patientcivil> patientcivilCollection) {
        this.patientcivilCollection = patientcivilCollection;
    }

    @XmlTransient
    public Collection<Dependents> getDependentsCollection() {
        return dependentsCollection;
    }

    public void setDependentsCollection(Collection<Dependents> dependentsCollection) {
        this.dependentsCollection = dependentsCollection;
    }

    @XmlTransient
    public Collection<Medicalcard> getMedicalcardCollection() {
        return medicalcardCollection;
    }

    public void setMedicalcardCollection(Collection<Medicalcard> medicalcardCollection) {
        this.medicalcardCollection = medicalcardCollection;
    }

    @XmlTransient
    public Collection<CardDemand> getCardDemandCollection() {
        return cardDemandCollection;
    }

    public void setCardDemandCollection(Collection<CardDemand> cardDemandCollection) {
        this.cardDemandCollection = cardDemandCollection;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Nationality getIdNationality() {
        return idNationality;
    }

    public void setIdNationality(Nationality idNationality) {
        this.idNationality = idNationality;
    }

    public Region getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Region idRegion) {
        this.idRegion = idRegion;
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Patient[ idPerson=" + idPerson + " ]";
    }
    
}
