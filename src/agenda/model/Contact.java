/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NOFFABEL
 */
@Entity
@Table(catalog = "agenda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByCtcId", query = "SELECT c FROM Contact c WHERE c.ctcId = :ctcId"),
    @NamedQuery(name = "Contact.findByCtcFirstname", query = "SELECT c FROM Contact c WHERE c.ctcFirstname = :ctcFirstname"),
    @NamedQuery(name = "Contact.findByCtcName", query = "SELECT c FROM Contact c WHERE c.ctcName = :ctcName"),
    @NamedQuery(name = "Contact.findByCtcEmail", query = "SELECT c FROM Contact c WHERE c.ctcEmail = :ctcEmail"),
    @NamedQuery(name = "Contact.findByCtcPhoneCode", query = "SELECT c FROM Contact c WHERE c.ctcPhoneCode = :ctcPhoneCode"),
    @NamedQuery(name = "Contact.findByCtcMobilPhone", query = "SELECT c FROM Contact c WHERE c.ctcMobilPhone = :ctcMobilPhone"),
    @NamedQuery(name = "Contact.findByCtcOfficeNumber", query = "SELECT c FROM Contact c WHERE c.ctcOfficeNumber = :ctcOfficeNumber"),
    @NamedQuery(name = "Contact.findByCtcHomeNumber", query = "SELECT c FROM Contact c WHERE c.ctcHomeNumber = :ctcHomeNumber"),
    @NamedQuery(name = "Contact.findByCtcAddress", query = "SELECT c FROM Contact c WHERE c.ctcAddress = :ctcAddress"),
    @NamedQuery(name = "Contact.findByCtcPicture", query = "SELECT c FROM Contact c WHERE c.ctcPicture = :ctcPicture"),
    @NamedQuery(name = "Contact.findByCtcPicturePath", query = "SELECT c FROM Contact c WHERE c.ctcPicturePath = :ctcPicturePath")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CTC_ID", nullable = false)
    private Integer ctcId;
    @Basic(optional = false)
    @Column(name = "CTC_FIRSTNAME", nullable = false, length = 50)
    private String ctcFirstname;
    @Column(name = "CTC_NAME", length = 50)
    private String ctcName;
    @Column(name = "CTC_EMAIL", length = 50)
    private String ctcEmail;
    @Column(name = "CTC_PHONE_CODE", length = 5)
    private String ctcPhoneCode;
    @Basic(optional = false)
    @Column(name = "CTC_MOBIL_PHONE", nullable = false, length = 20)
    private String ctcMobilPhone;
    @Column(name = "CTC_OFFICE_NUMBER", length = 20)
    private String ctcOfficeNumber;
    @Column(name = "CTC_HOME_NUMBER", length = 20)
    private String ctcHomeNumber;
    @Column(name = "CTC_ADDRESS", length = 100)
    private String ctcAddress;
    @Column(name = "CTC_PICTURE", length = 50)
    private String ctcPicture;
    @Column(name = "CTC_PICTURE_PATH", length = 50)
    private String ctcPicturePath;
    @JoinColumn(name = "CTC_GRP_ID", referencedColumnName = "GRP_ID")
    @ManyToOne
    private ContactGroup ctcGrpId;
    @JoinColumn(name = "CTC_USR_ID", referencedColumnName = "USR_ID")
    @ManyToOne
    private Users ctcUsrId;

    public Contact() {
    }

    public Contact(Integer ctcId) {
        this.ctcId = ctcId;
    }

    public Contact(Integer ctcId, String ctcFirstname, String ctcMobilPhone) {
        this.ctcId = ctcId;
        this.ctcFirstname = ctcFirstname;
        this.ctcMobilPhone = ctcMobilPhone;
    }

    public Integer getCtcId() {
        return ctcId;
    }

    public void setCtcId(Integer ctcId) {
        this.ctcId = ctcId;
    }

    public String getCtcFirstname() {
        return ctcFirstname;
    }

    public void setCtcFirstname(String ctcFirstname) {
        this.ctcFirstname = ctcFirstname;
    }

    public String getCtcName() {
        return ctcName;
    }

    public void setCtcName(String ctcName) {
        this.ctcName = ctcName;
    }

    public String getCtcEmail() {
        return ctcEmail;
    }

    public void setCtcEmail(String ctcEmail) {
        this.ctcEmail = ctcEmail;
    }

    public String getCtcPhoneCode() {
        return ctcPhoneCode;
    }

    public void setCtcPhoneCode(String ctcPhoneCode) {
        this.ctcPhoneCode = ctcPhoneCode;
    }

    public String getCtcMobilPhone() {
        return ctcMobilPhone;
    }

    public void setCtcMobilPhone(String ctcMobilPhone) {
        this.ctcMobilPhone = ctcMobilPhone;
    }

    public String getCtcOfficeNumber() {
        return ctcOfficeNumber;
    }

    public void setCtcOfficeNumber(String ctcOfficeNumber) {
        this.ctcOfficeNumber = ctcOfficeNumber;
    }

    public String getCtcHomeNumber() {
        return ctcHomeNumber;
    }

    public void setCtcHomeNumber(String ctcHomeNumber) {
        this.ctcHomeNumber = ctcHomeNumber;
    }

    public String getCtcAddress() {
        return ctcAddress;
    }

    public void setCtcAddress(String ctcAddress) {
        this.ctcAddress = ctcAddress;
    }

    public String getCtcPicture() {
        return ctcPicture;
    }

    public void setCtcPicture(String ctcPicture) {
        this.ctcPicture = ctcPicture;
    }

    public String getCtcPicturePath() {
        return ctcPicturePath;
    }

    public void setCtcPicturePath(String ctcPicturePath) {
        this.ctcPicturePath = ctcPicturePath;
    }

    public ContactGroup getCtcGrpId() {
        return ctcGrpId;
    }

    public void setCtcGrpId(ContactGroup ctcGrpId) {
        this.ctcGrpId = ctcGrpId;
    }

    public Users getCtcUsrId() {
        return ctcUsrId;
    }

    public void setCtcUsrId(Users ctcUsrId) {
        this.ctcUsrId = ctcUsrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctcId != null ? ctcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.ctcId == null && other.ctcId != null) || (this.ctcId != null && !this.ctcId.equals(other.ctcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agenda.model.Contact[ ctcId=" + ctcId + " ]";
    }
    
}
