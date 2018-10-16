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
@Table(name = "diseases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diseases.findAll", query = "SELECT d FROM Diseases d")
    , @NamedQuery(name = "Diseases.findByIddisease", query = "SELECT d FROM Diseases d WHERE d.iddisease = :iddisease")
    , @NamedQuery(name = "Diseases.findByDiseaseName", query = "SELECT d FROM Diseases d WHERE d.diseaseName = :diseaseName")})
public class Diseases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddisease")
    private Integer iddisease;
    @Size(max = 30)
    @Column(name = "diseaseName")
    private String diseaseName;
    @JoinTable(name = "consdisease", joinColumns = {
        @JoinColumn(name = "idDisease", referencedColumnName = "iddisease")}, inverseJoinColumns = {
        @JoinColumn(name = "idMedicalAct", referencedColumnName = "idMedicalAct")})
    @ManyToMany
    private Collection<Medicalact> medicalactCollection;

    public Diseases() {
    }

    public Diseases(Integer iddisease) {
        this.iddisease = iddisease;
    }

    public Integer getIddisease() {
        return iddisease;
    }

    public void setIddisease(Integer iddisease) {
        this.iddisease = iddisease;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @XmlTransient
    public Collection<Medicalact> getMedicalactCollection() {
        return medicalactCollection;
    }

    public void setMedicalactCollection(Collection<Medicalact> medicalactCollection) {
        this.medicalactCollection = medicalactCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddisease != null ? iddisease.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diseases)) {
            return false;
        }
        Diseases other = (Diseases) object;
        if ((this.iddisease == null && other.iddisease != null) || (this.iddisease != null && !this.iddisease.equals(other.iddisease))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Diseases[ iddisease=" + iddisease + " ]";
    }
    
}
