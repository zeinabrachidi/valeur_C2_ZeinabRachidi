/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
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
@Table(name = "card_demand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardDemand.findAll", query = "SELECT c FROM CardDemand c")
    , @NamedQuery(name = "CardDemand.findByIdcardDemand", query = "SELECT c FROM CardDemand c WHERE c.idcardDemand = :idcardDemand")
    , @NamedQuery(name = "CardDemand.findByCarddemandDate", query = "SELECT c FROM CardDemand c WHERE c.carddemandDate = :carddemandDate")})
public class CardDemand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcard_demand")
    private Integer idcardDemand;
    @Column(name = "card_demandDate")
    @Temporal(TemporalType.DATE)
    private Date carddemandDate;
    @JoinColumn(name = "idPerson", referencedColumnName = "IdPerson")
    @ManyToOne
    private Patient idPerson;

    public CardDemand() {
    }

    public CardDemand(Integer idcardDemand) {
        this.idcardDemand = idcardDemand;
    }

    public Integer getIdcardDemand() {
        return idcardDemand;
    }

    public void setIdcardDemand(Integer idcardDemand) {
        this.idcardDemand = idcardDemand;
    }

    public Date getCarddemandDate() {
        return carddemandDate;
    }

    public void setCarddemandDate(Date carddemandDate) {
        this.carddemandDate = carddemandDate;
    }

    public Patient getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Patient idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcardDemand != null ? idcardDemand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardDemand)) {
            return false;
        }
        CardDemand other = (CardDemand) object;
        if ((this.idcardDemand == null && other.idcardDemand != null) || (this.idcardDemand != null && !this.idcardDemand.equals(other.idcardDemand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.CardDemand[ idcardDemand=" + idcardDemand + " ]";
    }
    
}
