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
@Table(catalog = "agenda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profil.findAll", query = "SELECT p FROM Profil p"),
    @NamedQuery(name = "Profil.findByPflId", query = "SELECT p FROM Profil p WHERE p.pflId = :pflId"),
    @NamedQuery(name = "Profil.findByPflCreateDate", query = "SELECT p FROM Profil p WHERE p.pflCreateDate = :pflCreateDate"),
    @NamedQuery(name = "Profil.findByPflType", query = "SELECT p FROM Profil p WHERE p.pflType = :pflType"),
    @NamedQuery(name = "Profil.findByPflName", query = "SELECT p FROM Profil p WHERE p.pflName = :pflName"),
    @NamedQuery(name = "Profil.findByPflExtention", query = "SELECT p FROM Profil p WHERE p.pflExtention = :pflExtention"),
    @NamedQuery(name = "Profil.findByPflPath", query = "SELECT p FROM Profil p WHERE p.pflPath = :pflPath"),
    @NamedQuery(name = "Profil.findByPflUses", query = "SELECT p FROM Profil p WHERE p.pflUses = :pflUses")})
public class Profil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PFL_ID", nullable = false)
    private Integer pflId;
    @Basic(optional = false)
    @Column(name = "PFL_CREATE_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date pflCreateDate;
    @Column(name = "PFL_TYPE", length = 10)
    private String pflType;
    @Basic(optional = false)
    @Column(name = "PFL_NAME", nullable = false, length = 70)
    private String pflName;
    @Basic(optional = false)
    @Column(name = "PFL_EXTENTION", nullable = false, length = 6)
    private String pflExtention;
    @Basic(optional = false)
    @Column(name = "PFL_PATH", nullable = false, length = 100)
    private String pflPath;
    @Column(name = "PFL_USES")
    private Boolean pflUses;
    @JoinColumn(name = "PFL_USR_ID", referencedColumnName = "USR_ID", nullable = false)
    @ManyToOne(optional = false)
    private Users pflUsrId;

    public Profil() {
    }

    public Profil(Integer pflId) {
        this.pflId = pflId;
    }

    public Profil(Integer pflId, Date pflCreateDate, String pflName, String pflExtention, String pflPath) {
        this.pflId = pflId;
        this.pflCreateDate = pflCreateDate;
        this.pflName = pflName;
        this.pflExtention = pflExtention;
        this.pflPath = pflPath;
    }

    public Integer getPflId() {
        return pflId;
    }

    public void setPflId(Integer pflId) {
        this.pflId = pflId;
    }

    public Date getPflCreateDate() {
        return pflCreateDate;
    }

    public void setPflCreateDate(Date pflCreateDate) {
        this.pflCreateDate = pflCreateDate;
    }

    public String getPflType() {
        return pflType;
    }

    public void setPflType(String pflType) {
        this.pflType = pflType;
    }

    public String getPflName() {
        return pflName;
    }

    public void setPflName(String pflName) {
        this.pflName = pflName;
    }

    public String getPflExtention() {
        return pflExtention;
    }

    public void setPflExtention(String pflExtention) {
        this.pflExtention = pflExtention;
    }

    public String getPflPath() {
        return pflPath;
    }

    public void setPflPath(String pflPath) {
        this.pflPath = pflPath;
    }

    public Boolean getPflUses() {
        return pflUses;
    }

    public void setPflUses(Boolean pflUses) {
        this.pflUses = pflUses;
    }

    public Users getPflUsrId() {
        return pflUsrId;
    }

    public void setPflUsrId(Users pflUsrId) {
        this.pflUsrId = pflUsrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pflId != null ? pflId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profil)) {
            return false;
        }
        Profil other = (Profil) object;
        if ((this.pflId == null && other.pflId != null) || (this.pflId != null && !this.pflId.equals(other.pflId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agenda.model.Profil[ pflId=" + pflId + " ]";
    }
    
}
