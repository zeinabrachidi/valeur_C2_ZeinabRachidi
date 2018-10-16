/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "consultmedication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultmedication.findAll", query = "SELECT c FROM Consultmedication c")
    , @NamedQuery(name = "Consultmedication.findByIdMedication", query = "SELECT c FROM Consultmedication c WHERE c.idMedication = :idMedication")})
public class Consultmedication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedication")
    private Integer idMedication;
    @JoinColumn(name = "idMedicalAct", referencedColumnName = "idMedicalActCons")
    @ManyToOne
    private Consultation idMedicalAct;
    @JoinColumn(name = "idMedication", referencedColumnName = "idMedication", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Medication medication;

    public Consultmedication() {
    }

    public Consultmedication(Integer idMedication) {
        this.idMedication = idMedication;
    }

    public Integer getIdMedication() {
        return idMedication;
    }

    public void setIdMedication(Integer idMedication) {
        this.idMedication = idMedication;
    }

    public Consultation getIdMedicalAct() {
        return idMedicalAct;
    }

    public void setIdMedicalAct(Consultation idMedicalAct) {
        this.idMedicalAct = idMedicalAct;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedication != null ? idMedication.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultmedication)) {
            return false;
        }
        Consultmedication other = (Consultmedication) object;
        if ((this.idMedication == null && other.idMedication != null) || (this.idMedication != null && !this.idMedication.equals(other.idMedication))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Consultmedication[ idMedication=" + idMedication + " ]";
    }
    
}
