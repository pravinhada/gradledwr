package com.gradledwr.converter;

import java.util.Date;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;
import org.directwebremoting.convert.ObjectConverter;

/**
 * Create as Data Transfer Object, convert this to JSON by DWR and pass to the
 * UI JavaScript.
 * 
 * @author e578493
 *
 */
@DataTransferObject(converter = ObjectConverter.class)
public class ProviderRecord {

	@RemoteProperty
	public String providerId;

	@RemoteProperty
	public String providerName;

	@RemoteProperty
	public String status;

	@RemoteProperty
	public boolean emailConfirmation;

	@RemoteProperty
	public Date dateAdded;

	public ProviderRecord() {
	}

	public ProviderRecord(String providerId, String providerName,
			String status, boolean emailConfirmation, Date dateAdded) {
		this.providerId = providerId;
		this.providerName = providerName;
		this.status = status;
		this.emailConfirmation = emailConfirmation;
		this.dateAdded = dateAdded;
	}
}