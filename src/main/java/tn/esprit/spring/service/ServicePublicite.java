package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.ServiceInterface.IPubliciteService;
import tn.esprit.spring.entities.Publicite;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.PubliciteRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class ServicePublicite implements IPubliciteService {
	@Autowired
	PubliciteRepository pr;
	
	@Autowired
	UserRepository userRepository;
	@Override
	public Publicite save(Publicite publicite, long idUser ) {
		
		User	user = userRepository.findById(idUser).orElse(null);
	
		publicite.setUser(user);
		 pr.save(publicite);
		return publicite;
	}

	@Override
	public List<Publicite> retrieveAllPublicite() {
		List<Publicite> publicite = (List<Publicite>) pr.findAll();
		return publicite;
	}

	@Override
	public void deletePublicite(Long id) {
		Optional<Publicite> publicite = pr.findById(id);

		  if(publicite.isPresent()) 
		    {
		        pr.deleteById(id);}	
		
				
	}

	@Override
	public Publicite updatePublicite(Publicite publicite) {
		 pr.save(publicite);
			return publicite;
	}

	@Override
	public Publicite retrievePublicite(Long id) {
		return pr.findById(id).get();
	}
}