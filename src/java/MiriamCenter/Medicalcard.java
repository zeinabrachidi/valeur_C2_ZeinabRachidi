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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "medicalcard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicalcard.findAll", query = "SELECT m FROM Medicalcard m")
    , @NamedQuery(name = "Medicalcard.findByIdmedicaCard", query = "SELECT m FROM Medicalcard m WHERE m.idmedicaCard = :idmedicaCard")
    , @NamedQuery(name = "Medicalcard.findByEmissionDate", query = "SELECT m FROM Medicalcard m WHERE m.emissionDate = :emissionDate")})
public class Medicalcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmedicaCard")
    private Integer idmedicaCard;
    @Column(name = "emissionDate")
    @Temporal(TemporalType.DATE)
    private Date emissionDate;
    @JoinColumn(name = "IdPersonPat", referencedColumnName = "IdPerson")
    @ManyToOne
    private Patient idPersonPat;
    @OneToMany(mappedBy = "idMedicalCard")
    private Collection<Medicalact> medicalactCollection;

    public Medicalcard() {
    }

    public Medicalcard(Integer idmedicaCard) {
        this.idmedicaCard = idmedicaCard;
    }

    public Integer getIdmedicaCard() {
        return idmedicaCard;
    }

    public void setIdmedicaCard(Integer idmedicaCard) {
        this.idmedicaCard = idmedicaCard;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
    }

    public Patient getIdPersonPat() {
        return idPersonPat;
    }

    public void setIdPersonPat(Patient idPersonPat) {
        this.idPersonPat = idPersonPat;
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
        hash += (idmedicaCard != null ? idmedicaCard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicalcard)) {
            return false;
        }
        Medicalcard other = (Medicalcard) object;
        if ((this.idmedicaCard == null && other.idmedicaCard != null) || (this.idmedicaCard != null && !this.idmedicaCard.equals(other.idmedicaCard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Medicalcard[ idmedicaCard=" + idmedicaCard + " ]";
    }
    
}
