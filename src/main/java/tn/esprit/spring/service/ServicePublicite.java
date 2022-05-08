package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		 
		return pr.save(publicite);
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

	@Override
	public float CanalCost(String Canal) {
		if ((Canal.equals("TWITTER"))){
			return 100;		
		} if((Canal.equals("FACEBOOK")|| (Canal.equals("INSTAGRAM")))) {
			return 150;
		}
		else return 200;
	}
		public float diffDays (String dateDebut, String dateFin) {
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
			float diffDays = 0;
			try {
				Date dateD = sdf.parse(dateDebut);
				Date dateF = sdf.parse(dateFin);
				long differenceTime
	            = dateF.getTime() - dateD.getTime();

				  diffDays  = (differenceTime/ (1000 * 60 * 60 * 24)) % 365;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return diffDays;
			
		}

	@Override
	public float DaysCost(String dateDebut, String dateFin) {
		float diff = diffDays(dateDebut, dateFin);
		float cost = 0;
		if(diff <= 30) {
			return cost = diff * 5;
		}if(diff >= 30 && diff <= 90) {
			return cost = diff * 10;
		} else {
			return cost = diff * 15;
		}
	}

	@Override
	public float TotalCost(String Canal, String dateDebut, String dateFin) {
		float cost = CanalCost(Canal);
		cost += DaysCost(dateDebut, dateFin);
		return cost;
	}
}