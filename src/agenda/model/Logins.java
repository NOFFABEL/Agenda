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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Logins.findAll", query = "SELECT l FROM Logins l"),
    @NamedQuery(name = "Logins.findByLogId", query = "SELECT l FROM Logins l WHERE l.logId = :logId"),
    @NamedQuery(name = "Logins.findByLogLogin", query = "SELECT l FROM Logins l WHERE l.logLogin = :logLogin"),
    @NamedQuery(name = "Logins.findByLogPassword", query = "SELECT l FROM Logins l WHERE l.logPassword = :logPassword"),
    @NamedQuery(name = "Logins.findByLogCreate", query = "SELECT l FROM Logins l WHERE l.logCreate = :logCreate"),
    @NamedQuery(name = "Logins.findByLogUses", query = "SELECT l FROM Logins l WHERE l.logUses = :logUses"),
    @NamedQuery(name = "Logins.findByLogActive", query = "SELECT l FROM Logins l WHERE l.logActive = :logActive")})
public class Logins implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOG_ID", nullable = false)
    private Integer logId;
    @Basic(optional = false)
    @Column(name = "LOG_LOGIN", nullable = false, length = 30)
    private String logLogin;
    @Basic(optional = false)
    @Column(name = "LOG_PASSWORD", nullable = false, length = 30)
    private String logPassword;
    @Basic(optional = false)
    @Column(name = "LOG_CREATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date logCreate;
    @Basic(optional = false)
    @Column(name = "LOG_USES", nullable = false)
    private boolean logUses;
    @Basic(optional = false)
    @Column(name = "LOG_ACTIVE", nullable = false)
    private boolean logActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lguLogId")
    private Collection<LoginsUpdate> loginsUpdateCollection;
    @JoinColumn(name = "LOG_USR_ID", referencedColumnName = "USR_ID", nullable = false)
    @ManyToOne(optional = false)
    private Users logUsrId;

    public Logins() {
    }

    public Logins(Integer logId) {
        this.logId = logId;
    }

    public Logins(Integer logId, String logLogin, String logPassword, Date logCreate, boolean logUses, boolean logActive) {
        this.logId = logId;
        this.logLogin = logLogin;
        this.logPassword = logPassword;
        this.logCreate = logCreate;
        this.logUses = logUses;
        this.logActive = logActive;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogLogin() {
        return logLogin;
    }

    public void setLogLogin(String logLogin) {
        this.logLogin = logLogin;
    }

    public String getLogPassword() {
        return logPassword;
    }

    public void setLogPassword(String logPassword) {
        this.logPassword = logPassword;
    }

    public Date getLogCreate() {
        return logCreate;
    }

    public void setLogCreate(Date logCreate) {
        this.logCreate = logCreate;
    }

    public boolean getLogUses() {
        return logUses;
    }

    public void setLogUses(boolean logUses) {
        this.logUses = logUses;
    }

    public boolean getLogActive() {
        return logActive;
    }

    public void setLogActive(boolean logActive) {
        this.logActive = logActive;
    }

    @XmlTransient
    public Collection<LoginsUpdate> getLoginsUpdateCollection() {
        return loginsUpdateCollection;
    }

    public void setLoginsUpdateCollection(Collection<LoginsUpdate> loginsUpdateCollection) {
        this.loginsUpdateCollection = loginsUpdateCollection;
    }

    public Users getLogUsrId() {
        return logUsrId;
    }

    public void setLogUsrId(Users logUsrId) {
        this.logUsrId = logUsrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logins)) {
            return false;
        }
        Logins other = (Logins) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agenda.model.Logins[ logId=" + logId + " ]";
    }
    
}
