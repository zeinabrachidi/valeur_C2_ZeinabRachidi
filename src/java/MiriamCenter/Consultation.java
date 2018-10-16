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
@Table(name = "consultation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c")
    , @NamedQuery(name = "Consultation.findByIdMedicalActCons", query = "SELECT c FROM Consultation c WHERE c.idMedicalActCons = :idMedicalActCons")
    , @NamedQuery(name = "Consultation.findByMontant", query = "SELECT c FROM Consultation c WHERE c.montant = :montant")})
public class Consultation implements Serializable {

    @ManyToMany(mappedBy = "consultationCollection")
    private Collection<Diseases> diseasesCollection;
    @JoinColumn(name = "idMedicalActCons", referencedColumnName = "idMedicalAct")
    @OneToOne(optional = false)
    private Medicalact medicalact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultation")
    private Collection<Conssubmed> conssubmedCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedicalActCons")
    private Integer idMedicalActCons;
    @Column(name = "montant")
    private Integer montant;
    @JoinTable(name = "constest", joinColumns = {
        @JoinColumn(name = "idMedicalAct", referencedColumnName = "idMedicalActCons")}, inverseJoinColumns = {
        @JoinColumn(name = "idTest", referencedColumnName = "idTest")})
    @ManyToMany
    private Collection<Test> testCollection;
    @JoinTable(name = "consvaccins", joinColumns = {
        @JoinColumn(name = "idMedicalAct", referencedColumnName = "idMedicalActCons")}, inverseJoinColumns = {
        @JoinColumn(name = "idVaccine", referencedColumnName = "idvaccines")})
    @ManyToMany
    private Collection<Vaccines> vaccinesCollection;
    @JoinColumn(name = "IdPersonDoc", referencedColumnName = "IdPerson")
    @ManyToOne
    private Doctor idPersonDoc;
    @OneToMany(mappedBy = "idMedicalAct")
    private Collection<Consultmedication> consultmedicationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedicalActCons")
    private Collection<Constestlab> constestlabCollection;

    public Consultation() {
    }

    public Consultation(Integer idMedicalActCons) {
        this.idMedicalActCons = idMedicalActCons;
    }

    public Integer getIdMedicalActCons() {
        return idMedicalActCons;
    }

    public void setIdMedicalActCons(Integer idMedicalActCons) {
        this.idMedicalActCons = idMedicalActCons;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    @XmlTransient
    public Collection<Test> getTestCollection() {
        return testCollection;
    }

    public void setTestCollection(Collection<Test> testCollection) {
        this.testCollection = testCollection;
    }

    @XmlTransient
    public Collection<Vaccines> getVaccinesCollection() {
        return vaccinesCollection;
    }

    public void setVaccinesCollection(Collection<Vaccines> vaccinesCollection) {
        this.vaccinesCollection = vaccinesCollection;
    }

    public Doctor getIdPersonDoc() {
        return idPersonDoc;
    }

    public void setIdPersonDoc(Doctor idPersonDoc) {
        this.idPersonDoc = idPersonDoc;
    }

    @XmlTransient
    public Collection<Consultmedication> getConsultmedicationCollection() {
        return consultmedicationCollection;
    }

    public void setConsultmedicationCollection(Collection<Consultmedication> consultmedicationCollection) {
        this.consultmedicationCollection = consultmedicationCollection;
    }

    @XmlTransient
    public Collection<Constestlab> getConstestlabCollection() {
        return constestlabCollection;
    }

    public void setConstestlabCollection(Collection<Constestlab> constestlabCollection) {
        this.constestlabCollection = constestlabCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicalActCons != null ? idMedicalActCons.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.idMedicalActCons == null && other.idMedicalActCons != null) || (this.idMedicalActCons != null && !this.idMedicalActCons.equals(other.idMedicalActCons))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Consultation[ idMedicalActCons=" + idMedicalActCons + " ]";
    }

    @XmlTransient
    public Collection<Diseases> getDiseasesCollection() {
        return diseasesCollection;
    }

    public void setDiseasesCollection(Collection<Diseases> diseasesCollection) {
        this.diseasesCollection = diseasesCollection;
    }

    public Medicalact getMedicalact() {
        return medicalact;
    }

    public void setMedicalact(Medicalact medicalact) {
        this.medicalact = medicalact;
    }

    @XmlTransient
    public Collection<Conssubmed> getConssubmedCollection() {
        return conssubmedCollection;
    }

    public void setConssubmedCollection(Collection<Conssubmed> conssubmedCollection) {
        this.conssubmedCollection = conssubmedCollection;
    }
    
}
