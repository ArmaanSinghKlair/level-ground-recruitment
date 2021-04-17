/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

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

/**
 * CandidateSkill entity class for the candidate_skill table in our database.
 * Contains method for both retrieving and setting values for a CandidateSkill.
 *
 * @author 839645
 * @version 1.0
 */
@Entity
@Table(name = "candidate_skill")
@NamedQueries({
    @NamedQuery(name = "CandidateSkill.findAll", query = "SELECT c FROM CandidateSkill c"),
    @NamedQuery(name = "CandidateSkill.findByCanskillID", query = "SELECT c FROM CandidateSkill c WHERE c.canskillID = :canskillID"),
    @NamedQuery(name = "CandidateSkill.findByAddedDate", query = "SELECT c FROM CandidateSkill c WHERE c.addedDate = :addedDate")})
public class CandidateSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "can_skillID")
    private Integer canskillID;
    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    @JoinColumn(name = "candidateID", referencedColumnName = "candidateID")
    @ManyToOne
    private Candidate candidateID;
    @JoinColumn(name = "skillID", referencedColumnName = "skillID")
    @ManyToOne
    private Skill skillID;

    /**
     * Default no-args constructor.
     */
    public CandidateSkill() {
    }

    /**
     * Arguments constructor that takes in the id for the CandidateSKill.
     *
     * @param canskillID ID of the CandidateSkill
     */
    public CandidateSkill(Integer canskillID) {
        this.canskillID = canskillID;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing CandidateSkill id
     */
    public Integer getCanskillID() {
        return canskillID;
    }

    /**
     * Mutator method.
     *
     * @param canskillID New CandidateSkill id
     */
    public void setCanskillID(Integer canskillID) {
        this.canskillID = canskillID;
    }

    /**
     * Accessor method.
     *
     * @return Date object representing the added date
     */
    public Date getAddedDate() {
        return addedDate;
    }

    /**
     * Mutator method.
     *
     * @param addedDate New CandidateSkill date
     */
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    /**
     * Accessor method.
     *
     * @return Candidate object representing the candidate associated with this
     * CandidateSkill
     */
    public Candidate getCandidateID() {
        return candidateID;
    }

    /**
     * Mutator method.
     *
     * @param candidateID New CandidateSkill candidate
     */
    public void setCandidateID(Candidate candidateID) {
        this.candidateID = candidateID;
    }

    /**
     * Accessor method.
     *
     * @return Skill object representing the skill associated with this
     * CandidateSkill
     */
    public Skill getSkillID() {
        return skillID;
    }

    /**
     * Mutator method.
     *
     * @param skillID New CandidateSkill skill
     */
    public void setSkillID(Skill skillID) {
        this.skillID = skillID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (canskillID != null ? canskillID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidateSkill)) {
            return false;
        }
        CandidateSkill other = (CandidateSkill) object;
        if ((this.canskillID == null && other.canskillID != null) || (this.canskillID != null && !this.canskillID.equals(other.canskillID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.CandidateSkill[ canskillID=" + canskillID + " ]";
    }

}
