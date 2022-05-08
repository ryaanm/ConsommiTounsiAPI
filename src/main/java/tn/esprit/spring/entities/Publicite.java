package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Publicite  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idPublicite;
	private String nom;
	@Temporal (TemporalType.DATE)
	private Date dateDebut;
	@Temporal (TemporalType.DATE)
	private Date dateFin;
	private String image;
	private long nbreVueInitial;
	private long nbreVueFinal;
	private String typePubicite;
	private int numPropPublicite;
	private float prixPublicite;
	private String description;
	@Enumerated(EnumType.STRING)
	private Canal canal ;
	@Enumerated(EnumType.STRING)
	private Cible cible;

	@ManyToOne(cascade = CascadeType.ALL)
	User user;
	public  float setPrixPublicite(float prixPublicite) {
		return this.prixPublicite = prixPublicite;
	}
}
