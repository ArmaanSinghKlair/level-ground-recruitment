/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Kane Imler
 * @version 02/12/2021
 */
@Embeddable
public class CandidateSkillPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "candidateID")
    private int candidateID;
    @Basic(optional = false)
    @Column(name = "skillID")
    private int skillID;

    public CandidateSkillPK() {
    }

    public CandidateSkillPK(int candidateID, int skillID) {
        this.candidateID = candidateID;
        this.skillID = skillID;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) candidateID;
        hash += (int) skillID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidateSkillPK)) {
            return false;
        }
        CandidateSkillPK other = (CandidateSkillPK) object;
        if (this.candidateID != other.candidateID) {
            return false;
        }
        if (this.skillID != other.skillID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.CandidateSkillPK[ candidateID=" + candidateID + ", skillID=" + skillID + " ]";
    }
    
}
