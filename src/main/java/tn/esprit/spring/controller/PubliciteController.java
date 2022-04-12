package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.ServiceInterface.IPubliciteService;
import tn.esprit.spring.entities.Publicite;

@RestController
@RequestMapping("/publicite")
public class PubliciteController {

	@Autowired
	IPubliciteService ServicePublicite;

	@GetMapping("/retrieve-all-pubs")
	@ResponseBody
	public List<Publicite> getPublicites() {
	List<Publicite> listPublicites = ServicePublicite.retrieveAllPublicite();
	return listPublicites;
}
	
	@GetMapping("/retrieve-publicite/{publicite-id}")
	@ResponseBody
	public Publicite retrievePublicite(@PathVariable("publicite-id") Long idPublicite) {
	return ServicePublicite.retrievePublicite(idPublicite);
	}

	@PostMapping("/add-publicite")
	@ResponseBody
	public Publicite addPublicite(@RequestBody Publicite o)
	{
		Publicite publicite= ServicePublicite.save(o);
	return publicite;
	}
	@DeleteMapping("/remove-publicite/{publicite-id}")
	@ResponseBody
	public void removePublicite(@PathVariable("publicite-id") Long idPublicite) {
		ServicePublicite.deletePublicite(idPublicite);
	}

	@PutMapping("/modify-publicite")
	@ResponseBody
	public Publicite modifyPublicite(@RequestBody Publicite publicite) {
	return ServicePublicite.updatePublicite(publicite);
	}
}
