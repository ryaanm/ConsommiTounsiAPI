package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.ServiceInterface.IPubliciteService;
import tn.esprit.spring.entities.Publicite;

@RestController
@RequestMapping("/publicite")
@CrossOrigin(origins = "http://localhost:4200")
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
	//method = RequestMethod.POST,
	//@PathVariable("user-id") Long idUser,
	//@PostMapping()
	@RequestMapping( value = "/add-publicite/{idUser}")
	@ResponseBody
	public Publicite addPublicite(@RequestBody Publicite o, @PathVariable long idUser)
	{

		Publicite publicite= ServicePublicite.save(o,idUser);
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
