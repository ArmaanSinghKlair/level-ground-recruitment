/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

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

/**
 *
 * @author kentp
 */
@Entity
@Table(name = "candidate_role")
@NamedQueries({
    @NamedQuery(name = "CandidateRole.findAll", query = "SELECT c FROM CandidateRole c"),
    @NamedQuery(name = "CandidateRole.findByCanroleID", query = "SELECT c FROM CandidateRole c WHERE c.canroleID = :canroleID")})
public class CandidateRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "can_roleID")
    private Integer canroleID;
    @JoinColumn(name = "candidateID", referencedColumnName = "candidateID")
    @ManyToOne(optional = false)
    private Candidate candidateID;
    @JoinColumn(name = "roleID", referencedColumnName = "roleID")
    @ManyToOne(optional = false)
    private Role roleID;

    public CandidateRole() {
    }

    public CandidateRole(Integer canroleID) {
        this.canroleID = canroleID;
    }

    public Integer getCanroleID() {
        return canroleID;
    }

    public void setCanroleID(Integer canroleID) {
        this.canroleID = canroleID;
    }

    public Candidate getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Candidate candidateID) {
        this.candidateID = candidateID;
    }

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (canroleID != null ? canroleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidateRole)) {
            return false;
        }
        CandidateRole other = (CandidateRole) object;
        if ((this.canroleID == null && other.canroleID != null) || (this.canroleID != null && !this.canroleID.equals(other.canroleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.CandidateRole[ canroleID=" + canroleID + " ]";
    }
    
}
