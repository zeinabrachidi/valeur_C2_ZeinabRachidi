/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "takingvital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Takingvital.findAll", query = "SELECT t FROM Takingvital t")
    , @NamedQuery(name = "Takingvital.findByIdtakingvital", query = "SELECT t FROM Takingvital t WHERE t.idtakingvital = :idtakingvital")
    , @NamedQuery(name = "Takingvital.findByTakingvitalDate", query = "SELECT t FROM Takingvital t WHERE t.takingvitalDate = :takingvitalDate")
    , @NamedQuery(name = "Takingvital.findByWeight", query = "SELECT t FROM Takingvital t WHERE t.weight = :weight")
    , @NamedQuery(name = "Takingvital.findByHeartBeat", query = "SELECT t FROM Takingvital t WHERE t.heartBeat = :heartBeat")
    , @NamedQuery(name = "Takingvital.findBy\u0627highPressure", query = "SELECT t FROM Takingvital t WHERE t.\u0627highPressure = :\u0627highPressure")
    , @NamedQuery(name = "Takingvital.findByLowPressure", query = "SELECT t FROM Takingvital t WHERE t.lowPressure = :lowPressure")})
public class Takingvital implements Serializable {

    @JoinColumn(name = "idPersonAux", referencedColumnName = "IdPerson")
    @ManyToOne
    private Auxiliary idPersonAux;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtakingvital")
    private Integer idtakingvital;
    @Column(name = "takingvitalDate")
    @Temporal(TemporalType.DATE)
    private Date takingvitalDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "weight")
    private BigDecimal weight;
    @Column(name = "heartBeat")
    private Integer heartBeat;
    @Column(name = "\u0627highPressure")
    private Integer اhighPressure;
    @Column(name = "lowPressure")
    private Integer lowPressure;
    @JoinColumn(name = "idMedicalActHosp", referencedColumnName = "idMedicalAct")
    @ManyToOne
    private Hospitalization idMedicalActHosp;

    public Takingvital() {
    }

    public Takingvital(Integer idtakingvital) {
        this.idtakingvital = idtakingvital;
    }

    public Integer getIdtakingvital() {
        return idtakingvital;
    }

    public void setIdtakingvital(Integer idtakingvital) {
        this.idtakingvital = idtakingvital;
    }

    public Date getTakingvitalDate() {
        return takingvitalDate;
    }

    public void setTakingvitalDate(Date takingvitalDate) {
        this.takingvitalDate = takingvitalDate;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(Integer heartBeat) {
        this.heartBeat = heartBeat;
    }

    public Integer getاhighPressure() {
        return اhighPressure;
    }

    public void setاhighPressure(Integer اhighPressure) {
        this.اhighPressure = اhighPressure;
    }

    public Integer getLowPressure() {
        return lowPressure;
    }

    public void setLowPressure(Integer lowPressure) {
        this.lowPressure = lowPressure;
    }

    public Hospitalization getIdMedicalActHosp() {
        return idMedicalActHosp;
    }

    public void setIdMedicalActHosp(Hospitalization idMedicalActHosp) {
        this.idMedicalActHosp = idMedicalActHosp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtakingvital != null ? idtakingvital.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Takingvital)) {
            return false;
        }
        Takingvital other = (Takingvital) object;
        if ((this.idtakingvital == null && other.idtakingvital != null) || (this.idtakingvital != null && !this.idtakingvital.equals(other.idtakingvital))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Takingvital[ idtakingvital=" + idtakingvital + " ]";
    }

    public Auxiliary getIdPersonAux() {
        return idPersonAux;
    }

    public void setIdPersonAux(Auxiliary idPersonAux) {
        this.idPersonAux = idPersonAux;
    }
    
}
