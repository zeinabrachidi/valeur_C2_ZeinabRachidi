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
@Table(name = "profession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profession.findAll", query = "SELECT p FROM Profession p")
    , @NamedQuery(name = "Profession.findByIdprofession", query = "SELECT p FROM Profession p WHERE p.idprofession = :idprofession")
    , @NamedQuery(name = "Profession.findByProfessionname", query = "SELECT p FROM Profession p WHERE p.professionname = :professionname")})
public class Profession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprofession")
    private Integer idprofession;
    @Size(max = 15)
    @Column(name = "professionname")
    private String professionname;
    @OneToMany(mappedBy = "idProfession")
    private Collection<Person> personCollection;

    public Profession() {
    }

    public Profession(Integer idprofession) {
        this.idprofession = idprofession;
    }

    public Integer getIdprofession() {
        return idprofession;
    }

    public void setIdprofession(Integer idprofession) {
        this.idprofession = idprofession;
    }

    public String getProfessionname() {
        return professionname;
    }

    public void setProfessionname(String professionname) {
        this.professionname = professionname;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofession != null ? idprofession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profession)) {
            return false;
        }
        Profession other = (Profession) object;
        if ((this.idprofession == null && other.idprofession != null) || (this.idprofession != null && !this.idprofession.equals(other.idprofession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Profession[ idprofession=" + idprofession + " ]";
    }
    
}
