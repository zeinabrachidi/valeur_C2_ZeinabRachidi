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
@Table(name = "hosptestlab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hosptestlab.findAll", query = "SELECT h FROM Hosptestlab h")
    , @NamedQuery(name = "Hosptestlab.findByIdTestLab", query = "SELECT h FROM Hosptestlab h WHERE h.idTestLab = :idTestLab")})
public class Hosptestlab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTestLab")
    private Integer idTestLab;
    @JoinColumn(name = "idMedicalActHosp", referencedColumnName = "idMedicalAct")
    @ManyToOne
    private Hospitalization idMedicalActHosp;
    @JoinColumn(name = "idTestLab", referencedColumnName = "idTestLab", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Testlab testlab;

    public Hosptestlab() {
    }

    public Hosptestlab(Integer idTestLab) {
        this.idTestLab = idTestLab;
    }

    public Integer getIdTestLab() {
        return idTestLab;
    }

    public void setIdTestLab(Integer idTestLab) {
        this.idTestLab = idTestLab;
    }

    public Hospitalization getIdMedicalActHosp() {
        return idMedicalActHosp;
    }

    public void setIdMedicalActHosp(Hospitalization idMedicalActHosp) {
        this.idMedicalActHosp = idMedicalActHosp;
    }

    public Testlab getTestlab() {
        return testlab;
    }

    public void setTestlab(Testlab testlab) {
        this.testlab = testlab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTestLab != null ? idTestLab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hosptestlab)) {
            return false;
        }
        Hosptestlab other = (Hosptestlab) object;
        if ((this.idTestLab == null && other.idTestLab != null) || (this.idTestLab != null && !this.idTestLab.equals(other.idTestLab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Hosptestlab[ idTestLab=" + idTestLab + " ]";
    }
    
}
