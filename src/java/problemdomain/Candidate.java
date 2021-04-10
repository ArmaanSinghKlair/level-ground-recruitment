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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 839645
 */
@Entity
@Table(name = "candidate")
@NamedQueries({
    @NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c"),
    @NamedQuery(name = "Candidate.findByCandidateID", query = "SELECT c FROM Candidate c WHERE c.candidateID = :candidateID"),
    @NamedQuery(name = "Candidate.findByCanUsername", query = "SELECT c FROM Candidate c WHERE c.canUsername = :canUsername"),
    @NamedQuery(name = "Candidate.findByCanPassword", query = "SELECT c FROM Candidate c WHERE c.canPassword = :canPassword"),
    @NamedQuery(name = "Candidate.findByCanfirstName", query = "SELECT c FROM Candidate c WHERE c.canfirstName = :canfirstName"),
    @NamedQuery(name = "Candidate.findByCanlastName", query = "SELECT c FROM Candidate c WHERE c.canlastName = :canlastName"),
    @NamedQuery(name = "Candidate.findByCanEmail", query = "SELECT c FROM Candidate c WHERE c.canEmail = :canEmail"),
    @NamedQuery(name = "Candidate.findByCanPhoneNo", query = "SELECT c FROM Candidate c WHERE c.canPhoneNo = :canPhoneNo"),
    @NamedQuery(name = "Candidate.findByPlaced", query = "SELECT c FROM Candidate c WHERE c.placed = :placed")})
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "candidateID")
    private Integer candidateID;
    @Basic(optional = false)
    @Column(name = "can_username")
    private String canUsername;
    @Basic(optional = false)
    @Column(name = "can_password")
    private String canPassword;
    @Basic(optional = false)
    @Column(name = "can_firstName")
    private String canfirstName;
    @Basic(optional = false)
    @Column(name = "can_lastName")
    private String canlastName;
    @Basic(optional = false)
    @Column(name = "can_email")
    private String canEmail;
    @Column(name = "can_phone_no")
    private String canPhoneNo;
    @Column(name = "placed")
    private Boolean placed;
    @JoinTable(name = "candidate_role", joinColumns = {
        @JoinColumn(name = "candidateID", referencedColumnName = "candidateID")}, inverseJoinColumns = {
        @JoinColumn(name = "roleID", referencedColumnName = "roleID")})
    @ManyToMany
    private List<Role> roleList;
    @JoinColumn(name = "advisorID", referencedColumnName = "advisorID")
    @ManyToOne
    private Advisor advisorID;
    @OneToMany(mappedBy = "candidateID")
    private List<Education> educationList;
    @OneToMany(mappedBy = "candidateID")
    private List<Application> applicationList;
    @OneToMany(mappedBy = "candidateID")
    private List<CandidateSkill> candidateSkillList;
    @OneToMany(mappedBy = "candidateID")
    private List<WorkHistory> workHistoryList;

    public Candidate() {
    }

    public Candidate(Integer candidateID) {
        this.candidateID = candidateID;
    }

    public Candidate(Integer candidateID, String canUsername, String canPassword, String canfirstName, String canlastName, String canEmail) {
        this.candidateID = candidateID;
        this.canUsername = canUsername;
        this.canPassword = canPassword;
        this.canfirstName = canfirstName;
        this.canlastName = canlastName;
        this.canEmail = canEmail;
    }

    public Integer getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Integer candidateID) {
        this.candidateID = candidateID;
    }

    public String getCanUsername() {
        return canUsername;
    }

    public void setCanUsername(String canUsername) {
        this.canUsername = canUsername;
    }

    public String getCanPassword() {
        return canPassword;
    }

    public void setCanPassword(String canPassword) {
        this.canPassword = canPassword;
    }

    public String getCanfirstName() {
        return canfirstName;
    }

    public void setCanfirstName(String canfirstName) {
        this.canfirstName = canfirstName;
    }

    public String getCanlastName() {
        return canlastName;
    }

    public void setCanlastName(String canlastName) {
        this.canlastName = canlastName;
    }

    public String getCanEmail() {
        return canEmail;
    }

    public void setCanEmail(String canEmail) {
        this.canEmail = canEmail;
    }

    public String getCanPhoneNo() {
        return canPhoneNo;
    }

    public void setCanPhoneNo(String canPhoneNo) {
        this.canPhoneNo = canPhoneNo;
    }

    public Boolean getPlaced() {
        return placed;
    }

    public void setPlaced(Boolean placed) {
        this.placed = placed;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Advisor getAdvisorID() {
        return advisorID;
    }

    public void setAdvisorID(Advisor advisorID) {
        this.advisorID = advisorID;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    public List<CandidateSkill> getCandidateSkillList() {
        return candidateSkillList;
    }

    public void setCandidateSkillList(List<CandidateSkill> candidateSkillList) {
        this.candidateSkillList = candidateSkillList;
    }

    public List<WorkHistory> getWorkHistoryList() {
        return workHistoryList;
    }

    public void setWorkHistoryList(List<WorkHistory> workHistoryList) {
        this.workHistoryList = workHistoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidateID != null ? candidateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        if ((this.candidateID == null && other.candidateID != null) || (this.candidateID != null && !this.candidateID.equals(other.candidateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.Candidate[ candidateID=" + candidateID + " ]";
    }
    
}
