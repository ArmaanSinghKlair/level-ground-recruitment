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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 839645
 */
@Entity
@Table(name = "candidate_skill")
@XmlRootElement
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

    public CandidateSkill() {
    }

    public CandidateSkill(Integer canskillID) {
        this.canskillID = canskillID;
    }

    public Integer getCanskillID() {
        return canskillID;
    }

    public void setCanskillID(Integer canskillID) {
        this.canskillID = canskillID;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Candidate getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Candidate candidateID) {
        this.candidateID = candidateID;
    }

    public Skill getSkillID() {
        return skillID;
    }

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
