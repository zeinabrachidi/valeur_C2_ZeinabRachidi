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
@Table(name = "resulttest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resulttest.findAll", query = "SELECT r FROM Resulttest r")
    , @NamedQuery(name = "Resulttest.findByIdTestLab", query = "SELECT r FROM Resulttest r WHERE r.resulttestPK.idTestLab = :idTestLab")
    , @NamedQuery(name = "Resulttest.findByIdTest", query = "SELECT r FROM Resulttest r WHERE r.resulttestPK.idTest = :idTest")
    , @NamedQuery(name = "Resulttest.findByDescResult", query = "SELECT r FROM Resulttest r WHERE r.descResult = :descResult")})
public class Resulttest implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResulttestPK resulttestPK;
    @Size(max = 300)
    @Column(name = "descResult")
    private String descResult;
    @JoinColumn(name = "idTestLab", referencedColumnName = "idTestLab", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Testlab testlab;
    @JoinColumn(name = "idTest", referencedColumnName = "idTest", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Test test;

    public Resulttest() {
    }

    public Resulttest(ResulttestPK resulttestPK) {
        this.resulttestPK = resulttestPK;
    }

    public Resulttest(int idTestLab, int idTest) {
        this.resulttestPK = new ResulttestPK(idTestLab, idTest);
    }

    public ResulttestPK getResulttestPK() {
        return resulttestPK;
    }

    public void setResulttestPK(ResulttestPK resulttestPK) {
        this.resulttestPK = resulttestPK;
    }

    public String getDescResult() {
        return descResult;
    }

    public void setDescResult(String descResult) {
        this.descResult = descResult;
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
        hash += (resulttestPK != null ? resulttestPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resulttest)) {
            return false;
        }
        Resulttest other = (Resulttest) object;
        if ((this.resulttestPK == null && other.resulttestPK != null) || (this.resulttestPK != null && !this.resulttestPK.equals(other.resulttestPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Resulttest[ resulttestPK=" + resulttestPK + " ]";
    }
    
}
