package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Charite;
@Repository
public interface ChariteRepository extends CrudRepository<Charite, Long> {
	@Query(value = "SELECT sum(montantpaye) FROM charite c WHERE `typecharite`='argent' ", nativeQuery = true)
	public Float TotalDonation();
}
