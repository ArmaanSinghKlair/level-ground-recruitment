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
 * Log entity class for the log table in our database. Contains method for both
 * retrieving and setting values for a Log.
 *
 * @author 839645
 * @version 1.0
 */
@Entity
@Table(name = "log")
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByLogID", query = "SELECT l FROM Log l WHERE l.logID = :logID"),
    @NamedQuery(name = "Log.findByLoginDate", query = "SELECT l FROM Log l WHERE l.loginDate = :loginDate"),
    @NamedQuery(name = "Log.findByLogoutDate", query = "SELECT l FROM Log l WHERE l.logoutDate = :logoutDate"),
    @NamedQuery(name = "Log.findByDescription", query = "SELECT l FROM Log l WHERE l.description = :description")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "logID")
    private Integer logID;
    @Basic(optional = false)
    @Column(name = "login_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;
    @Column(name = "logout_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutDate;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "advisorID", referencedColumnName = "advisorID")
    @ManyToOne(optional = false)
    private Advisor advisorID;

    /**
     * Default no-args constructor.
     */
    public Log() {
    }

    /**
     * Arguments constructor that takes in the id for the Log
     *
     * @param logID ID of the Log
     */
    public Log(Integer logID) {
        this.logID = logID;
    }

    /**
     * Arguments constructor that takes in the id and login date for the Log
     *
     * @param logID ID of the Log
     * @param loginDate login date of the Log
     */
    public Log(Integer logID, Date loginDate) {
        this.logID = logID;
        this.loginDate = loginDate;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing Log id
     */
    public Integer getLogID() {
        return logID;
    }

    /**
     * Mutator method.
     *
     * @param logID New Log id
     */
    public void setLogID(Integer logID) {
        this.logID = logID;
    }

    /**
     * Accessor method.
     *
     * @return Date representing Log login date
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * Mutator method.
     *
     * @param loginDate New Log login date
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * Accessor method.
     *
     * @return Date representing Log logout date
     */
    public Date getLogoutDate() {
        return logoutDate;
    }

    /**
     * Mutator method.
     *
     * @param logoutDate New Log logout date
     */
    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    /**
     * Accessor method.
     *
     * @return String representing Log description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mutator method.
     *
     * @param description New Log description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accessor method.
     *
     * @return Advisor object representing the advisor associated with this Log
     */
    public Advisor getAdvisorID() {
        return advisorID;
    }

    /**
     * Mutator method.
     *
     * @param advisorID New Log Advisor
     */
    public void setAdvisorID(Advisor advisorID) {
        this.advisorID = advisorID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logID != null ? logID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.logID == null && other.logID != null) || (this.logID != null && !this.logID.equals(other.logID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.Log[ logID=" + logID + " ]";
    }

}
