package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idUser;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	private Set<Publicite> publicite;
	}
