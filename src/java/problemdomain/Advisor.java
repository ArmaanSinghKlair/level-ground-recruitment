/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Advisor entity class for the advisor table in our database. Contains method
 * for both retrieving and setting values for an Advisor.
 *
 * @author 839645
 * @version 1.0
 */
@Entity
@Table(name = "advisor")
@NamedQueries({
    @NamedQuery(name = "Advisor.findAll", query = "SELECT a FROM Advisor a"),
    @NamedQuery(name = "Advisor.findByAdvisorID", query = "SELECT a FROM Advisor a WHERE a.advisorID = :advisorID"),
    @NamedQuery(name = "Advisor.findByAdvisorUsername", query = "SELECT a FROM Advisor a WHERE a.advisorUsername = :advisorUsername"),
    @NamedQuery(name = "Advisor.findByAdvisorPassword", query = "SELECT a FROM Advisor a WHERE a.advisorPassword = :advisorPassword"),
    @NamedQuery(name = "Advisor.findByAdvisorfirstName", query = "SELECT a FROM Advisor a WHERE a.advisorfirstName = :advisorfirstName"),
    @NamedQuery(name = "Advisor.findByAdvisorlastName", query = "SELECT a FROM Advisor a WHERE a.advisorlastName = :advisorlastName"),
    @NamedQuery(name = "Advisor.findByAdvisorEmail", query = "SELECT a FROM Advisor a WHERE a.advisorEmail = :advisorEmail")})
public class Advisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "advisorID")
    private Integer advisorID;
    @Basic(optional = false)
    @Column(name = "advisor_username")
    private String advisorUsername;
    @Basic(optional = false)
    @Column(name = "advisor_password")
    private String advisorPassword;
    @Basic(optional = false)
    @Column(name = "advisor_firstName")
    private String advisorfirstName;
    @Basic(optional = false)
    @Column(name = "advisor_lastName")
    private String advisorlastName;
    @Basic(optional = false)
    @Column(name = "advisor_Email")
    private String advisorEmail;
    @OneToMany(mappedBy = "advisorID")
    private List<Candidate> candidateList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advisorID")
    private List<Log> logList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advisorID")
    private List<JobPosting> jobPostingList;

    /**
     * Default no-args constructor.
     */
    public Advisor() {
    }

    /**
     * Argument constructor that takes in the id for the Advisor.
     *
     * @param advisorID ID of the Advisor
     */
    public Advisor(Integer advisorID) {
        this.advisorID = advisorID;
    }

    /**
     * Argument constructor that takes in the various attributes for an Advisor.
     *
     * @param advisorID ID of the Advisor
     * @param advisorUsername username of the Advisor
     * @param advisorPassword password of the Advisor
     * @param advisorfirstName first name of the Advisor
     * @param advisorlastName last name of the Advisor
     * @param advisorEmail email of the Advisor
     */
    public Advisor(Integer advisorID, String advisorUsername, String advisorPassword, String advisorfirstName, String advisorlastName, String advisorEmail) {
        this.advisorID = advisorID;
        this.advisorUsername = advisorUsername;
        this.advisorPassword = advisorPassword;
        this.advisorfirstName = advisorfirstName;
        this.advisorlastName = advisorlastName;
        this.advisorEmail = advisorEmail;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing Advisor id
     */
    public Integer getAdvisorID() {
        return advisorID;
    }

    /**
     * Mutator method.
     *
     * @param advisorID New Advisor ID
     */
    public void setAdvisorID(Integer advisorID) {
        this.advisorID = advisorID;
    }

    /**
     * Accessor method.
     *
     * @return String representing Advisor username
     */
    public String getAdvisorUsername() {
        return advisorUsername;
    }

    /**
     * Mutator method.
     *
     * @param advisorUsername New Advisor username
     */
    public void setAdvisorUsername(String advisorUsername) {
        this.advisorUsername = advisorUsername;
    }

    /**
     * Accessor method.
     *
     * @return String representing Advisor password
     */
    public String getAdvisorPassword() {
        return advisorPassword;
    }

    /**
     * Mutator method.
     *
     * @param advisorPassword New Advisor password
     */
    public void setAdvisorPassword(String advisorPassword) {
        this.advisorPassword = advisorPassword;
    }

    /**
     * Accessor method.
     *
     * @return String representing Advisor first name
     */
    public String getAdvisorfirstName() {
        return advisorfirstName;
    }

    /**
     * Mutator method.
     *
     * @param advisorfirstName New Advisor first name
     */
    public void setAdvisorfirstName(String advisorfirstName) {
        this.advisorfirstName = advisorfirstName;
    }

    /**
     * Accessor method.
     *
     * @return String representing Advisor last name
     */
    public String getAdvisorlastName() {
        return advisorlastName;
    }

    /**
     * Mutator method.
     *
     * @param advisorlastName New Advisor last name
     */
    public void setAdvisorlastName(String advisorlastName) {
        this.advisorlastName = advisorlastName;
    }

    /**
     * Acessor method.
     *
     * @return String representing Advisor email
     */
    public String getAdvisorEmail() {
        return advisorEmail;
    }

    /**
     * Mutator method.
     *
     * @param advisorEmail New Advisor email
     */
    public void setAdvisorEmail(String advisorEmail) {
        this.advisorEmail = advisorEmail;
    }

    /**
     * Acessor method.
     *
     * @return List representing the candidate list associated with this Advisor
     */
    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    /**
     * Mutator method.
     *
     * @param candidateList New candidate list to be associated with this
     * Advisor
     */
    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    /**
     * Acessor method.
     *
     * @return List representing the log list associated with this Advisor
     */
    public List<Log> getLogList() {
        return logList;
    }

    /**
     * Mutator method.
     *
     * @param logList New Advisor log list
     */
    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    /**
     * Acessor method.
     *
     * @return List representing the job postings associated with this Advisor
     */
    public List<JobPosting> getJobPostingList() {
        return jobPostingList;
    }

    /**
     * Mutator method.
     *
     * @param jobPostingList New Advisor job posting list
     */
    public void setJobPostingList(List<JobPosting> jobPostingList) {
        this.jobPostingList = jobPostingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (advisorID != null ? advisorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advisor)) {
            return false;
        }
        Advisor other = (Advisor) object;
        if ((this.advisorID == null && other.advisorID != null) || (this.advisorID != null && !this.advisorID.equals(other.advisorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.Advisor[ advisorID=" + advisorID + " ]";
    }

}
