/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author zeina
 */
@Embeddable
public class TestlabtestPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idTestLab")
    private int idTestLab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTest")
    private int idTest;

    public TestlabtestPK() {
    }

    public TestlabtestPK(int idTestLab, int idTest) {
        this.idTestLab = idTestLab;
        this.idTest = idTest;
    }

    public int getIdTestLab() {
        return idTestLab;
    }

    public void setIdTestLab(int idTestLab) {
        this.idTestLab = idTestLab;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTestLab;
        hash += (int) idTest;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestlabtestPK)) {
            return false;
        }
        TestlabtestPK other = (TestlabtestPK) object;
        if (this.idTestLab != other.idTestLab) {
            return false;
        }
        if (this.idTest != other.idTest) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.TestlabtestPK[ idTestLab=" + idTestLab + ", idTest=" + idTest + " ]";
    }
    
}
