package cl.epe2.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.epe2.models.Product;
import cl.epe2.models.Purchase;
import cl.epe2.models.PurchaseItem;
import cl.epe2.services.IAuthService;
import cl.epe2.services.IProductService;
import cl.epe2.services.IPurchaseItemService;
import cl.epe2.services.IPurchaseService;

@RestController
@RequestMapping("/api/purchases")
@CrossOrigin(origins = "*")
public class PurchaseController {

	@Autowired
	private IPurchaseService iPurchaseService;

	@Autowired
	private IAuthService iAuthService;

	@Autowired
	private IProductService iProductService;

	@Autowired
	private IPurchaseItemService iPurchaseItemService;

	@PostMapping("/save")
	public ResponseEntity<?> savePurchase(@RequestParam Long userId, @RequestBody List<Product> products) {
		Purchase purchase = new Purchase();
		purchase.setUser(iAuthService.getAuthenticatedUserById(userId));

		// Guardar la compra en la base de datos
		Purchase savedPurchase = iPurchaseService.savePurchase(purchase); // Guardar el Purchase primero

		// Crear PurchaseItem para cada producto y añadirlo a la lista de items
		Set<PurchaseItem> items = new HashSet<>();
		for (Product product : products) {
			PurchaseItem item = new PurchaseItem();
			item.setProduct(product);
			item.setPurchase(savedPurchase); // Establece la relación con la compra guardada
			PurchaseItem savedItem = iPurchaseItemService.savePurchaseItem(item); // Guardar el PurchaseItem
			items.add(savedItem); // Agregar el PurchaseItem guardado a la lista de items
			System.out.println(savedItem.getProduct().getName());
		}
		savedPurchase.setItems(items); // Establecer la lista de items en el Purchase guardado

		// Guardar la compra actualizada en la base de datos
		Purchase updatedPurchase = iPurchaseService.savePurchase(savedPurchase);
		return new ResponseEntity<>(updatedPurchase, HttpStatus.CREATED);
	}

	@GetMapping("/history/{userId}")
	public ResponseEntity<List<Purchase>> getPurchaseByUserId(@PathVariable Long userId) {
		List<Purchase> purchases = iPurchaseService.getByUserId(userId);
		return new ResponseEntity<>(purchases, HttpStatus.OK);
	}

}
