/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "testpricing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testpricing.findAll", query = "SELECT t FROM Testpricing t")
    , @NamedQuery(name = "Testpricing.findByIdTest", query = "SELECT t FROM Testpricing t WHERE t.testpricingPK.idTest = :idTest")
    , @NamedQuery(name = "Testpricing.findByDate", query = "SELECT t FROM Testpricing t WHERE t.testpricingPK.date = :date")
    , @NamedQuery(name = "Testpricing.findByPrice", query = "SELECT t FROM Testpricing t WHERE t.price = :price")})
public class Testpricing implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TestpricingPK testpricingPK;
    @Column(name = "price")
    private Integer price;
    @JoinColumn(name = "idTest", referencedColumnName = "idTest", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Test test;

    public Testpricing() {
    }

    public Testpricing(TestpricingPK testpricingPK) {
        this.testpricingPK = testpricingPK;
    }

    public Testpricing(int idTest, Date date) {
        this.testpricingPK = new TestpricingPK(idTest, date);
    }

    public TestpricingPK getTestpricingPK() {
        return testpricingPK;
    }

    public void setTestpricingPK(TestpricingPK testpricingPK) {
        this.testpricingPK = testpricingPK;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testpricingPK != null ? testpricingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testpricing)) {
            return false;
        }
        Testpricing other = (Testpricing) object;
        if ((this.testpricingPK == null && other.testpricingPK != null) || (this.testpricingPK != null && !this.testpricingPK.equals(other.testpricingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Testpricing[ testpricingPK=" + testpricingPK + " ]";
    }
    
}
