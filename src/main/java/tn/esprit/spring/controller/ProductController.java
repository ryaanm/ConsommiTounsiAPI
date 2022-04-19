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

import tn.esprit.spring.ServiceInterface.IProductService;
import tn.esprit.spring.entities.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductService ServiceProduct;

	@GetMapping("/retrieve-all-prods")
	@ResponseBody
	public List<Product> getProducts() {
	List<Product> listProducts = ServiceProduct.retrieveAllProduct();
	return listProducts;
}
	
	@GetMapping("/retrieve-product/{product-id}")
	@ResponseBody
	public Product retrieveProduct(@PathVariable("product-id") Long idProduct) {
	return ServiceProduct.retrieveProduct(idProduct);
	}

	@PostMapping("/add-product")
	@ResponseBody
	public Product addProduct(@RequestBody Product o )
	{
		Product product= ServiceProduct.save(o);
	return product;
	}
	@DeleteMapping("/remove-product/{product-id}")
	@ResponseBody
	public void removeProduct(@PathVariable("product-id") Long idProduct) {
		ServiceProduct.deleteProduct(idProduct);
	}

	@PutMapping("/modify-product")
	@ResponseBody
	public Product modifyProduct(@RequestBody Product product) {
	return ServiceProduct.updateProduct(product);
	}
}
