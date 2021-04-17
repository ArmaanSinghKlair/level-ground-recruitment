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

/**
 * Skill entity class for the skill table in our database. Contains method for
 * both retrieving and setting values for a Skill.
 *
 * @author 839645
 * @version 1.0
 */
@Entity
@Table(name = "skill")
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

    /**
     * Default no-args constructor.
     */
    public Skill() {
    }

    /**
     * Arguments constructor that takes in the id for the Skill.
     *
     * @param skillID
     */
    public Skill(Integer skillID) {
        this.skillID = skillID;
    }

    /**
     * Arguments constructor that takes in the id and description for the Skill.
     *
     * @param skillID ID of the Skill
     * @param description description of the Skill
     */
    public Skill(Integer skillID, String description) {
        this.skillID = skillID;
        this.description = description;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing the Skill id
     */
    public Integer getSkillID() {
        return skillID;
    }

    /**
     * Mutator method.
     *
     * @param skillID New Skill id
     */
    public void setSkillID(Integer skillID) {
        this.skillID = skillID;
    }

    /**
     * Accessor method.
     *
     * @return String representing the Skill description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mutator method.
     *
     * @param description New Skill description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accessor method.
     *
     * @return List of candidate skills associated with this Skill
     */
    public List<CandidateSkill> getCandidateSkillList() {
        return candidateSkillList;
    }

    /**
     * Mutator method.
     *
     * @param candidateSkillList New Skill candidate skill list
     */
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
