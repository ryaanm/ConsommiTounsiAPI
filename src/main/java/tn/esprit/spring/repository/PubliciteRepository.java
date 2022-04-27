package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Publicite;
@Repository

public interface PubliciteRepository extends JpaRepository<Publicite, Long>{

}
