package cl.epe2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.epe2.models.PurchaseItem;
import cl.epe2.repositories.PurchaseItemRepository;

@Service
public class PurchaseItemServiceImpl implements IPurchaseItemService {
	
	@Autowired
	PurchaseItemRepository purchaseItemRepository;
	
	@Override
	public PurchaseItem savePurchaseItem(PurchaseItem purchaseItem) {
		
		return purchaseItemRepository.save(purchaseItem);
	}

}
