/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NOFFABEL
 */
@Entity
@Table(name = "contact_group", catalog = "agenda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactGroup.findAll", query = "SELECT c FROM ContactGroup c"),
    @NamedQuery(name = "ContactGroup.findByGrpId", query = "SELECT c FROM ContactGroup c WHERE c.grpId = :grpId"),
    @NamedQuery(name = "ContactGroup.findByGrpName", query = "SELECT c FROM ContactGroup c WHERE c.grpName = :grpName"),
    @NamedQuery(name = "ContactGroup.findByGrpMaxMember", query = "SELECT c FROM ContactGroup c WHERE c.grpMaxMember = :grpMaxMember"),
    @NamedQuery(name = "ContactGroup.findByGrpCountMember", query = "SELECT c FROM ContactGroup c WHERE c.grpCountMember = :grpCountMember")})
public class ContactGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GRP_ID", nullable = false)
    private Integer grpId;
    @Column(name = "GRP_NAME", length = 50)
    private String grpName;
    @Basic(optional = false)
    @Column(name = "GRP_MAX_MEMBER", nullable = false)
    private int grpMaxMember;
    @Basic(optional = false)
    @Column(name = "GRP_COUNT_MEMBER", nullable = false)
    private int grpCountMember;
    @OneToMany(mappedBy = "ctcGrpId")
    private Collection<Contact> contactCollection;

    public ContactGroup() {
    }

    public ContactGroup(Integer grpId) {
        this.grpId = grpId;
    }

    public ContactGroup(Integer grpId, int grpMaxMember, int grpCountMember) {
        this.grpId = grpId;
        this.grpMaxMember = grpMaxMember;
        this.grpCountMember = grpCountMember;
    }

    public Integer getGrpId() {
        return grpId;
    }

    public void setGrpId(Integer grpId) {
        this.grpId = grpId;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public int getGrpMaxMember() {
        return grpMaxMember;
    }

    public void setGrpMaxMember(int grpMaxMember) {
        this.grpMaxMember = grpMaxMember;
    }

    public int getGrpCountMember() {
        return grpCountMember;
    }

    public void setGrpCountMember(int grpCountMember) {
        this.grpCountMember = grpCountMember;
    }

    @XmlTransient
    public Collection<Contact> getContactCollection() {
        return contactCollection;
    }

    public void setContactCollection(Collection<Contact> contactCollection) {
        this.contactCollection = contactCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grpId != null ? grpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactGroup)) {
            return false;
        }
        ContactGroup other = (ContactGroup) object;
        if ((this.grpId == null && other.grpId != null) || (this.grpId != null && !this.grpId.equals(other.grpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agenda.model.ContactGroup[ grpId=" + grpId + " ]";
    }
    
}
