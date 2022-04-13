package tn.esprit.spring.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.AbonnementRepository;
import tn.esprit.spring.entities.Abonnement;

@Service

public class AbonnementService {
	
	@Autowired
	private AbonnementRepository abonnementRepository;
	
	
	
	public Abonnement addAbonnement(Abonnement abonnement) {
		
		return abonnementRepository.saveAndFlush(abonnement);
		
	}
	
	public void updateAbonnement(Abonnement abonnement) {
		
			
		    Abonnement a = abonnementRepository.getById(abonnement.getIdAbonnement());	
		
			if(abonnement.getIdUser() != null)
			a.setIdUser(abonnement.getIdUser());
			
			if(abonnement.getPays() != null)
			a.setPays(abonnement.getPays());
			
			if(abonnement.getDateDebut() != null)
			a.setDateDebut(abonnement.getDateDebut());
			
			if(abonnement.getDateFin() != null)
			a.setDateFin(abonnement.getDateFin());
			
			abonnementRepository.saveAndFlush(a);

			
		
			
		
	}
	
	public void deleteAbonnement(Long id) {
		abonnementRepository.deleteById(id);
	}
	
	public List<Abonnement> retrieveAllAbonnements() {
		List<Abonnement> abonnement = (List<Abonnement>) abonnementRepository.findAll();
		return abonnement;
	}
	
	public Abonnement retrieveAbonnement(long id) {
		Abonnement a = null;
		try {
			a =abonnementRepository.findById(id).get();
		}
		catch(NoSuchElementException e) {
			return null;
		}
		return a;
	}
	
	
	
	
	}
	