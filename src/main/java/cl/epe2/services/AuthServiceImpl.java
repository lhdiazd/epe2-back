package cl.epe2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.epe2.models.User;
import cl.epe2.repositories.UserRepository;

@Service
public class AuthServiceImpl implements IAuthService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean userAuthenticate(String username, String password) {
		User usuario = userRepository.findByUsername(username);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return true; 
        } else {
            return false; 
        }
	}

	@Override
	public User getAuthenticatedUser(String username) {
		
		return userRepository.findByUsername(username);
	}
	
	
	@Override
	public User getAuthenticatedUserById(Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		return userOptional.orElse(null);
	}

}
