/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 815929
 */
@Entity
@Table(name = "job_posting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobPosting.findAll", query = "SELECT j FROM JobPosting j"),
    @NamedQuery(name = "JobPosting.findByJobpostingID", query = "SELECT j FROM JobPosting j WHERE j.jobpostingID = :jobpostingID"),
    @NamedQuery(name = "JobPosting.findByRequirements", query = "SELECT j FROM JobPosting j WHERE j.requirements = :requirements"),
    @NamedQuery(name = "JobPosting.findByStartDate", query = "SELECT j FROM JobPosting j WHERE j.startDate = :startDate"),
    @NamedQuery(name = "JobPosting.findByEndDate", query = "SELECT j FROM JobPosting j WHERE j.endDate = :endDate"),
    @NamedQuery(name = "JobPosting.findByApplicants", query = "SELECT j FROM JobPosting j WHERE j.applicants = :applicants")})
public class JobPosting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "job_postingID")
    private Integer jobpostingID;
    @Basic(optional = false)
    @Column(name = "requirements")
    private String requirements;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "applicants")
    private String applicants;
    @ManyToMany(mappedBy = "jobPostingCollection")
    private Collection<Candidate> candidateCollection;
    @JoinColumn(name = "business_clientID", referencedColumnName = "business_clientID")
    @OneToOne(optional = false)
    private BusinessClient businessclientID;

    public JobPosting() {
    }

    public JobPosting(Integer jobpostingID) {
        this.jobpostingID = jobpostingID;
    }

    public JobPosting(Integer jobpostingID, String requirements) {
        this.jobpostingID = jobpostingID;
        this.requirements = requirements;
    }

    public Integer getJobpostingID() {
        return jobpostingID;
    }

    public void setJobpostingID(Integer jobpostingID) {
        this.jobpostingID = jobpostingID;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getApplicants() {
        return applicants;
    }

    public void setApplicants(String applicants) {
        this.applicants = applicants;
    }

    @XmlTransient
    public Collection<Candidate> getCandidateCollection() {
        return candidateCollection;
    }

    public void setCandidateCollection(Collection<Candidate> candidateCollection) {
        this.candidateCollection = candidateCollection;
    }

    public BusinessClient getBusinessclientID() {
        return businessclientID;
    }

    public void setBusinessclientID(BusinessClient businessclientID) {
        this.businessclientID = businessclientID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobpostingID != null ? jobpostingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobPosting)) {
            return false;
        }
        JobPosting other = (JobPosting) object;
        if ((this.jobpostingID == null && other.jobpostingID != null) || (this.jobpostingID != null && !this.jobpostingID.equals(other.jobpostingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.JobPosting[ jobpostingID=" + jobpostingID + " ]";
    }
    
}
