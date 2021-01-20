package test.ibm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.ibm.entity.Provider;
import test.ibm.repository.IProviderRepository;

@Service
public class DatabaseService {
	@Autowired
	private IProviderRepository providerRepository;

	public List<Provider> GetAll() {
		return providerRepository.findAll();
	}

	public Optional<Provider> GetById(final Integer providerId) {
		return providerRepository.findById(providerId);
	}

	public void CreateProvider(final Provider p) {
		providerRepository.save(p);
	}
}
