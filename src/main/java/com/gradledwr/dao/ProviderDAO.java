package com.test.dao;

import java.util.List;

import com.test.domain.Provider;

public interface ProviderDAO {

	public List<Provider> getAllProviders();

	public List<Provider> getProviderByName(String name);
}
