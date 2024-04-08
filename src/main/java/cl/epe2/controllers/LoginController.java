package cl.epe2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.epe2.models.User;
import cl.epe2.services.IAuthService;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	@Autowired
	private IAuthService iAuthService;

	@PostMapping("/api/login")
	public ResponseEntity<?> login(@RequestBody User user) {

		if (iAuthService.userAuthenticate(user.getUsername(), user.getPassword())) {
			System.out.println("login exitoso");
			User authenticatedUser = iAuthService.getAuthenticatedUser(user.getUsername());			
			return ResponseEntity.ok().body(authenticatedUser);
		} else {
			System.out.println("login invalido");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");

		}
	}
}
