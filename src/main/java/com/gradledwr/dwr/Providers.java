package com.gradledwr.dwr;

import java.util.ArrayList;
import java.util.List;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import com.gradledwr.converter.JsonReaderResponse;
import com.gradledwr.converter.ProviderRecord;
import com.gradledwr.domain.Provider;
import com.gradledwr.service.ProviderService;

/**
 * The main DWR Proxy Object called from the DWR JavaScript. Look more in
 * provider-grid.js file for the DWRProxy call.
 * 
 * @author e578493
 *
 */
@RemoteProxy(name = "Providers")
public class Providers {

	@RemoteMethod
	public JsonReaderResponse<ProviderRecord> getAllProviders() {
		ProviderService service = new ProviderService();
		List<Provider> providers = service.getAllProviders();
		List<ProviderRecord> record = new ArrayList<ProviderRecord>();
		for (Provider p : providers) {
			ProviderRecord r = new ProviderRecord(p.getProviderId().toString(),
					p.getProviderName(), p.getStatus(),
					p.isEmailConfirmation(), p.getDtAdded());
			record.add(r);
		}
		return new JsonReaderResponse<ProviderRecord>(record);
	}
}
