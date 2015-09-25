package com.gradledwr.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PROVIDER")
@NamedQueries({
		@NamedQuery(name = "Provider.getAllProvider", query = "from Provider p order by p.providerName asc"),
		@NamedQuery(name = "Provider.getProviderByName", query = "from Provider p where p.providerName=:name order by p.providerName") })
public class Provider {

	@Id
	@Column(name = "PROVIDER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long providerId;

	@Column(name = "PROVIDER_NAME", length = 50, nullable = false, unique = true)
	private String providerName;

	@Column(name = "STATUS", length = 1)
	private String status;

	@Column(name = "DT_ADDED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtAdded;

	@Column(name = "ADDED_BY", length = 50)
	private String addedBy;

	@Column(name = "DT_UPDATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtUpdated;

	@Column(name = "EMAIL_CONFIRMATION")
	private boolean emailConfirmation = false;

	@Column(name = "CONTACT_DETAILS", length = 200)
	private String contactDetail;

	@Column(name = "DISCLAIMER1", length = 256)
	private String disclaimer1;

	@Column(name = "DISCLAIMER2", length = 256)
	private String disclaimer2;

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDtAdded() {
		return dtAdded;
	}

	public void setDtAdded(Date dtAdded) {
		this.dtAdded = dtAdded;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getDtUpdated() {
		return dtUpdated;
	}

	public void setDtUpdated(Date dtUpdated) {
		this.dtUpdated = dtUpdated;
	}

	public boolean isEmailConfirmation() {
		return emailConfirmation;
	}

	public void setEmailConfirmation(boolean emailConfirmation) {
		this.emailConfirmation = emailConfirmation;
	}

	public String getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(String contactDetail) {
		this.contactDetail = contactDetail;
	}

	public String getDisclaimer1() {
		return disclaimer1;
	}

	public void setDisclaimer1(String disclaimer1) {
		this.disclaimer1 = disclaimer1;
	}

	public String getDisclaimer2() {
		return disclaimer2;
	}

	public void setDisclaimer2(String disclaimer2) {
		this.disclaimer2 = disclaimer2;
	}
}
