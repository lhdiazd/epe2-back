package cl.epe2.services;

import org.springframework.stereotype.Service;


public interface IAuthService {
	
	public boolean userAuthenticate(String username, String password);

}
