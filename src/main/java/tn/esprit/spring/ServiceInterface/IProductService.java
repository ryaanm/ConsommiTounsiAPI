package tn.esprit.spring.ServiceInterface;


import java.util.List;

import tn.esprit.spring.entities.Product;

public interface IProductService {
	public Product save(Product product);
	List<Product> retrieveAllProduct();
	Product retrieveProduct (Long id);
	void deleteProduct(Long id);
	Product updateProduct(Product product);
}