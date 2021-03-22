/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 839645
 */
@Entity
@Table(name = "business_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusinessClient.findAll", query = "SELECT b FROM BusinessClient b"),
    @NamedQuery(name = "BusinessClient.findByBusinessclientID", query = "SELECT b FROM BusinessClient b WHERE b.businessclientID = :businessclientID"),
    @NamedQuery(name = "BusinessClient.findByBusClientUsername", query = "SELECT b FROM BusinessClient b WHERE b.busClientUsername = :busClientUsername"),
    @NamedQuery(name = "BusinessClient.findByBusClientPassword", query = "SELECT b FROM BusinessClient b WHERE b.busClientPassword = :busClientPassword"),
    @NamedQuery(name = "BusinessClient.findByBusclientfirstName", query = "SELECT b FROM BusinessClient b WHERE b.busclientfirstName = :busclientfirstName"),
    @NamedQuery(name = "BusinessClient.findByBusclientlastName", query = "SELECT b FROM BusinessClient b WHERE b.busclientlastName = :busclientlastName"),
    @NamedQuery(name = "BusinessClient.findByBusClientEmail", query = "SELECT b FROM BusinessClient b WHERE b.busClientEmail = :busClientEmail"),
    @NamedQuery(name = "BusinessClient.findByBusClientPhone", query = "SELECT b FROM BusinessClient b WHERE b.busClientPhone = :busClientPhone"),
    @NamedQuery(name = "BusinessClient.findByBusClientPayment", query = "SELECT b FROM BusinessClient b WHERE b.busClientPayment = :busClientPayment"),
    @NamedQuery(name = "BusinessClient.findByAdvisorID", query = "SELECT b FROM BusinessClient b WHERE b.advisorID = :advisorID")})
public class BusinessClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "business_clientID")
    private Integer businessclientID;
    @Basic(optional = false)
    @Column(name = "bus_client_username")
    private String busClientUsername;
    @Basic(optional = false)
    @Column(name = "bus_client_password")
    private String busClientPassword;
    @Basic(optional = false)
    @Column(name = "bus_client_firstName")
    private String busclientfirstName;
    @Basic(optional = false)
    @Column(name = "bus_client_lastName")
    private String busclientlastName;
    @Basic(optional = false)
    @Column(name = "bus_client_email")
    private String busClientEmail;
    @Column(name = "bus_client_phone")
    private String busClientPhone;
    @Basic(optional = false)
    @Column(name = "bus_client_payment")
    private String busClientPayment;
    @JoinColumn(name = "advisorID", referencedColumnName = "advisorID")
    @ManyToOne
    private Advisor advisorID;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "businessclientID")
    private JobPosting jobPosting;

    public BusinessClient() {
    }

    public BusinessClient(Integer businessclientID) {
        this.businessclientID = businessclientID;
    }

    public BusinessClient(Integer businessclientID, String busClientUsername, String busClientPassword, String busclientfirstName, String busclientlastName, String busClientEmail, String busClientPayment) {
        this.businessclientID = businessclientID;
        this.busClientUsername = busClientUsername;
        this.busClientPassword = busClientPassword;
        this.busclientfirstName = busclientfirstName;
        this.busclientlastName = busclientlastName;
        this.busClientEmail = busClientEmail;
        this.busClientPayment = busClientPayment;
    }

    public Integer getBusinessclientID() {
        return businessclientID;
    }

    public void setBusinessclientID(Integer businessclientID) {
        this.businessclientID = businessclientID;
    }

    public String getBusClientUsername() {
        return busClientUsername;
    }

    public void setBusClientUsername(String busClientUsername) {
        this.busClientUsername = busClientUsername;
    }

    public String getBusClientPassword() {
        return busClientPassword;
    }

    public void setBusClientPassword(String busClientPassword) {
        this.busClientPassword = busClientPassword;
    }

    public String getBusclientfirstName() {
        return busclientfirstName;
    }

    public void setBusclientfirstName(String busclientfirstName) {
        this.busclientfirstName = busclientfirstName;
    }

    public String getBusclientlastName() {
        return busclientlastName;
    }

    public void setBusclientlastName(String busclientlastName) {
        this.busclientlastName = busclientlastName;
    }

    public String getBusClientEmail() {
        return busClientEmail;
    }

    public void setBusClientEmail(String busClientEmail) {
        this.busClientEmail = busClientEmail;
    }

    public String getBusClientPhone() {
        return busClientPhone;
    }

    public void setBusClientPhone(String busClientPhone) {
        this.busClientPhone = busClientPhone;
    }

    public String getBusClientPayment() {
        return busClientPayment;
    }

    public void setBusClientPayment(String busClientPayment) {
        this.busClientPayment = busClientPayment;
    }

    public Advisor getAdvisorID() {
        return advisorID;
    }

    public void setAdvisorID(Advisor advisorID) {
        this.advisorID = advisorID;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessclientID != null ? businessclientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessClient)) {
            return false;
        }
        BusinessClient other = (BusinessClient) object;
        if ((this.businessclientID == null && other.businessclientID != null) || (this.businessclientID != null && !this.businessclientID.equals(other.businessclientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "problemdomain.BusinessClient[ businessclientID=" + businessclientID + " ]";
    }
    
}
