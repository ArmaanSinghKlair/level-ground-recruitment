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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JobPosting entity class for the job_posting table in our database. Contains
 * method for both retrieving and setting values for a JobPosting.
 *
 * @author 839645
 * @version 1.0
 */
@Entity
@Table(name = "job_posting")
@NamedQueries({
    @NamedQuery(name = "JobPosting.findAll", query = "SELECT j FROM JobPosting j"),
    @NamedQuery(name = "JobPosting.findByJobpostingID", query = "SELECT j FROM JobPosting j WHERE j.jobpostingID = :jobpostingID"),
    @NamedQuery(name = "JobPosting.findByPostDate", query = "SELECT j FROM JobPosting j WHERE j.postDate = :postDate"),
    @NamedQuery(name = "JobPosting.findByJobStatus", query = "SELECT j FROM JobPosting j WHERE j.jobStatus = :jobStatus"),
    @NamedQuery(name = "JobPosting.findByWage", query = "SELECT j FROM JobPosting j WHERE j.wage = :wage"),
    @NamedQuery(name = "JobPosting.findByLocation", query = "SELECT j FROM JobPosting j WHERE j.location = :location"),
    @NamedQuery(name = "JobPosting.findByStartDate", query = "SELECT j FROM JobPosting j WHERE j.startDate = :startDate"),
    @NamedQuery(name = "JobPosting.findByEndDate", query = "SELECT j FROM JobPosting j WHERE j.endDate = :endDate"),
    @NamedQuery(name = "JobPosting.findByApplicants", query = "SELECT j FROM JobPosting j WHERE j.applicants = :applicants"),
    @NamedQuery(name = "JobPosting.findByAdvisorID", query = "SELECT j FROM JobPosting j WHERE j.advisorID = :advisorID"),
    @NamedQuery(name = "JobPosting.findByBusinessClientID", query = "SELECT j FROM JobPosting j WHERE j.businessclientID = :businessclientID")})
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
    @Basic(optional = false)
    @Column(name = "post_date")
    @Temporal(TemporalType.TIMESTAMP)
    private  Date postDate;
    @Column(name = "job_status")
    private String jobStatus;
    @Lob
    @Column(name = "job_description")
    private String jobDescription;
    @Lob
    @Column(name = "requirements")
    private String requirements;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "wage")
    private Double wage;
    @Column(name = "location")
    private String location;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private  Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private  Date endDate;
    @Column(name = "applicants")
    private Integer applicants;
    @OneToMany(mappedBy = "jobpostingID")
    private List<Application> applicationList;
    @JoinColumn(name = "advisorID", referencedColumnName = "advisorID")
    @ManyToOne(optional = false)
    private Advisor advisorID;
    @JoinColumn(name = "business_clientID", referencedColumnName = "business_clientID")
    @ManyToOne(optional = false)
    private BusinessClient businessclientID;

    /**
     * Default no-args constructor.
     */
    public JobPosting() {
    }

    /**
     * Arguments constructor that takes in the id for the JobPosting
     *
     * @param jobpostingID ID of the JobPosting
     */
    public JobPosting(Integer jobpostingID) {
        this.jobpostingID = jobpostingID;
    }

    /**
     * Arguments constructor that takes in various attributes for the
     * JobPosting.
     *
     * @param jobpostingID ID of the JobPosting
     * @param jobTitle title of the JobPosting
     * @param postDate post date of the JobPosting
     */
    public JobPosting(Integer jobpostingID, String jobTitle, Date postDate) {
        this.jobpostingID = jobpostingID;
        this.jobTitle = jobTitle;
        this.postDate = postDate;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing the JobPosting id
     */
    public Integer getJobpostingID() {
        return jobpostingID;
    }

    /**
     * Mutator method
     *
     * @param jobpostingID New JobPosting id
     */
    public void setJobpostingID(Integer jobpostingID) {
        this.jobpostingID = jobpostingID;
    }

    /**
     * Accessor method.
     *
     * @return String representing the JobPosting title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Mutator method.
     *
     * @param jobTitle New JobPosting title
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Accessor method.
     *
     * @return Date representing the post date for the JobPosting
     */
    public Date getPostDate() {
        return postDate;
    }

    /**
     * Mutator method.
     *
     * @param postDate New JobPosting post date
     */
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    /**
     * Accessor method.
     *
     * @return String representing the JobPosting status
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * Mutator method.
     *
     * @param jobStatus New JobPosting status
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * Accessor method.
     *
     * @return String representing the JobPosting description
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * Mutator method.
     *
     * @param jobDescription New JobPosting description
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * Accessor method.
     *
     * @return String representing the JobPosting requirements
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * Mutator method.
     *
     * @param requirements New JobPosting requirements
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    /**
     * Accessor method.
     *
     * @return Double representing the JobPosting wage
     */
    public Double getWage() {
        return wage;
    }

    /**
     * Mutator method.
     *
     * @param wage New JobPosting wage
     */
    public void setWage(Double wage) {
        this.wage = wage;
    }

    /**
     * Accessor method.
     *
     * @return String representing the JobPosting location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Mutator method
     *
     * @param location New JobPosting location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Accessor method.
     *
     * @return Date representing the JobPosting start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Mutator method.
     *
     * @param startDate New JobPosting start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Accessor method.
     *
     * @return Date representing the JobPosting end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Mutator method.
     *
     * @param endDate New JobPosting end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing the JobPosting applicants
     */
    public Integer getApplicants() {
        return applicants;
    }

    /**
     * Mutator method.
     *
     * @param applicants New JobPosting applicants
     */
    public void setApplicants(Integer applicants) {
        this.applicants = applicants;
    }

    /**
     * Accessor method.
     *
     * @return List of applications associated with this JobPosting
     */
    public List<Application> getApplicationList() {
        return applicationList;
    }

    /**
     * Mutator method.
     *
     * @param applicationList New JobPosting application list
     */
    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    /**
     * Accessor method.
     *
     * @return Advisor object associated with this JobPosting
     */
    public Advisor getAdvisorID() {
        return advisorID;
    }

    /**
     * Mutator method.
     *
     * @param advisorID New JobPosting Advisor
     */
    public void setAdvisorID(Advisor advisorID) {
        this.advisorID = advisorID;
    }

    /**
     * Accessor method.
     *
     * @return BusinessClient object associated with this JobPosting
     */
    public BusinessClient getBusinessclientID() {
        return businessclientID;
    }

    /**
     * Mutator method.
     *
     * @param businessclientID New JobPosting BusinessClient
     */
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
