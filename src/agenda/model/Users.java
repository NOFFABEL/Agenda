/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NOFFABEL
 */
@Entity
@Table(catalog = "agenda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUsrId", query = "SELECT u FROM Users u WHERE u.usrId = :usrId"),
    @NamedQuery(name = "Users.findByUsrName", query = "SELECT u FROM Users u WHERE u.usrName = :usrName"),
    @NamedQuery(name = "Users.findByUsrFirstname", query = "SELECT u FROM Users u WHERE u.usrFirstname = :usrFirstname"),
    @NamedQuery(name = "Users.findByUsrUsername", query = "SELECT u FROM Users u WHERE u.usrUsername = :usrUsername"),
    @NamedQuery(name = "Users.findByUsrEmail", query = "SELECT u FROM Users u WHERE u.usrEmail = :usrEmail"),
    @NamedQuery(name = "Users.findByUsrBirthdate", query = "SELECT u FROM Users u WHERE u.usrBirthdate = :usrBirthdate"),
    @NamedQuery(name = "Users.findByUsrCreateDate", query = "SELECT u FROM Users u WHERE u.usrCreateDate = :usrCreateDate"),
    @NamedQuery(name = "Users.findByUsrOnline", query = "SELECT u FROM Users u WHERE u.usrOnline = :usrOnline"),
    @NamedQuery(name = "Users.findByUsrActive", query = "SELECT u FROM Users u WHERE u.usrActive = :usrActive")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USR_ID", nullable = false)
    private Integer usrId;
    @Basic(optional = false)
    @Column(name = "USR_NAME", nullable = false, length = 50)
    private String usrName;
    @Column(name = "USR_FIRSTNAME", length = 50)
    private String usrFirstname;
    @Basic(optional = false)
    @Column(name = "USR_USERNAME", nullable = false, length = 100)
    private String usrUsername;
    @Basic(optional = false)
    @Column(name = "USR_EMAIL", nullable = false, length = 50)
    private String usrEmail;
    @Column(name = "USR_BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date usrBirthdate;
    @Basic(optional = false)
    @Column(name = "USR_CREATE_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrCreateDate;
    @Basic(optional = false)
    @Column(name = "USR_ONLINE", nullable = false)
    private boolean usrOnline;
    @Basic(optional = false)
    @Column(name = "USR_ACTIVE", nullable = false)
    private boolean usrActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pflUsrId")
    private Collection<Profil> profilCollection;
    @OneToMany(mappedBy = "ctcUsrId")
    private Collection<Contact> contactCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logUsrId")
    private Collection<Logins> loginsCollection;

    public Users() {
    }

    public Users(Integer usrId) {
        this.usrId = usrId;
    }

    public Users(Integer usrId, String usrName, String usrUsername, String usrEmail, Date usrCreateDate, boolean usrOnline, boolean usrActive) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.usrUsername = usrUsername;
        this.usrEmail = usrEmail;
        this.usrCreateDate = usrCreateDate;
        this.usrOnline = usrOnline;
        this.usrActive = usrActive;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrFirstname() {
        return usrFirstname;
    }

    public void setUsrFirstname(String usrFirstname) {
        this.usrFirstname = usrFirstname;
    }

    public String getUsrUsername() {
        return usrUsername;
    }

    public void setUsrUsername(String usrUsername) {
        this.usrUsername = usrUsername;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public Date getUsrBirthdate() {
        return usrBirthdate;
    }

    public void setUsrBirthdate(Date usrBirthdate) {
        this.usrBirthdate = usrBirthdate;
    }

    public Date getUsrCreateDate() {
        return usrCreateDate;
    }

    public void setUsrCreateDate(Date usrCreateDate) {
        this.usrCreateDate = usrCreateDate;
    }

    public boolean getUsrOnline() {
        return usrOnline;
    }

    public void setUsrOnline(boolean usrOnline) {
        this.usrOnline = usrOnline;
    }

    public boolean getUsrActive() {
        return usrActive;
    }

    public void setUsrActive(boolean usrActive) {
        this.usrActive = usrActive;
    }

    @XmlTransient
    public Collection<Profil> getProfilCollection() {
        return profilCollection;
    }

    public void setProfilCollection(Collection<Profil> profilCollection) {
        this.profilCollection = profilCollection;
    }

    @XmlTransient
    public Collection<Contact> getContactCollection() {
        return contactCollection;
    }

    public void setContactCollection(Collection<Contact> contactCollection) {
        this.contactCollection = contactCollection;
    }

    @XmlTransient
    public Collection<Logins> getLoginsCollection() {
        return loginsCollection;
    }

    public void setLoginsCollection(Collection<Logins> loginsCollection) {
        this.loginsCollection = loginsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agenda.model.Users[ usrId=" + usrId + " ]";
    }
    
}
