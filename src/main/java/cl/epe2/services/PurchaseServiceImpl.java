package cl.epe2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.epe2.models.Purchase;
import cl.epe2.repositories.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements IPurchaseService {
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Override
	public List<Purchase> getByUserId(Long userId) {
		List<Purchase> purchases = purchaseRepository.findByUserId(userId);
		return purchases;
	}

	@Override
	public Purchase savePurchase(Purchase purchase) {
		
		return purchaseRepository.save(purchase);
	}

}
