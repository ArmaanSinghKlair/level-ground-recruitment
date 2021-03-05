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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 839645
 */
@Entity
@Table(name = "work_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkHistory.findAll", query = "SELECT w FROM WorkHistory w"),
    @NamedQuery(name = "WorkHistory.findByWorkhistoryID", query = "SELECT w FROM WorkHistory w WHERE w.workhistoryID = :workhistoryID"),
    @NamedQuery(name = "WorkHistory.findByCompany", query = "SELECT w FROM WorkHistory w WHERE w.company = :company"),
    @NamedQuery(name = "WorkHistory.findByTitle", query = "SELECT w FROM WorkHistory w WHERE w.title = :title"),
    @NamedQuery(name = "WorkHistory.findByStartDate", query = "SELECT w FROM WorkHistory w WHERE w.startDate = :startDate"),
    @NamedQuery(name = "WorkHistory.findByEndDate", query = "SELECT w FROM WorkHistory w WHERE w.endDate = :endDate"),
    @NamedQuery(name = "WorkHistory.findByReference", query = "SELECT w FROM WorkHistory w WHERE w.reference = :reference")})
public class WorkHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "work_historyID")
    private Integer workhistoryID;
    @Basic(optional = false)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "reference")
    private String reference;
    @JoinColumn(name = "candidateID", referencedColumnName = "candidateID")
    @ManyToOne
    private Candidate candidateID;

    public WorkHistory() {
    }

    public WorkHistory(Integer workhistoryID) {
        this.workhistoryID = workhistoryID;
    }

    public WorkHistory(Integer workhistoryID, String company, String title, Date startDate) {
        this.workhistoryID = workhistoryID;
        this.company = company;
        this.title = title;
        this.startDate = startDate;
    }

    public Integer getWorkhistoryID() {
        return workhistoryID;
    }

    public void setWorkhistoryID(Integer workhistoryID) {
        this.workhistoryID = workhistoryID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Candidate getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Candidate candidateID) {
        this.candidateID = candidateID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workhistoryID != null ? workhistoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkHistory)) {
            return false;
        }
        WorkHistory other = (WorkHistory) object;
        if ((this.workhistoryID == null && other.workhistoryID != null) || (this.workhistoryID != null && !this.workhistoryID.equals(other.workhistoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.WorkHistory[ workhistoryID=" + workhistoryID + " ]";
    }
    
}
