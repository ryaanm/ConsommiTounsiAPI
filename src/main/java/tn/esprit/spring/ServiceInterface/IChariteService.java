package tn.esprit.spring.ServiceInterface;

import java.util.List;

import tn.esprit.spring.entities.Charite;

public interface IChariteService {
	public Charite save(Charite charite);
	List<Charite> retrieveAllCharite();
	Charite retrieveCharite (Long id);
	void deleteCharite(long id);
	Charite updateCharite(Charite charite);
}
