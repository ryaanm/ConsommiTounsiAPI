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
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ; 
	private String title ; 
	private String description ;
	private Long quantity ; 
	private Float price ; 
    private Long codepr ;
    private String picture ; 

    public enum ProductCategory{
    	Clothes, Electrical;
    };
    @OneToMany(cascade = CascadeType.ALL , mappedBy="product")
    private Set<Comment> Comment;
    
    
    
}
