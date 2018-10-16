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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "testlabtest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testlabtest.findAll", query = "SELECT t FROM Testlabtest t")
    , @NamedQuery(name = "Testlabtest.findByIdTestLab", query = "SELECT t FROM Testlabtest t WHERE t.testlabtestPK.idTestLab = :idTestLab")
    , @NamedQuery(name = "Testlabtest.findByIdTest", query = "SELECT t FROM Testlabtest t WHERE t.testlabtestPK.idTest = :idTest")
    , @NamedQuery(name = "Testlabtest.findByTestResult", query = "SELECT t FROM Testlabtest t WHERE t.testResult = :testResult")})
public class Testlabtest implements Serializable {

    //@JoinColumn(name = "idTestLab", referencedColumnName = "idTestLab", insertable = false, updatable = false)
    //@ManyToOne(optional = false)
    //private Testlab testlab;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TestlabtestPK testlabtestPK;
    @Size(max = 300)
    @Column(name = "testResult")
    private String testResult;
    @JoinColumn(name = "idTestLab", referencedColumnName = "idTestLab", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Testlab testlab;
    @JoinColumn(name = "idTest", referencedColumnName = "idTest", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Test test;

    public Testlabtest() {
    }

    public Testlabtest(TestlabtestPK testlabtestPK) {
        this.testlabtestPK = testlabtestPK;
    }

    public Testlabtest(int idTestLab, int idTest) {
        this.testlabtestPK = new TestlabtestPK(idTestLab, idTest);
    }

    public TestlabtestPK getTestlabtestPK() {
        return testlabtestPK;
    }

    public void setTestlabtestPK(TestlabtestPK testlabtestPK) {
        this.testlabtestPK = testlabtestPK;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Testlab getTestlab() {
        return testlab;
    }

    public void setTestlab(Testlab testlab) {
        this.testlab = testlab;
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
        hash += (testlabtestPK != null ? testlabtestPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testlabtest)) {
            return false;
        }
        Testlabtest other = (Testlabtest) object;
        if ((this.testlabtestPK == null && other.testlabtestPK != null) || (this.testlabtestPK != null && !this.testlabtestPK.equals(other.testlabtestPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Testlabtest[ testlabtestPK=" + testlabtestPK + " ]";
    }

    //public Testlab getTestlab() {
    //    return testlab;
   // }

    //public void setTestlab(Testlab testlab) {
    //    this.testlab = testlab;
   // }
    
}
