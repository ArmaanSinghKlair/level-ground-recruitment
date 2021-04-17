/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Application entity class for the application table in our database. Contains
 * method for both retrieving and setting values for an Application.
 *
 * @author 839645
 * @version 1.0
 */
@Entity
@Table(name = "application")
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a"),
    @NamedQuery(name = "Application.findByApplicationID", query = "SELECT a FROM Application a WHERE a.applicationID = :applicationID"),
    @NamedQuery(name = "Application.findByStatus", query = "SELECT a FROM Application a WHERE a.status = :status"),
    @NamedQuery(name = "Application.findByJobpostingID", query = "SELECT a FROM Application a WHERE a.jobpostingID = :jobpostingID"),
    @NamedQuery(name = "Application.findByBothID", query = "SELECT a FROM Application a WHERE a.jobpostingID.jobpostingID = :jobpostingID AND a.candidateID.candidateID = :candidateID")})
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "applicationID")
    private Integer applicationID;
    @Column(name = "status")
    private Short status;
    @JoinColumn(name = "candidateID", referencedColumnName = "candidateID")
    @ManyToOne
    private Candidate candidateID;
    @JoinColumn(name = "job_postingID", referencedColumnName = "job_postingID")
    @ManyToOne
    private JobPosting jobpostingID;

    /**
     * Default no-args constructor.
     */
    public Application() {
    }

    /**
     * Argument constructor that takes in the id for the Application.
     *
     * @param applicationID ID of the application
     */
    public Application(Integer applicationID) {
        this.applicationID = applicationID;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing Application id
     */
    public Integer getApplicationID() {
        return applicationID;
    }

    /**
     * Mutator method.
     *
     * @param applicationID New Application id
     */
    public void setApplicationID(Integer applicationID) {
        this.applicationID = applicationID;
    }

    /**
     * Accessor method.
     *
     * @return Short representing Application status
     */
    public Short getStatus() {
        return status;
    }

    /**
     * Mutator method.
     *
     * @param status New Application status
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * Accessor method.
     *
     * @return Candidate object representing the candidate associated with this
     * Application
     */
    public Candidate getCandidateID() {
        return candidateID;
    }

    /**
     * Mutator method.
     *
     * @param candidateID New Application candidate
     */
    public void setCandidateID(Candidate candidateID) {
        this.candidateID = candidateID;
    }

    /**
     * Accessor method.
     *
     * @return JobPosting object representing the jobposting associated with
     * this Application
     */
    public JobPosting getJobpostingID() {
        return jobpostingID;
    }

    /**
     * Mutator method.
     *
     * @param jobpostingID New Application jobposting
     */
    public void setJobpostingID(JobPosting jobpostingID) {
        this.jobpostingID = jobpostingID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicationID != null ? applicationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.applicationID == null && other.applicationID != null) || (this.applicationID != null && !this.applicationID.equals(other.applicationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.Application[ applicationID=" + applicationID + " ]";
    }

}
