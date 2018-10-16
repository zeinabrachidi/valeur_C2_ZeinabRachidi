/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "testlab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testlab.findAll", query = "SELECT t FROM Testlab t")
    , @NamedQuery(name = "Testlab.findByIdTestLab", query = "SELECT t FROM Testlab t WHERE t.idTestLab = :idTestLab")
    , @NamedQuery(name = "Testlab.findByDateTest", query = "SELECT t FROM Testlab t WHERE t.dateTest = :dateTest")})
public class Testlab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTestLab")
    private Integer idTestLab;
    @Column(name = "dateTest")
    @Temporal(TemporalType.DATE)
    private Date dateTest;
    @JoinColumn(name = "iidPersonTech", referencedColumnName = "IdPerson")
    @ManyToOne
    private Technician iidPersonTech;
    @JoinColumn(name = "idLaboratory", referencedColumnName = "idLaboratory")
    @ManyToOne
    private Laboratory idLaboratory;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "testlab")
    private Hosptestlab hosptestlab;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testlab")
    private Collection<Resulttest> resulttestCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "testlab")
    private Constestlab constestlab;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testlab")
    private Collection<Testlabtest> testlabtestCollection;

    public Testlab() {
    }

    public Testlab(Integer idTestLab) {
        this.idTestLab = idTestLab;
    }

    public Integer getIdTestLab() {
        return idTestLab;
    }

    public void setIdTestLab(Integer idTestLab) {
        this.idTestLab = idTestLab;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
    }

    public Technician getIidPersonTech() {
        return iidPersonTech;
    }

    public void setIidPersonTech(Technician iidPersonTech) {
        this.iidPersonTech = iidPersonTech;
    }

    public Laboratory getIdLaboratory() {
        return idLaboratory;
    }

    public void setIdLaboratory(Laboratory idLaboratory) {
        this.idLaboratory = idLaboratory;
    }

    public Hosptestlab getHosptestlab() {
        return hosptestlab;
    }

    public void setHosptestlab(Hosptestlab hosptestlab) {
        this.hosptestlab = hosptestlab;
    }

    @XmlTransient
    public Collection<Resulttest> getResulttestCollection() {
        return resulttestCollection;
    }

    public void setResulttestCollection(Collection<Resulttest> resulttestCollection) {
        this.resulttestCollection = resulttestCollection;
    }

    public Constestlab getConstestlab() {
        return constestlab;
    }

    public void setConstestlab(Constestlab constestlab) {
        this.constestlab = constestlab;
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
        hash += (idTestLab != null ? idTestLab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testlab)) {
            return false;
        }
        Testlab other = (Testlab) object;
        if ((this.idTestLab == null && other.idTestLab != null) || (this.idTestLab != null && !this.idTestLab.equals(other.idTestLab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Testlab[ idTestLab=" + idTestLab + " ]";
    }
    
}
