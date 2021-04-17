/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BusinessClient entity class for the business_client table in our database.
 * Contains method for both retrieving and setting values for a BusinessClient.
 *
 * @author 839645
 * @version 1.0
 */
@Entity
@Table(name = "business_client")
@NamedQueries({
    @NamedQuery(name = "BusinessClient.findAll", query = "SELECT b FROM BusinessClient b"),
    @NamedQuery(name = "BusinessClient.findByBusinessclientID", query = "SELECT b FROM BusinessClient b WHERE b.businessclientID = :businessclientID"),
    @NamedQuery(name = "BusinessClient.findByBusClientUsername", query = "SELECT b FROM BusinessClient b WHERE b.busClientUsername = :busClientUsername"),
    @NamedQuery(name = "BusinessClient.findByBusClientPassword", query = "SELECT b FROM BusinessClient b WHERE b.busClientPassword = :busClientPassword"),
    @NamedQuery(name = "BusinessClient.findByBusClientCompany", query = "SELECT b FROM BusinessClient b WHERE b.busClientCompany = :busClientCompany"),
    @NamedQuery(name = "BusinessClient.findByBusClientAddress", query = "SELECT b FROM BusinessClient b WHERE b.busClientAddress = :busClientAddress"),
    @NamedQuery(name = "BusinessClient.findByBusClientEmail", query = "SELECT b FROM BusinessClient b WHERE b.busClientEmail = :busClientEmail"),
    @NamedQuery(name = "BusinessClient.findByBusClientPhone", query = "SELECT b FROM BusinessClient b WHERE b.busClientPhone = :busClientPhone"),
    @NamedQuery(name = "BusinessClient.findByBusClientWebsite", query = "SELECT b FROM BusinessClient b WHERE b.busClientWebsite = :busClientWebsite")})
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
    @Column(name = "bus_client_company")
    private String busClientCompany;
    @Lob
    @Column(name = "bus_client_description")
    private String busClientDescription;
    @Column(name = "bus_client_address")
    private String busClientAddress;
    @Basic(optional = false)
    @Column(name = "bus_client_email")
    private String busClientEmail;
    @Column(name = "bus_client_phone")
    private String busClientPhone;
    @Column(name = "bus_client_website")
    private String busClientWebsite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businessclientID")
    private List<JobPosting> jobPostingList;

    /**
     * Default no-args constructor.
     */
    public BusinessClient() {
    }

    /**
     * Arguments constructor that takes in the id for the BusinessClient.
     *
     * @param businessclientID ID of the BusinessClient
     */
    public BusinessClient(Integer businessclientID) {
        this.businessclientID = businessclientID;
    }

    /**
     * Arguments constructor that takes in various attributes for the
     * BusinessClient.
     *
     * @param businessclientID ID of the BusinessClient
     * @param busClientUsername username of the BusinessClient
     * @param busClientPassword password of the BusinessClient
     * @param busClientCompany company of the BusinessClient
     * @param busClientEmail email of the BusinessClient
     */
    public BusinessClient(Integer businessclientID, String busClientUsername, String busClientPassword, String busClientCompany, String busClientEmail) {
        this.businessclientID = businessclientID;
        this.busClientUsername = busClientUsername;
        this.busClientPassword = busClientPassword;
        this.busClientCompany = busClientCompany;
        this.busClientEmail = busClientEmail;
    }

    /**
     * Accessor method.
     *
     * @return Integer representing the BusinessClient id
     */
    public Integer getBusinessclientID() {
        return businessclientID;
    }

    /**
     * Mutator method.
     *
     * @param businessclientID New BusinessClient id
     */
    public void setBusinessclientID(Integer businessclientID) {
        this.businessclientID = businessclientID;
    }

    /**
     * Accessor method.
     *
     * @return String representing the BusinessClient username
     */
    public String getBusClientUsername() {
        return busClientUsername;
    }

    /**
     * Mutator method.
     *
     * @param busClientUsername New BusinessClient username
     */
    public void setBusClientUsername(String busClientUsername) {
        this.busClientUsername = busClientUsername;
    }

    /**
     * Accessor method.
     *
     * @return String representing the BusinessClient password
     */
    public String getBusClientPassword() {
        return busClientPassword;
    }

    /**
     * Mutator method.
     *
     * @param busClientPassword New BusinessClient password
     */
    public void setBusClientPassword(String busClientPassword) {
        this.busClientPassword = busClientPassword;
    }

    /**
     * Accessor method.
     *
     * @return String representing BusinessClient company
     */
    public String getBusClientCompany() {
        return busClientCompany;
    }

    /**
     * Mutator method.
     *
     * @param busClientCompany New BusinessClient company
     */
    public void setBusClientCompany(String busClientCompany) {
        this.busClientCompany = busClientCompany;
    }

    /**
     * Accessor method.
     *
     * @return String representing BusinesssClient description
     */
    public String getBusClientDescription() {
        return busClientDescription;
    }

    /**
     * Mutator method.
     *
     * @param busClientDescription New BusinessClient description
     */
    public void setBusClientDescription(String busClientDescription) {
        this.busClientDescription = busClientDescription;
    }

    /**
     * Accessor method.
     *
     * @return String representing BusinessClient address
     */
    public String getBusClientAddress() {
        return busClientAddress;
    }

    /**
     * Mutator method.
     *
     * @param busClientAddress New BusinessClient address
     */
    public void setBusClientAddress(String busClientAddress) {
        this.busClientAddress = busClientAddress;
    }

    /**
     * Accessor method.
     *
     * @return String representing BusinessClient email
     */
    public String getBusClientEmail() {
        return busClientEmail;
    }

    /**
     * Mutator method.
     *
     * @param busClientEmail New BusinessClient email
     */
    public void setBusClientEmail(String busClientEmail) {
        this.busClientEmail = busClientEmail;
    }

    /**
     * Accessor method.
     *
     * @return String representing BusinessClient phone
     */
    public String getBusClientPhone() {
        return busClientPhone;
    }

    /**
     * Mutator method.
     *
     * @param busClientPhone New BusinessClient phone
     */
    public void setBusClientPhone(String busClientPhone) {
        this.busClientPhone = busClientPhone;
    }

    /**
     * Accessor method.
     *
     * @return String representing BusinessClient website
     */
    public String getBusClientWebsite() {
        return busClientWebsite;
    }

    /**
     * Mutator method.
     *
     * @param busClientWebsite New BusinessClient website
     */
    public void setBusClientWebsite(String busClientWebsite) {
        this.busClientWebsite = busClientWebsite;
    }

    /**
     * Accessor method.
     *
     * @return List of job postings associated with this BusinessClient
     */
    public List<JobPosting> getJobPostingList() {
        return jobPostingList;
    }

    /**
     * Mutator method.
     *
     * @param jobPostingList New BusinessClient job posting list
     */
    public void setJobPostingList(List<JobPosting> jobPostingList) {
        this.jobPostingList = jobPostingList;
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
