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
@Table(name = "conssubmed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conssubmed.findAll", query = "SELECT c FROM Conssubmed c")
    , @NamedQuery(name = "Conssubmed.findByIdMedicalact", query = "SELECT c FROM Conssubmed c WHERE c.conssubmedPK.idMedicalact = :idMedicalact")
    , @NamedQuery(name = "Conssubmed.findByIdSubMedicine", query = "SELECT c FROM Conssubmed c WHERE c.conssubmedPK.idSubMedicine = :idSubMedicine")
    , @NamedQuery(name = "Conssubmed.findByQty", query = "SELECT c FROM Conssubmed c WHERE c.qty = :qty")
    , @NamedQuery(name = "Conssubmed.findByTimes", query = "SELECT c FROM Conssubmed c WHERE c.times = :times")})
public class Conssubmed implements Serializable {

    @JoinColumn(name = "idMedicalact", referencedColumnName = "idMedicalActCons", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Consultation consultation;
    @JoinColumn(name = "idSubMedicine", referencedColumnName = "idSubmedicine", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Submedicine submedicine;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConssubmedPK conssubmedPK;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "times")
    private Integer times;

    public Conssubmed() {
    }

    public Conssubmed(ConssubmedPK conssubmedPK) {
        this.conssubmedPK = conssubmedPK;
    }

    public Conssubmed(int idMedicalact, int idSubMedicine) {
        this.conssubmedPK = new ConssubmedPK(idMedicalact, idSubMedicine);
    }

    public ConssubmedPK getConssubmedPK() {
        return conssubmedPK;
    }

    public void setConssubmedPK(ConssubmedPK conssubmedPK) {
        this.conssubmedPK = conssubmedPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conssubmedPK != null ? conssubmedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conssubmed)) {
            return false;
        }
        Conssubmed other = (Conssubmed) object;
        if ((this.conssubmedPK == null && other.conssubmedPK != null) || (this.conssubmedPK != null && !this.conssubmedPK.equals(other.conssubmedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Conssubmed[ conssubmedPK=" + conssubmedPK + " ]";
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Submedicine getSubmedicine() {
        return submedicine;
    }

    public void setSubmedicine(Submedicine submedicine) {
        this.submedicine = submedicine;
    }
    
}
