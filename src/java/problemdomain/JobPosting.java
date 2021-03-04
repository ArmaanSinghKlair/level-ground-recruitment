/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 839645
 */
@Entity
@Table(name = "job_posting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobPosting.findAll", query = "SELECT j FROM JobPosting j"),
    @NamedQuery(name = "JobPosting.findByJobpostingID", query = "SELECT j FROM JobPosting j WHERE j.jobpostingID = :jobpostingID"),
    @NamedQuery(name = "JobPosting.findByPostDate", query = "SELECT j FROM JobPosting j WHERE j.postDate = :postDate"),
    @NamedQuery(name = "JobPosting.findByJobStatus", query = "SELECT j FROM JobPosting j WHERE j.jobStatus = :jobStatus"),
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
    @Lob
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "post_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    @Basic(optional = false)
    @Column(name = "job_status")
    private String jobStatus;
    @Basic(optional = false)
    @Lob
    @Column(name = "job_description")
    private String jobDescription;
    @Lob
    @Column(name = "requirements")
    private String requirements;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "applicants")
    private Integer applicants;
    @OneToMany(mappedBy = "jobpostingID")
    private List<Application> applicationList;
    @JoinColumn(name = "business_clientID", referencedColumnName = "business_clientID")
    @OneToOne(optional = false)
    private BusinessClient businessclientID;

    public JobPosting() {
    }

    public JobPosting(Integer jobpostingID) {
        this.jobpostingID = jobpostingID;
    }

    public JobPosting(Integer jobpostingID, String jobTitle, String jobStatus, String jobDescription) {
        this.jobpostingID = jobpostingID;
        this.jobTitle = jobTitle;
        this.jobStatus = jobStatus;
        this.jobDescription = jobDescription;
    }

    public Integer getJobpostingID() {
        return jobpostingID;
    }

    public void setJobpostingID(Integer jobpostingID) {
        this.jobpostingID = jobpostingID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
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

    public Integer getApplicants() {
        return applicants;
    }

    public void setApplicants(Integer applicants) {
        this.applicants = applicants;
    }

    @XmlTransient
    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
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
