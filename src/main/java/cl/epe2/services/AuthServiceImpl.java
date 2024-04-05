package cl.epe2.services;

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

}
