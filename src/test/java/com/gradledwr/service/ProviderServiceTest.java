package com.test.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.domain.Provider;

public class ProviderServiceTest {

	ProviderService service = null;

	@Before
	public void before() {
		service = new ProviderService();
	}

	@After
	public void after() {
		service = null;
	}

	@Test
	public void testDAONotNull() {
		Assert.assertNotNull(service);
	}

	@Test
	public void testProvider() {
		List<Provider> providers = service.getAllProviders();
		Assert.assertEquals(true, providers.size() > 0);
	}

	@Test
	public void testProviderByName() {
		List<Provider> providers = service.getProvidersByName("AAFFF");
		Assert.assertEquals(true, providers.size() > 0);
	}

}
