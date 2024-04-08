package cl.epe2.services;

import java.util.List;



import cl.epe2.models.Purchase;


public interface IPurchaseService {	
	public List<Purchase> getByUserId(Long userId);
	public Purchase savePurchase(Purchase purchase);
}
