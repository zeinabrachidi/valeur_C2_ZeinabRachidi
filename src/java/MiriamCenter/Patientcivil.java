/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "patientcivil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patientcivil.findAll", query = "SELECT p FROM Patientcivil p")
    , @NamedQuery(name = "Patientcivil.findByIdPerson", query = "SELECT p FROM Patientcivil p WHERE p.patientcivilPK.idPerson = :idPerson")
    , @NamedQuery(name = "Patientcivil.findByDate", query = "SELECT p FROM Patientcivil p WHERE p.patientcivilPK.date = :date")})
public class Patientcivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PatientcivilPK patientcivilPK;
    @JoinColumn(name = "IdPerson", referencedColumnName = "IdPerson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Patient patient;
    @JoinColumn(name = "idCivilStatus", referencedColumnName = "idcivilstatus")
    @ManyToOne
    private Civilstatus idCivilStatus;

    public Patientcivil() {
    }

    public Patientcivil(PatientcivilPK patientcivilPK) {
        this.patientcivilPK = patientcivilPK;
    }

    public Patientcivil(String idPerson, Date date) {
        this.patientcivilPK = new PatientcivilPK(idPerson, date);
    }

    public PatientcivilPK getPatientcivilPK() {
        return patientcivilPK;
    }

    public void setPatientcivilPK(PatientcivilPK patientcivilPK) {
        this.patientcivilPK = patientcivilPK;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Civilstatus getIdCivilStatus() {
        return idCivilStatus;
    }

    public void setIdCivilStatus(Civilstatus idCivilStatus) {
        this.idCivilStatus = idCivilStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientcivilPK != null ? patientcivilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientcivil)) {
            return false;
        }
        Patientcivil other = (Patientcivil) object;
        if ((this.patientcivilPK == null && other.patientcivilPK != null) || (this.patientcivilPK != null && !this.patientcivilPK.equals(other.patientcivilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Patientcivil[ patientcivilPK=" + patientcivilPK + " ]";
    }
    
}
