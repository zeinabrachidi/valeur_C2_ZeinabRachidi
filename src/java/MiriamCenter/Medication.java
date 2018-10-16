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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "medication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medication.findAll", query = "SELECT m FROM Medication m")
    , @NamedQuery(name = "Medication.findByIdMedication", query = "SELECT m FROM Medication m WHERE m.idMedication = :idMedication")
    , @NamedQuery(name = "Medication.findByMedicationDate", query = "SELECT m FROM Medication m WHERE m.medicationDate = :medicationDate")})
public class Medication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedication")
    private Integer idMedication;
    @Column(name = "medicationDate")
    @Temporal(TemporalType.DATE)
    private Date medicationDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "medication")
    private Hospmedication hospmedication;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "medication")
    private Consultmedication consultmedication;
    @JoinColumn(name = "idpharmacy", referencedColumnName = "idpharmacy")
    @ManyToOne
    private Pharmacy idpharmacy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medication")
    private Collection<Medisubmed> medisubmedCollection;

    public Medication() {
    }

    public Medication(Integer idMedication) {
        this.idMedication = idMedication;
    }

    public Integer getIdMedication() {
        return idMedication;
    }

    public void setIdMedication(Integer idMedication) {
        this.idMedication = idMedication;
    }

    public Date getMedicationDate() {
        return medicationDate;
    }

    public void setMedicationDate(Date medicationDate) {
        this.medicationDate = medicationDate;
    }

    public Hospmedication getHospmedication() {
        return hospmedication;
    }

    public void setHospmedication(Hospmedication hospmedication) {
        this.hospmedication = hospmedication;
    }

    public Consultmedication getConsultmedication() {
        return consultmedication;
    }

    public void setConsultmedication(Consultmedication consultmedication) {
        this.consultmedication = consultmedication;
    }

    public Pharmacy getIdpharmacy() {
        return idpharmacy;
    }

    public void setIdpharmacy(Pharmacy idpharmacy) {
        this.idpharmacy = idpharmacy;
    }

    @XmlTransient
    public Collection<Medisubmed> getMedisubmedCollection() {
        return medisubmedCollection;
    }

    public void setMedisubmedCollection(Collection<Medisubmed> medisubmedCollection) {
        this.medisubmedCollection = medisubmedCollection;
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
        if (!(object instanceof Medication)) {
            return false;
        }
        Medication other = (Medication) object;
        if ((this.idMedication == null && other.idMedication != null) || (this.idMedication != null && !this.idMedication.equals(other.idMedication))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Medication[ idMedication=" + idMedication + " ]";
    }
    
}
