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
 *
 * @author 839645
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

    public Advisor() {
    }

    public Advisor(Integer advisorID) {
        this.advisorID = advisorID;
    }

    public Advisor(Integer advisorID, String advisorUsername, String advisorPassword, String advisorfirstName, String advisorlastName, String advisorEmail) {
        this.advisorID = advisorID;
        this.advisorUsername = advisorUsername;
        this.advisorPassword = advisorPassword;
        this.advisorfirstName = advisorfirstName;
        this.advisorlastName = advisorlastName;
        this.advisorEmail = advisorEmail;
    }

    public Integer getAdvisorID() {
        return advisorID;
    }

    public void setAdvisorID(Integer advisorID) {
        this.advisorID = advisorID;
    }

    public String getAdvisorUsername() {
        return advisorUsername;
    }

    public void setAdvisorUsername(String advisorUsername) {
        this.advisorUsername = advisorUsername;
    }

    public String getAdvisorPassword() {
        return advisorPassword;
    }

    public void setAdvisorPassword(String advisorPassword) {
        this.advisorPassword = advisorPassword;
    }

    public String getAdvisorfirstName() {
        return advisorfirstName;
    }

    public void setAdvisorfirstName(String advisorfirstName) {
        this.advisorfirstName = advisorfirstName;
    }

    public String getAdvisorlastName() {
        return advisorlastName;
    }

    public void setAdvisorlastName(String advisorlastName) {
        this.advisorlastName = advisorlastName;
    }

    public String getAdvisorEmail() {
        return advisorEmail;
    }

    public void setAdvisorEmail(String advisorEmail) {
        this.advisorEmail = advisorEmail;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    public List<JobPosting> getJobPostingList() {
        return jobPostingList;
    }

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
