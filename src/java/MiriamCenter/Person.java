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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByIdPerson", query = "SELECT p FROM Person p WHERE p.idPerson = :idPerson")
    , @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender")
    , @NamedQuery(name = "Person.findByMobile", query = "SELECT p FROM Person p WHERE p.mobile = :mobile")
    , @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email")
    , @NamedQuery(name = "Person.findByUserName", query = "SELECT p FROM Person p WHERE p.userName = :userName")
    , @NamedQuery(name = "Person.findByPassword", query = "SELECT p FROM Person p WHERE p.password = :password")})
public class Person implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<Dependents> dependentsCollection;
    @OneToMany(mappedBy = "idPerson")
    private Collection<Death> deathCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Auxiliary auxiliary;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Technician technician;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Doctor doctor;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "idPerson")
    private String idPerson;
    @Size(max = 15)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 15)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 1)
    @Column(name = "gender")
    private String gender;
    @Size(max = 11)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    @Size(max = 15)
    @Column(name = "userName")
    private String userName;
    @Size(max = 30)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "idProfession", referencedColumnName = "idprofession")
    @ManyToOne
    private Profession idProfession;
    @JoinColumn(name = "streetId", referencedColumnName = "idstreet")
    @ManyToOne
    private Street streetId;
    @OneToMany(mappedBy = "idPerson")
    private Collection<Subscription> subscriptionCollection;

    public Person() {
    }

    public Person(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profession getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(Profession idProfession) {
        this.idProfession = idProfession;
    }

    public Street getStreetId() {
        return streetId;
    }

    public void setStreetId(Street streetId) {
        this.streetId = streetId;
    }

    @XmlTransient
    public Collection<Subscription> getSubscriptionCollection() {
        return subscriptionCollection;
    }

    public void setSubscriptionCollection(Collection<Subscription> subscriptionCollection) {
        this.subscriptionCollection = subscriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiriamCenter.Person[ idPerson=" + idPerson + " ]";
    }

    @XmlTransient
    public Collection<Dependents> getDependentsCollection() {
        return dependentsCollection;
    }

    public void setDependentsCollection(Collection<Dependents> dependentsCollection) {
        this.dependentsCollection = dependentsCollection;
    }

    @XmlTransient
    public Collection<Death> getDeathCollection() {
        return deathCollection;
    }

    public void setDeathCollection(Collection<Death> deathCollection) {
        this.deathCollection = deathCollection;
    }

    public Auxiliary getAuxiliary() {
        return auxiliary;
    }

    public void setAuxiliary(Auxiliary auxiliary) {
        this.auxiliary = auxiliary;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
}
