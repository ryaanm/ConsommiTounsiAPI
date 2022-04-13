package tn.esprit.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.ServiceInterface.IPubliciteService;

import tn.esprit.spring.entities.Abonnement;
import tn.esprit.spring.service.AbonnementService;
import tn.esprit.spring.service.EmailService;

@RestController
public class AbonnementController {

	@Autowired
	private AbonnementService abonnementService;

	@Autowired
	EmailService emailService;

	@PostMapping("/add")
	public Abonnement addAbonnement(@RequestBody Abonnement abonnement) {

		return abonnementService.addAbonnement(abonnement);

	}

	@PostMapping("update")
	public void updateAbonnement(Abonnement abonnement) {

		abonnementService.updateAbonnement(abonnement);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<HttpStatus> deleteAbonnement (@PathVariable("id") Long id) {

		abonnementService.deleteAbonnement(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@GetMapping("/byid/{id}")
	public Abonnement retrieveClient(@PathVariable("id") Long abonnementId) {
		return abonnementService.retrieveAbonnement(abonnementId);
	}

	@GetMapping("/getAll")
	public List<Abonnement> getAbonnements() {
		return abonnementService.retrieveAllAbonnements();
	}

	@PostMapping("/acceptAbonnement/{id}")
	public ResponseEntity<HttpStatus> acceptAbonnement(@PathVariable("id") Long id) {
		Abonnement a = abonnementService.retrieveAbonnement(id);
		StringBuilder str
		= new StringBuilder();
		str.append("Hello,");
		str.append("Your Subscription with id:"+ a.getIdAbonnement() + " is accepted,");

		emailService.sendSimpleMessage("eya.raddaoui@esprit.tn", "Demande Accepted", str.toString());

		return new ResponseEntity<>(HttpStatus.OK);
	}

}