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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "insurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insurance.findAll", query = "SELECT i FROM Insurance i")
    , @NamedQuery(name = "Insurance.findByIdinsurance", query = "SELECT i FROM Insurance i WHERE i.idinsurance = :idinsurance")
    , @NamedQuery(name = "Insurance.findByInsuranceName", query = "SELECT i FROM Insurance i WHERE i.insuranceName = :insuranceName")})
public class Insurance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idinsurance")
    private Integer idinsurance;
    @Size(max = 30)
    @Column(name = "insurance_name")
    private String insuranceName;

    public Insurance() {
    }

    public Insurance(Integer idinsurance) {
        this.idinsurance = idinsurance;
    }

    public Integer getIdinsurance() {
        return idinsurance;
    }

    public void setIdinsurance(Integer idinsurance) {
        this.idinsurance = idinsurance;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinsurance != null ? idinsurance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insurance)) {
            return false;
        }
        Insurance other = (Insurance) object;
        if ((this.idinsurance == null && other.idinsurance != null) || (this.idinsurance != null && !this.idinsurance.equals(other.idinsurance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Insurance[ idinsurance=" + idinsurance + " ]";
    }
    
}
