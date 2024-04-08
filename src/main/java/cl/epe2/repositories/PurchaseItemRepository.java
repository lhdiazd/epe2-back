package cl.epe2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.epe2.models.PurchaseItem;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
	
	
}
