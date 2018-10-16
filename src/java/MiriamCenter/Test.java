/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
    , @NamedQuery(name = "Test.findByIdTest", query = "SELECT t FROM Test t WHERE t.idTest = :idTest")
    , @NamedQuery(name = "Test.findByTestName", query = "SELECT t FROM Test t WHERE t.testName = :testName")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTest")
    private Integer idTest;
    @Size(max = 30)
    @Column(name = "testName")
    private String testName;
    @ManyToMany(mappedBy = "testCollection")
    private Collection<Hospitalization> hospitalizationCollection;
    @ManyToMany(mappedBy = "testCollection")
    private Collection<Consultation> consultationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
    private Collection<Resulttest> resulttestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
    private Collection<Testpricing> testpricingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
    private Collection<Testlabtest> testlabtestCollection;

    public Test() {
    }

    public Test(Integer idTest) {
        this.idTest = idTest;
    }

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @XmlTransient
    public Collection<Hospitalization> getHospitalizationCollection() {
        return hospitalizationCollection;
    }

    public void setHospitalizationCollection(Collection<Hospitalization> hospitalizationCollection) {
        this.hospitalizationCollection = hospitalizationCollection;
    }

    @XmlTransient
    public Collection<Consultation> getConsultationCollection() {
        return consultationCollection;
    }

    public void setConsultationCollection(Collection<Consultation> consultationCollection) {
        this.consultationCollection = consultationCollection;
    }

    @XmlTransient
    public Collection<Resulttest> getResulttestCollection() {
        return resulttestCollection;
    }

    public void setResulttestCollection(Collection<Resulttest> resulttestCollection) {
        this.resulttestCollection = resulttestCollection;
    }

    @XmlTransient
    public Collection<Testpricing> getTestpricingCollection() {
        return testpricingCollection;
    }

    public void setTestpricingCollection(Collection<Testpricing> testpricingCollection) {
        this.testpricingCollection = testpricingCollection;
    }

    @XmlTransient
    public Collection<Testlabtest> getTestlabtestCollection() {
        return testlabtestCollection;
    }

    public void setTestlabtestCollection(Collection<Testlabtest> testlabtestCollection) {
        this.testlabtestCollection = testlabtestCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTest != null ? idTest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.idTest == null && other.idTest != null) || (this.idTest != null && !this.idTest.equals(other.idTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Test[ idTest=" + idTest + " ]";
    }
    
}
