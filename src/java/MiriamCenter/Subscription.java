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
@Table(name = "subscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s")
    , @NamedQuery(name = "Subscription.findByIdsubscription", query = "SELECT s FROM Subscription s WHERE s.idsubscription = :idsubscription")
    , @NamedQuery(name = "Subscription.findBySubscriptionDate", query = "SELECT s FROM Subscription s WHERE s.subscriptionDate = :subscriptionDate")})
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsubscription")
    private Integer idsubscription;
    @Column(name = "subscription_Date")
    @Temporal(TemporalType.DATE)
    private Date subscriptionDate;
    @JoinColumn(name = "idPerson", referencedColumnName = "idPerson")
    @ManyToOne
    private Person idPerson;

    public Subscription() {
    }

    public Subscription(Integer idsubscription) {
        this.idsubscription = idsubscription;
    }

    public Integer getIdsubscription() {
        return idsubscription;
    }

    public void setIdsubscription(Integer idsubscription) {
        this.idsubscription = idsubscription;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Person getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubscription != null ? idsubscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.idsubscription == null && other.idsubscription != null) || (this.idsubscription != null && !this.idsubscription.equals(other.idsubscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Subscription[ idsubscription=" + idsubscription + " ]";
    }
    
}
