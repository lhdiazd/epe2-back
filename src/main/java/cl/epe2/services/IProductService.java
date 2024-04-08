package cl.epe2.services;

import java.util.List;

import cl.epe2.models.Product;

public interface IProductService {
	public Product getProductById(Long productId);
	
	public List<Product> getAllProducts();
}
