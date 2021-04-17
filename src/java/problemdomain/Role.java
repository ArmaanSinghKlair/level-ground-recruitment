/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role entity class for the role table in our database. Contains method for
 * both retrieving and setting values for a Role.
 *
 * @author 839645
 * @version 1.0
 */
@Entity
@Table(name = "role")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRoleID", query = "SELECT r FROM Role r WHERE r.roleID = :roleID"),
    @NamedQuery(name = "Role.findByDescription", query = "SELECT r FROM Role r WHERE r.description = :description")})
public class Role implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID")
    private Collection<CandidateRole> candidateRoleCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "roleID")
    private Integer roleID;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "roleList")
    private List<Candidate> candidateList;

    /**
     * Default no-args constructor
     */
    public Role() {
    }

    /**
     * Arguments constructor that takes in the id for the Role.
     *
     * @param roleID ID of the Role
     */
    public Role(Integer roleID) {
        this.roleID = roleID;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing the Role id
     */
    public Integer getRoleID() {
        return roleID;
    }

    /**
     * Mutator method.
     *
     * @param roleID New Role id
     */
    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    /**
     * Accessor method.
     *
     * @return String representing Role description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mutator method.
     *
     * @param description New Role description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accessor method.
     *
     * @return List of candidates associated with this Role
     */
    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    /**
     * Mutator method.
     *
     * @param candidateList New Role candidate list
     */
    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.Role[ roleID=" + roleID + " ]";
    }

    public Collection<CandidateRole> getCandidateRoleCollection() {
        return candidateRoleCollection;
    }

    public void setCandidateRoleCollection(Collection<CandidateRole> candidateRoleCollection) {
        this.candidateRoleCollection = candidateRoleCollection;
    }

}
