/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author Kane Imler
 * @version 02/12/2021
 */
@Entity
@Table(name = "candidate_skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CandidateSkill.findAll", query = "SELECT c FROM CandidateSkill c"),
    @NamedQuery(name = "CandidateSkill.findByCandidateID", query = "SELECT c FROM CandidateSkill c WHERE c.candidateSkillPK.candidateID = :candidateID"),
    @NamedQuery(name = "CandidateSkill.findBySkillID", query = "SELECT c FROM CandidateSkill c WHERE c.candidateSkillPK.skillID = :skillID"),
    @NamedQuery(name = "CandidateSkill.findByAddedDate", query = "SELECT c FROM CandidateSkill c WHERE c.addedDate = :addedDate")})
public class CandidateSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CandidateSkillPK candidateSkillPK;
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @JoinColumn(name = "candidateID", referencedColumnName = "candidateID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Candidate candidate;
    @JoinColumn(name = "skillID", referencedColumnName = "skillID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Skill skill;

    public CandidateSkill() {
    }

    public CandidateSkill(CandidateSkillPK candidateSkillPK) {
        this.candidateSkillPK = candidateSkillPK;
    }

    public CandidateSkill(int candidateID, int skillID) {
        this.candidateSkillPK = new CandidateSkillPK(candidateID, skillID);
    }

    public CandidateSkillPK getCandidateSkillPK() {
        return candidateSkillPK;
    }

    public void setCandidateSkillPK(CandidateSkillPK candidateSkillPK) {
        this.candidateSkillPK = candidateSkillPK;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidateSkillPK != null ? candidateSkillPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidateSkill)) {
            return false;
        }
        CandidateSkill other = (CandidateSkill) object;
        if ((this.candidateSkillPK == null && other.candidateSkillPK != null) || (this.candidateSkillPK != null && !this.candidateSkillPK.equals(other.candidateSkillPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.CandidateSkill[ candidateSkillPK=" + candidateSkillPK + " ]";
    }
    
}
