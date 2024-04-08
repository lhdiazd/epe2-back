package cl.epe2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.epe2.models.Product;
import cl.epe2.models.User;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findById(long id);
	
	List<Product> findAll();
}
