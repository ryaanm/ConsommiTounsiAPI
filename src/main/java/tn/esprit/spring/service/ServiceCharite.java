package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.ServiceInterface.IChariteService;
import tn.esprit.spring.entities.Charite;
import tn.esprit.spring.repository.ChariteRepository;

@Service
public class ServiceCharite implements IChariteService {
	@Autowired
	ChariteRepository cr;
	@Override
	public Charite save(Charite charite) {
		 cr.save(charite);
		return charite;
	}

	@Override
	public List<Charite> retrieveAllCharite() {
		List<Charite> charite = (List<Charite>) cr.findAll();
		return charite;
	}

	@Override
	public void deleteCharite(long id) {
		Optional<Charite> charite = cr.findById(id);

		  if(charite.isPresent()) 
		    {
		        cr.deleteById(id);}	
		
				
	}

	@Override
	public Charite updateCharite(Charite charite) {
		 cr.save(charite);
			return charite;
	}

	@Override
	public Charite retrieveCharite(Long id) {
		return cr.findById(id).get();
	}
}