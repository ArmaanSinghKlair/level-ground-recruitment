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
 * CandidateRole entity class for the candidate_role table in our database.
 * Contains method for both retrieving and setting values for a CandidateRole.
 *
 * @author kentp
 * @version 1.0
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

    /**
     * Default no-args constructor.
     */
    public CandidateRole() {
    }

    /**
     * Arguments constructor that takes in the id for the CandidateRole.
     *
     * @param canroleID ID of the CandidateRole
     */
    public CandidateRole(Integer canroleID) {
        this.canroleID = canroleID;
    }

    /**
     * Accesor method.
     *
     * @return Integer representing Candidate Role id
     */
    public Integer getCanroleID() {
        return canroleID;
    }

    /**
     * Mutator method.
     *
     * @param canroleID New CandidateRole id
     */
    public void setCanroleID(Integer canroleID) {
        this.canroleID = canroleID;
    }

    /**
     * Accesor method.
     *
     * @return Candidate object representing the candidate associated with this
     * CandidateRole
     */
    public Candidate getCandidateID() {
        return candidateID;
    }

    /**
     * Mutator method.
     *
     * @param candidateID New CandidateRole candidate
     */
    public void setCandidateID(Candidate candidateID) {
        this.candidateID = candidateID;
    }

    /**
     * Accesor method.
     *
     * @return Role object representing the role associated with this
     * CandidateRole
     */
    public Role getRoleID() {
        return roleID;
    }

    /**
     * Mutator method.
     *
     * @param roleID New CandidateRole role
     */
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
