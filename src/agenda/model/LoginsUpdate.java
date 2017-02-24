/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NOFFABEL
 */
@Entity
@Table(name = "logins_update", catalog = "agenda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginsUpdate.findAll", query = "SELECT l FROM LoginsUpdate l"),
    @NamedQuery(name = "LoginsUpdate.findByLguId", query = "SELECT l FROM LoginsUpdate l WHERE l.lguId = :lguId"),
    @NamedQuery(name = "LoginsUpdate.findByLguOldLogin", query = "SELECT l FROM LoginsUpdate l WHERE l.lguOldLogin = :lguOldLogin"),
    @NamedQuery(name = "LoginsUpdate.findByLguOldPassword", query = "SELECT l FROM LoginsUpdate l WHERE l.lguOldPassword = :lguOldPassword"),
    @NamedQuery(name = "LoginsUpdate.findByLguNewLogin", query = "SELECT l FROM LoginsUpdate l WHERE l.lguNewLogin = :lguNewLogin"),
    @NamedQuery(name = "LoginsUpdate.findByLguNewPassword", query = "SELECT l FROM LoginsUpdate l WHERE l.lguNewPassword = :lguNewPassword"),
    @NamedQuery(name = "LoginsUpdate.findByLogUpdate", query = "SELECT l FROM LoginsUpdate l WHERE l.logUpdate = :logUpdate")})
public class LoginsUpdate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LGU_ID", nullable = false)
    private Integer lguId;
    @Basic(optional = false)
    @Column(name = "LGU_OLD_LOGIN", nullable = false, length = 30)
    private String lguOldLogin;
    @Basic(optional = false)
    @Column(name = "LGU_OLD_PASSWORD", nullable = false, length = 30)
    private String lguOldPassword;
    @Basic(optional = false)
    @Column(name = "LGU_NEW_LOGIN", nullable = false, length = 30)
    private String lguNewLogin;
    @Basic(optional = false)
    @Column(name = "LGU_NEW_PASSWORD", nullable = false, length = 30)
    private String lguNewPassword;
    @Basic(optional = false)
    @Column(name = "LOG_UPDATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date logUpdate;
    @JoinColumn(name = "LGU_LOG_ID", referencedColumnName = "LOG_ID", nullable = false)
    @ManyToOne(optional = false)
    private Logins lguLogId;

    public LoginsUpdate() {
    }

    public LoginsUpdate(Integer lguId) {
        this.lguId = lguId;
    }

    public LoginsUpdate(Integer lguId, String lguOldLogin, String lguOldPassword, String lguNewLogin, String lguNewPassword, Date logUpdate) {
        this.lguId = lguId;
        this.lguOldLogin = lguOldLogin;
        this.lguOldPassword = lguOldPassword;
        this.lguNewLogin = lguNewLogin;
        this.lguNewPassword = lguNewPassword;
        this.logUpdate = logUpdate;
    }

    public Integer getLguId() {
        return lguId;
    }

    public void setLguId(Integer lguId) {
        this.lguId = lguId;
    }

    public String getLguOldLogin() {
        return lguOldLogin;
    }

    public void setLguOldLogin(String lguOldLogin) {
        this.lguOldLogin = lguOldLogin;
    }

    public String getLguOldPassword() {
        return lguOldPassword;
    }

    public void setLguOldPassword(String lguOldPassword) {
        this.lguOldPassword = lguOldPassword;
    }

    public String getLguNewLogin() {
        return lguNewLogin;
    }

    public void setLguNewLogin(String lguNewLogin) {
        this.lguNewLogin = lguNewLogin;
    }

    public String getLguNewPassword() {
        return lguNewPassword;
    }

    public void setLguNewPassword(String lguNewPassword) {
        this.lguNewPassword = lguNewPassword;
    }

    public Date getLogUpdate() {
        return logUpdate;
    }

    public void setLogUpdate(Date logUpdate) {
        this.logUpdate = logUpdate;
    }

    public Logins getLguLogId() {
        return lguLogId;
    }

    public void setLguLogId(Logins lguLogId) {
        this.lguLogId = lguLogId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lguId != null ? lguId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginsUpdate)) {
            return false;
        }
        LoginsUpdate other = (LoginsUpdate) object;
        if ((this.lguId == null && other.lguId != null) || (this.lguId != null && !this.lguId.equals(other.lguId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agenda.model.LoginsUpdate[ lguId=" + lguId + " ]";
    }
    
}
