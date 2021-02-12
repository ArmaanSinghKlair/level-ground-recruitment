/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kane Imler
 * @version 02/12/2021
 */
@Entity
@Table(name = "candidate")
@XmlRootElement
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
    @JoinTable(name = "application", joinColumns = {
        @JoinColumn(name = "candidateID", referencedColumnName = "candidateID")}, inverseJoinColumns = {
        @JoinColumn(name = "job_postingID", referencedColumnName = "job_postingID")})
    @ManyToMany
    private Collection<JobPosting> jobPostingCollection;
    @JoinTable(name = "candidate_role", joinColumns = {
        @JoinColumn(name = "candidateID", referencedColumnName = "candidateID")}, inverseJoinColumns = {
        @JoinColumn(name = "roleID", referencedColumnName = "roleID")})
    @ManyToMany
    private Collection<Role> roleCollection;
    @JoinColumn(name = "advisorID", referencedColumnName = "advisorID")
    @ManyToOne
    private Advisor advisorID;
    @OneToMany(mappedBy = "candidateID")
    private Collection<Education> educationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidate")
    private Collection<CandidateSkill> candidateSkillCollection;
    @OneToMany(mappedBy = "candidateID")
    private Collection<WorkHistory> workHistoryCollection;

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

    @XmlTransient
    public Collection<JobPosting> getJobPostingCollection() {
        return jobPostingCollection;
    }

    public void setJobPostingCollection(Collection<JobPosting> jobPostingCollection) {
        this.jobPostingCollection = jobPostingCollection;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    public Advisor getAdvisorID() {
        return advisorID;
    }

    public void setAdvisorID(Advisor advisorID) {
        this.advisorID = advisorID;
    }

    @XmlTransient
    public Collection<Education> getEducationCollection() {
        return educationCollection;
    }

    public void setEducationCollection(Collection<Education> educationCollection) {
        this.educationCollection = educationCollection;
    }

    @XmlTransient
    public Collection<CandidateSkill> getCandidateSkillCollection() {
        return candidateSkillCollection;
    }

    public void setCandidateSkillCollection(Collection<CandidateSkill> candidateSkillCollection) {
        this.candidateSkillCollection = candidateSkillCollection;
    }

    @XmlTransient
    public Collection<WorkHistory> getWorkHistoryCollection() {
        return workHistoryCollection;
    }

    public void setWorkHistoryCollection(Collection<WorkHistory> workHistoryCollection) {
        this.workHistoryCollection = workHistoryCollection;
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
