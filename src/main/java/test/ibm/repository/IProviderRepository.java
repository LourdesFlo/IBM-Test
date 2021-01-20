package test.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.ibm.entity.Provider;

@Repository
public interface IProviderRepository extends JpaRepository<Provider, Integer> {

}