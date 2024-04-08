package cl.epe2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.epe2.models.Product;
import cl.epe2.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductById(Long productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		return optionalProduct.orElse(null);
	}

	@Override
	public List<Product> getAllProducts() {		
		return productRepository.findAll();
	}

}
