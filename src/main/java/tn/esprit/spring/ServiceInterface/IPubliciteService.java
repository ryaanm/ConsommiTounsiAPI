package tn.esprit.spring.ServiceInterface;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Publicite;

public interface IPubliciteService {
	public Publicite save(Publicite publicite, long idUser);
	List<Publicite> retrieveAllPublicite();
	Publicite retrievePublicite (Long id);
	void deletePublicite(Long id);
	Publicite updatePublicite(Publicite publicite);
	
	public float CanalCost (String Canal);
	public float DaysCost(String dateDebut, String dateFin);
	public float TotalCost(String Canal, Date dateDebut, Date dateFin);
}
