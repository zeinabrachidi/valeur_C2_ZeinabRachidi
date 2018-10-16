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
@Table(name = "hospmedication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospmedication.findAll", query = "SELECT h FROM Hospmedication h")
    , @NamedQuery(name = "Hospmedication.findByIdmedication", query = "SELECT h FROM Hospmedication h WHERE h.idmedication = :idmedication")})
public class Hospmedication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmedication")
    private Integer idmedication;
    @JoinColumn(name = "idMedicalActHosp", referencedColumnName = "idMedicalAct")
    @ManyToOne(optional = false)
    private Hospitalization idMedicalActHosp;
    @JoinColumn(name = "idmedication", referencedColumnName = "idMedication", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Medication medication;

    public Hospmedication() {
    }

    public Hospmedication(Integer idmedication) {
        this.idmedication = idmedication;
    }

    public Integer getIdmedication() {
        return idmedication;
    }

    public void setIdmedication(Integer idmedication) {
        this.idmedication = idmedication;
    }

    public Hospitalization getIdMedicalActHosp() {
        return idMedicalActHosp;
    }

    public void setIdMedicalActHosp(Hospitalization idMedicalActHosp) {
        this.idMedicalActHosp = idMedicalActHosp;
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
        hash += (idmedication != null ? idmedication.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospmedication)) {
            return false;
        }
        Hospmedication other = (Hospmedication) object;
        if ((this.idmedication == null && other.idmedication != null) || (this.idmedication != null && !this.idmedication.equals(other.idmedication))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Hospmedication[ idmedication=" + idmedication + " ]";
    }
    
}
