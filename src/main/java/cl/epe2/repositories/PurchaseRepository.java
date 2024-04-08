package cl.epe2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.epe2.models.Product;
import cl.epe2.models.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	
	List<Purchase> findByUserId(Long userId);
}
