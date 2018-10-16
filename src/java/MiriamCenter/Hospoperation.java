/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
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
@Table(name = "hospoperation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospoperation.findAll", query = "SELECT h FROM Hospoperation h")
    , @NamedQuery(name = "Hospoperation.findByIdMedicalAct", query = "SELECT h FROM Hospoperation h WHERE h.hospoperationPK.idMedicalAct = :idMedicalAct")
    , @NamedQuery(name = "Hospoperation.findByIdOperation", query = "SELECT h FROM Hospoperation h WHERE h.hospoperationPK.idOperation = :idOperation")})
public class Hospoperation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HospoperationPK hospoperationPK;
    @JoinColumn(name = "idMedicalAct", referencedColumnName = "idMedicalAct", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hospitalization hospitalization;
    @JoinColumn(name = "idOperation", referencedColumnName = "idOperation", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Operation operation;
    @JoinColumn(name = "idPersonDoc", referencedColumnName = "IdPerson")
    @ManyToOne
    private Doctor idPersonDoc;

    public Hospoperation() {
    }

    public Hospoperation(HospoperationPK hospoperationPK) {
        this.hospoperationPK = hospoperationPK;
    }

    public Hospoperation(int idMedicalAct, int idOperation) {
        this.hospoperationPK = new HospoperationPK(idMedicalAct, idOperation);
    }

    public HospoperationPK getHospoperationPK() {
        return hospoperationPK;
    }

    public void setHospoperationPK(HospoperationPK hospoperationPK) {
        this.hospoperationPK = hospoperationPK;
    }

    public Hospitalization getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Doctor getIdPersonDoc() {
        return idPersonDoc;
    }

    public void setIdPersonDoc(Doctor idPersonDoc) {
        this.idPersonDoc = idPersonDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hospoperationPK != null ? hospoperationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospoperation)) {
            return false;
        }
        Hospoperation other = (Hospoperation) object;
        if ((this.hospoperationPK == null && other.hospoperationPK != null) || (this.hospoperationPK != null && !this.hospoperationPK.equals(other.hospoperationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Hospoperation[ hospoperationPK=" + hospoperationPK + " ]";
    }
    
}
