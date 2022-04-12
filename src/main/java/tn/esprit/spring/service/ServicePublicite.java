package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.ServiceInterface.IPubliciteService;
import tn.esprit.spring.entities.Publicite;
import tn.esprit.spring.repository.PubliciteRepository;

public class ServicePublicite implements IPubliciteService {
	@Autowired
	PubliciteRepository pr;
	@Override
	public Publicite save(Publicite publicite) {
		// TODO Auto-generated method stub
		return pr.save(publicite);
	}
	@Override
	public List<Publicite> retrieveAllPublicite() {
		// TODO Auto-generated method stub
		List<Publicite> publicite = (List<Publicite>) pr.findAll();
		return publicite;

	}

	@Override
	public void deletePublicite(long id) {
		// TODO Auto-generated method stub
Optional<Publicite> publicite = pr.findById(id);
	    
	    if(publicite.isPresent()) 
	    {
	        pr.deleteById(id);}	
	
	}

	/*@Override
	public Publicite updatePublicite(Publicite publicite) {
		// TODO Auto-generated method stub
		Optional<Publicite> pub = pr.findById(publicite.getId());
		if(pub.isPresent()) 
	    {
		     Publicite newPublicite= pub.get();
		     newPublicite.setDatedebut(publicite.getDatedebut());
		     newPublicite.setDatefin(publicite.getDatefin());
		     newPublicite.setId(publicite.getId());
		     newPublicite.setImage(publicite.getImage());
		     newPublicite.setNom(publicite.getNom());
	        return newPublicite;
	    } else {
	    	publicite = pr.save(publicite);
	         
	        return publicite;
	    }}*/
	
	@Autowired
	PubliciteRepository publiciteRepository;
	
	@Override
	public List<Object[]> getTopPub(){
		return publiciteRepository.TopPub();
	}
	
	@Override
	public Publicite updatePublicite(Publicite publicite) {
		// TODO Auto-generated method stub
		return pr.save(publicite);

}
	@Override
	public tn.esprit.spring.Entities.Publicite save(tn.esprit.spring.Entities.Publicite publicite) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public tn.esprit.spring.Entities.Publicite updatePublicite(tn.esprit.spring.Entities.Publicite publicite) {
		// TODO Auto-generated method stub
		return null;
	}
