/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "medisubmed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medisubmed.findAll", query = "SELECT m FROM Medisubmed m")
    , @NamedQuery(name = "Medisubmed.findByIdmedication", query = "SELECT m FROM Medisubmed m WHERE m.medisubmedPK.idmedication = :idmedication")
    , @NamedQuery(name = "Medisubmed.findByIdSubMedicine", query = "SELECT m FROM Medisubmed m WHERE m.medisubmedPK.idSubMedicine = :idSubMedicine")
    , @NamedQuery(name = "Medisubmed.findByQty", query = "SELECT m FROM Medisubmed m WHERE m.qty = :qty")
    , @NamedQuery(name = "Medisubmed.findByTimes", query = "SELECT m FROM Medisubmed m WHERE m.times = :times")})
public class Medisubmed implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MedisubmedPK medisubmedPK;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "times")
    private Integer times;
    @JoinColumn(name = "idSubMedicine", referencedColumnName = "idSubmedicine", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Submedicine submedicine;
    @JoinColumn(name = "idmedication", referencedColumnName = "idMedication", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medication medication;

    public Medisubmed() {
    }

    public Medisubmed(MedisubmedPK medisubmedPK) {
        this.medisubmedPK = medisubmedPK;
    }

    public Medisubmed(int idmedication, int idSubMedicine) {
        this.medisubmedPK = new MedisubmedPK(idmedication, idSubMedicine);
    }

    public MedisubmedPK getMedisubmedPK() {
        return medisubmedPK;
    }

    public void setMedisubmedPK(MedisubmedPK medisubmedPK) {
        this.medisubmedPK = medisubmedPK;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Submedicine getSubmedicine() {
        return submedicine;
    }

    public void setSubmedicine(Submedicine submedicine) {
        this.submedicine = submedicine;
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
        hash += (medisubmedPK != null ? medisubmedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medisubmed)) {
            return false;
        }
        Medisubmed other = (Medisubmed) object;
        if ((this.medisubmedPK == null && other.medisubmedPK != null) || (this.medisubmedPK != null && !this.medisubmedPK.equals(other.medisubmedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Medisubmed[ medisubmedPK=" + medisubmedPK + " ]";
    }
    
}
