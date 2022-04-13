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

import tn.esprit.spring.ServiceInterface.IChariteService;
import tn.esprit.spring.entities.Charite;

@RestController
@RequestMapping("/charite")
public class ChariteController {

	@Autowired
	IChariteService ServiceCharite;

	@GetMapping("/retrieve-all-charities")
	@ResponseBody
	public List<Charite> getcharities() {
	List<Charite> listCharities = ServiceCharite.retrieveAllCharite();
	return listCharities;
}
	
	@GetMapping("/retrieve-charite/{charite-id}")
	@ResponseBody
	public Charite retrieveCharite(@PathVariable("charite-id") Long idCharite) {
	return ServiceCharite.retrieveCharite(idCharite);
	}

	@PostMapping("/add-charite")
	@ResponseBody
	public Charite addCharite(@RequestBody Charite o)
	{
		Charite charite= ServiceCharite.save(o);
	return charite;
	}
	@DeleteMapping("/remove-charite/{charite-id}")
	@ResponseBody
	public void removeCharite(@PathVariable("charite-id") Long idCharite) {
		ServiceCharite.deleteCharite(idCharite);
	}

	@PutMapping("/modify-charite")
	@ResponseBody
	public Charite modifyCharite(@RequestBody Charite charite) {
	return ServiceCharite.updateCharite(charite);
	}
}



	