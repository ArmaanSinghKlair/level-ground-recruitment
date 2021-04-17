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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Education entity class for the education table in our database. Contains
 * method for both retrieving and setting values for an Education.
 *
 * @author 839645
 * @version 1.0
 */
@Entity
@Table(name = "education")
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e"),
    @NamedQuery(name = "Education.findByEducationID", query = "SELECT e FROM Education e WHERE e.educationID = :educationID"),
    @NamedQuery(name = "Education.findByLevel", query = "SELECT e FROM Education e WHERE e.level = :level"),
    @NamedQuery(name = "Education.findByInstitution", query = "SELECT e FROM Education e WHERE e.institution = :institution"),
    @NamedQuery(name = "Education.findBySubject", query = "SELECT e FROM Education e WHERE e.subject = :subject"),
    @NamedQuery(name = "Education.findByStartDate", query = "SELECT e FROM Education e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "Education.findByEndDate", query = "SELECT e FROM Education e WHERE e.endDate = :endDate"),
    @NamedQuery(name = "Education.findByType", query = "SELECT e FROM Education e WHERE e.type = :type")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "educationID")
    private Integer educationID;
    @Basic(optional = false)
    @Column(name = "level")
    private String level;
    @Basic(optional = false)
    @Column(name = "institution")
    private String institution;
    @Basic(optional = false)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "type")
    private boolean type;
    @JoinColumn(name = "candidateID", referencedColumnName = "candidateID")
    @ManyToOne
    private Candidate candidateID;

    /**
     * Default no-args constructor.
     */
    public Education() {
    }

    /**
     * Arguments constructor that takes in the id for the Education.
     *
     * @param educationID ID of the Education
     */
    public Education(Integer educationID) {
        this.educationID = educationID;
    }

    /**
     * Arguments constructor that takes in various attributes for the Education.
     *
     * @param educationID ID of the Education
     * @param level level of the Education
     * @param institution institution of the Education
     * @param subject subject of the Education
     * @param startDate start date of the Education
     * @param type type of the Education
     */
    public Education(Integer educationID, String level, String institution, String subject, Date startDate, boolean type) {
        this.educationID = educationID;
        this.level = level;
        this.institution = institution;
        this.subject = subject;
        this.startDate = startDate;
        this.type = type;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing Education id
     */
    public Integer getEducationID() {
        return educationID;
    }

    /**
     * Mutator method.
     *
     * @param educationID New Education id
     */
    public void setEducationID(Integer educationID) {
        this.educationID = educationID;
    }

    /**
     * Accessor method.
     *
     * @return String representing Education level
     */
    public String getLevel() {
        return level;
    }

    /**
     * Mutator method.
     *
     * @param level New Education level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Accessor method.
     *
     * @return String representing Education institution
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * Mutator method
     *
     * @param institution New Education institution
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * Accessor method.
     *
     * @return String representing Education subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Mutator method.
     *
     * @param subject New Education subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Accessor method.
     *
     * @return Date representing the start date for the Education
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Mutator method.
     *
     * @param startDate New Education start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Accessor method.
     *
     * @return Date representing the end date for the Education
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Mutator method
     *
     * @param endDate New Education end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Accessor method.
     *
     * @return Boolean representing the type of the Education
     */
    public boolean getType() {
        return type;
    }

    /**
     * Mutator method.
     *
     * @param type New Education type
     */
    public void setType(boolean type) {
        this.type = type;
    }

    /**
     * Accessor method.
     *
     * @return Candidate object associated with this Education
     */
    public Candidate getCandidateID() {
        return candidateID;
    }

    /**
     * Mutator method.
     *
     * @param candidateID New Education Candidate
     */
    public void setCandidateID(Candidate candidateID) {
        this.candidateID = candidateID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educationID != null ? educationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.educationID == null && other.educationID != null) || (this.educationID != null && !this.educationID.equals(other.educationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.Education[ educationID=" + educationID + " ]";
    }

}
