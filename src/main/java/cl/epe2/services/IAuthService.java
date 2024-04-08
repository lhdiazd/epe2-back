package cl.epe2.services;

import org.springframework.stereotype.Service;

import cl.epe2.models.User;


public interface IAuthService {
	
	public boolean userAuthenticate(String username, String password);
	
	public User getAuthenticatedUser(String username);
	
	public User getAuthenticatedUserById(Long userId);

}
