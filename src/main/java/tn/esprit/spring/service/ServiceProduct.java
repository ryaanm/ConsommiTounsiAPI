package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.ServiceInterface.IProductService;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.ProductRepository;

@Service
public class ServiceProduct implements IProductService {
	@Autowired
	ProductRepository pr;
	@Override
	public Product save(Product product) {
		 pr.save(product);
		return product;
	}

	@Override
	public List<Product> retrieveAllProduct() {
		List<Product> product = (List<Product>) pr.findAll();
		return product;
	}

	@Override
	public void deleteProduct(Long id) {
		Optional<Product> product = pr.findById(id);

		  if(product.isPresent()) 
		    {
		        pr.deleteById(id);}	
		
				
	}

	@Override
	public Product updateProduct(Product product) {
		 pr.save(product);
			return product;
	}

	@Override
	public Product retrieveProduct(Long id) {
		return pr.findById(id).get();
	}
}