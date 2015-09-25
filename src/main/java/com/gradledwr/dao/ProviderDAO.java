package com.gradledwr.dao;

import java.util.List;

import com.gradledwr.domain.Provider;

public interface ProviderDAO {

	public List<Provider> getAllProviders();

	public List<Provider> getProviderByName(String name);
}
