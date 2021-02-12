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
 * @author Kane Imler
 * @version 02/12/2021
 */
@Entity
@Table(name = "log")
@XmlRootElement
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

    public Log() {
    }

    public Log(Integer logID) {
        this.logID = logID;
    }

    public Log(Integer logID, Date loginDate) {
        this.logID = logID;
        this.loginDate = loginDate;
    }

    public Integer getLogID() {
        return logID;
    }

    public void setLogID(Integer logID) {
        this.logID = logID;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Advisor getAdvisorID() {
        return advisorID;
    }

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
