/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "street")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Street.findAll", query = "SELECT s FROM Street s")
    , @NamedQuery(name = "Street.findByIdstreet", query = "SELECT s FROM Street s WHERE s.idstreet = :idstreet")
    , @NamedQuery(name = "Street.findByStreetName", query = "SELECT s FROM Street s WHERE s.streetName = :streetName")})
public class Street implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstreet")
    private Integer idstreet;
    @Size(max = 30)
    @Column(name = "streetName")
    private String streetName;
    @OneToMany(mappedBy = "streetId")
    private Collection<Person> personCollection;
    @JoinColumn(name = "idRegion", referencedColumnName = "idRegion")
    @ManyToOne
    private Region idRegion;

    public Street() {
    }

    public Street(Integer idstreet) {
        this.idstreet = idstreet;
    }

    public Integer getIdstreet() {
        return idstreet;
    }

    public void setIdstreet(Integer idstreet) {
        this.idstreet = idstreet;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    public Region getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Region idRegion) {
        this.idRegion = idRegion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstreet != null ? idstreet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Street)) {
            return false;
        }
        Street other = (Street) object;
        if ((this.idstreet == null && other.idstreet != null) || (this.idstreet != null && !this.idstreet.equals(other.idstreet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Street[ idstreet=" + idstreet + " ]";
    }
    
}
