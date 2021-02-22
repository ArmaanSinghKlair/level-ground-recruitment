/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kane Imler
 * @version 2/11/2021
 */
@Entity
@Table(name = "job_posting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobPosting.findAll", query = "SELECT j FROM JobPosting j"),
    @NamedQuery(name = "JobPosting.findByJobpostingID", query = "SELECT j FROM JobPosting j WHERE j.jobpostingID = :jobpostingID"),
    @NamedQuery(name = "JobPosting.findByRequirements", query = "SELECT j FROM JobPosting j WHERE j.requirements = :requirements"),
    @NamedQuery(name = "JobPosting.findByTitle", query = "SELECT j FROM JobPosting j WHERE j.title = :title"),
    @NamedQuery(name = "JobPosting.findByJopDescription", query = "SELECT j FROM JobPosting j WHERE j.jopDescription = :jopDescription"),
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
    @Column(name = "requirements")
    private String requirements;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "jop_description")
    private String jopDescription;
    @Column(name = "job_status")
    private String jobStatus;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "applicants")
    private String applicants;
    @JoinColumn(name = "business_clientID", referencedColumnName = "business_clientID")
    @OneToOne(optional = false)
    private BusinessClient businessclientID;

    public JobPosting() {
    }

    public JobPosting(Integer jobpostingID) {
        this.jobpostingID = jobpostingID;
    }

    public JobPosting(Integer jobpostingID, String requirements, String title) {
        this.jobpostingID = jobpostingID;
        this.requirements = requirements;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJopDescription() {
        return jopDescription;
    }

    public void setJopDescription(String jopDescription) {
        this.jopDescription = jopDescription;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
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
