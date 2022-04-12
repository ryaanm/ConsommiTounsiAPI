package tn.esprit.spring.ServiceInterface;

import java.util.List;

import tn.esprit.spring.entities.Publicite;

public interface IPubliciteService {
	public Publicite save(Publicite publicite);
	List<Publicite> retrieveAllPublicite();
	void deletePublicite(long id);
	Publicite updatePublicite(Publicite publicite);
}
