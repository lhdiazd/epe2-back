package cl.epe2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.epe2.models.Product;
import cl.epe2.services.IProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private IProductService iProductService;

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = iProductService.getProductById(id);
		return ResponseEntity.ok(product);
	}

	
	@GetMapping("/list")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = iProductService.getAllProducts();
		return ResponseEntity.ok(products);
	}
}
