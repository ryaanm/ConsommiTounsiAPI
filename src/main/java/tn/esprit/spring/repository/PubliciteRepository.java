package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Publicite;
@Repository

public interface PubliciteRepository extends JpaRepository<Publicite, Long>{
	

	@Query("SELECT t FROM Publicite t WHERE t.nom LIKE %:nom%")
	    List<Publicite> PubliciteByName(@Param("nom") String nom);

}
