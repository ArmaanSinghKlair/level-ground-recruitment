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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Candidate entity class for the candidate table in our database. Contains
 * method for both retrieving and setting values for a Candidate.
 *
 * @author kentp
 * @version 1.0
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
    @Lob
    @Column(name = "can_description")
    private String canDescription;
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
    private List<CandidateRole> candidateRoleList;
    @OneToMany(mappedBy = "candidateID")
    private List<WorkHistory> workHistoryList;

    /**
     * Default no-args constructor
     */
    public Candidate() {
    }

    /**
     * Arguments constructor that takes in the id for the Candidate.
     *
     * @param candidateID ID of the Candidate
     */
    public Candidate(Integer candidateID) {
        this.candidateID = candidateID;
    }

    /**
     * Arguments constructor that takes in various attributes for a Candidate.
     *
     * @param candidateID ID of the Candidate
     * @param canUsername username ID of the Candidate
     * @param canPassword password of the Candidate
     * @param canfirstName first name of the Candidate
     * @param canlastName last name of the Candidate
     * @param canEmail email of the Candidate
     */
    public Candidate(Integer candidateID, String canUsername, String canPassword, String canfirstName, String canlastName, String canEmail) {
        this.candidateID = candidateID;
        this.canUsername = canUsername;
        this.canPassword = canPassword;
        this.canfirstName = canfirstName;
        this.canlastName = canlastName;
        this.canEmail = canEmail;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing the Candidate id
     */
    public Integer getCandidateID() {
        return candidateID;
    }

    /**
     * Mutator method.
     *
     * @param candidateID New Candidate id
     */
    public void setCandidateID(Integer candidateID) {
        this.candidateID = candidateID;
    }

    /**
     * Accessor method.
     *
     * @return String representing Candidate username
     */
    public String getCanUsername() {
        return canUsername;
    }

    /**
     * Mutator method.
     *
     * @param canUsername New Candidate username
     */
    public void setCanUsername(String canUsername) {
        this.canUsername = canUsername;
    }

    /**
     * Accessor method.
     *
     * @return String representing Candidate password
     */
    public String getCanPassword() {
        return canPassword;
    }

    /**
     * Mutator method.
     *
     * @param canPassword New Candidate password
     */
    public void setCanPassword(String canPassword) {
        this.canPassword = canPassword;
    }

    /**
     * Accessor method.
     *
     * @return String representing the Candidate description
     */
    public String getCanDescription() {
        return canDescription;
    }

    /**
     * Mutator method.
     *
     * @param canDescription New Candidate description
     */
    public void setCanDescription(String canDescription) {
        this.canDescription = canDescription;
    }

    /**
     * Accessor method.
     *
     * @return String representing Candidate first name
     */
    public String getCanfirstName() {
        return canfirstName;
    }

    /**
     * Mutator method.
     *
     * @param canfirstName New Candidate first name
     */
    public void setCanfirstName(String canfirstName) {
        this.canfirstName = canfirstName;
    }

    /**
     * Accessor method.
     *
     * @return String representing Candidate last name
     */
    public String getCanlastName() {
        return canlastName;
    }

    /**
     * Mutator method.
     *
     * @param canlastName New Candidate last name
     */
    public void setCanlastName(String canlastName) {
        this.canlastName = canlastName;
    }

    /**
     * Accessor method.
     *
     * @return String representing Candidate email
     */
    public String getCanEmail() {
        return canEmail;
    }

    /**
     * Mutator method.
     *
     * @param canEmail New Candidate email
     */
    public void setCanEmail(String canEmail) {
        this.canEmail = canEmail;
    }

    /**
     * Accessor method.
     *
     * @return String representing Candidate phone
     */
    public String getCanPhoneNo() {
        return canPhoneNo;
    }

    /**
     * Mutator method.
     *
     * @param canPhoneNo New Candidate phone
     */
    public void setCanPhoneNo(String canPhoneNo) {
        this.canPhoneNo = canPhoneNo;
    }

    /**
     * Accessor method
     *
     * @return boolean representing if the Candidate is placed or not
     */
    public Boolean getPlaced() {
        return placed;
    }

    /**
     * Mutator method.
     *
     * @param placed New Candidate placed value
     */
    public void setPlaced(Boolean placed) {
        this.placed = placed;
    }

    /**
     * Accessor method.
     *
     * @return List of roles associated with this Candidate
     */
    public List<Role> getRoleList() {
        return roleList;
    }

    /**
     * Mutator method.
     *
     * @param roleList New Candidate role list
     */
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    /**
     * Accessor method.
     *
     * @return Advisor object associated with this Candidate
     */
    public Advisor getAdvisorID() {
        return advisorID;
    }

    /**
     * Mutator method.
     *
     * @param advisorID New Candidate Advisor
     */
    public void setAdvisorID(Advisor advisorID) {
        this.advisorID = advisorID;
    }

    /**
     * Accessor method.
     *
     * @return List of educations associated with this Candidate
     */
    public List<Education> getEducationList() {
        return educationList;
    }

    /**
     * Mutator method.
     *
     * @param educationList New Candidate education list
     */
    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    /**
     * Accessor method.
     *
     * @return List of applications associated with this Candidate
     */
    public List<Application> getApplicationList() {
        return applicationList;
    }

    /**
     * Mutator method.
     *
     * @param applicationList New Candidate application list
     */
    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    /**
     * Accessor method.
     *
     * @return List of candidate skills associated with this Candidate
     */
    public List<CandidateSkill> getCandidateSkillList() {
        return candidateSkillList;
    }

    /**
     * Mutator method.
     *
     * @param candidateSkillList New Candidate candidate skill list
     */
    public void setCandidateSkillList(List<CandidateSkill> candidateSkillList) {
        this.candidateSkillList = candidateSkillList;
    }

    /**
     * Accessor method.
     *
     * @return List of candidate roles associated with this Candidate
     */
    public List<CandidateRole> getCandidateRoleList() {
        return candidateRoleList;
    }

    /**
     * Mutator method.
     *
     * @param candidateRoleList New Candidate candidate role list
     */
    public void setCandidateRoleList(List<CandidateRole> candidateRoleList) {
        this.candidateRoleList = candidateRoleList;
    }

    /**
     * Accessor method.
     *
     * @return List of work history associated with this Candidate
     */
    public List<WorkHistory> getWorkHistoryList() {
        return workHistoryList;
    }

    /**
     * Mutator method.
     *
     * @param workHistoryList New Candidate work history list
     */
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
