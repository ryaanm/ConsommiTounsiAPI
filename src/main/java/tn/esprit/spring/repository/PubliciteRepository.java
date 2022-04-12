package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Publicite;
@Repository

public interface PubliciteRepository extends CrudRepository<Publicite, Long>{

}
