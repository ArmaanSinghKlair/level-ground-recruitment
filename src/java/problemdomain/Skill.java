/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 839645
 */
@Entity
@Table(name = "skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s"),
    @NamedQuery(name = "Skill.findBySkillID", query = "SELECT s FROM Skill s WHERE s.skillID = :skillID"),
    @NamedQuery(name = "Skill.findByDescription", query = "SELECT s FROM Skill s WHERE s.description = :description")})
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "skillID")
    private Integer skillID;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "skillID")
    private List<CandidateSkill> candidateSkillList;

    public Skill() {
    }

    public Skill(Integer skillID) {
        this.skillID = skillID;
    }

    public Skill(Integer skillID, String description) {
        this.skillID = skillID;
        this.description = description;
    }

    public Integer getSkillID() {
        return skillID;
    }

    public void setSkillID(Integer skillID) {
        this.skillID = skillID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<CandidateSkill> getCandidateSkillList() {
        return candidateSkillList;
    }

    public void setCandidateSkillList(List<CandidateSkill> candidateSkillList) {
        this.candidateSkillList = candidateSkillList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillID != null ? skillID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.skillID == null && other.skillID != null) || (this.skillID != null && !this.skillID.equals(other.skillID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.Skill[ skillID=" + skillID + " ]";
    }
    
}
