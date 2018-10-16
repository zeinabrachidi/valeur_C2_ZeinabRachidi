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
@Table(name = "hospsubmed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospsubmed.findAll", query = "SELECT h FROM Hospsubmed h")
    , @NamedQuery(name = "Hospsubmed.findByIdMedicalAct", query = "SELECT h FROM Hospsubmed h WHERE h.hospsubmedPK.idMedicalAct = :idMedicalAct")
    , @NamedQuery(name = "Hospsubmed.findByIdSubMedicine", query = "SELECT h FROM Hospsubmed h WHERE h.hospsubmedPK.idSubMedicine = :idSubMedicine")
    , @NamedQuery(name = "Hospsubmed.findByQty", query = "SELECT h FROM Hospsubmed h WHERE h.qty = :qty")
    , @NamedQuery(name = "Hospsubmed.findByTimes", query = "SELECT h FROM Hospsubmed h WHERE h.times = :times")})
public class Hospsubmed implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HospsubmedPK hospsubmedPK;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "times")
    private Integer times;
    @JoinColumn(name = "idMedicalAct", referencedColumnName = "idMedicalAct", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hospitalization hospitalization;
    @JoinColumn(name = "idSubMedicine", referencedColumnName = "idSubmedicine", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Submedicine submedicine;

    public Hospsubmed() {
    }

    public Hospsubmed(HospsubmedPK hospsubmedPK) {
        this.hospsubmedPK = hospsubmedPK;
    }

    public Hospsubmed(int idMedicalAct, int idSubMedicine) {
        this.hospsubmedPK = new HospsubmedPK(idMedicalAct, idSubMedicine);
    }

    public HospsubmedPK getHospsubmedPK() {
        return hospsubmedPK;
    }

    public void setHospsubmedPK(HospsubmedPK hospsubmedPK) {
        this.hospsubmedPK = hospsubmedPK;
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

    public Hospitalization getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    public Submedicine getSubmedicine() {
        return submedicine;
    }

    public void setSubmedicine(Submedicine submedicine) {
        this.submedicine = submedicine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hospsubmedPK != null ? hospsubmedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospsubmed)) {
            return false;
        }
        Hospsubmed other = (Hospsubmed) object;
        if ((this.hospsubmedPK == null && other.hospsubmedPK != null) || (this.hospsubmedPK != null && !this.hospsubmedPK.equals(other.hospsubmedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Hospsubmed[ hospsubmedPK=" + hospsubmedPK + " ]";
    }
    
}
