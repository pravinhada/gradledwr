package com.test.converter;

import java.util.List;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;
import org.directwebremoting.convert.ObjectConverter;

@DataTransferObject(converter = ObjectConverter.class)
public class JsonReaderResponse<T> {
	@RemoteProperty
	public List<T> objectsToConvertToRecords;
	/**
	 * @see Ext.data.JsonReader.successProperty
	 */
	@RemoteProperty
	public boolean success;

	/**
	 * Creates a {@link #success}ful JsonReaderResponse with the provided
	 * {@link #objectsToConvertToRecords}.
	 * 
	 * @param objectsToConvertToRecords
	 */
	public JsonReaderResponse(List<T> objectsToConvertToRecords) {
		this.objectsToConvertToRecords = objectsToConvertToRecords;
		success = true;
	}

	/**
	 * Creates an un{@link #success}ful JsonReaderResponse with null
	 * {@link #objectsToConvertToRecords}. This signals the case where the
	 * client established a connection with the server, but the server couldn't
	 * fulfill it (e.g., user doesn't have proper user credentials).
	 * 
	 * @param objectsToConvertToRecords
	 */
	public JsonReaderResponse() {
		this.objectsToConvertToRecords = null;
		success = false;
	}
}